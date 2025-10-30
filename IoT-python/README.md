"""
# 🌱 GitHerb - 스마트 식물 커뮤니티 플랫폼 - IoT 센서 데이터 수집 & 자동 제어 시스템

IoT 스마트팜 관리와 소셜 커뮤니티 기능을 결합한 식물 관리 통합 플랫폼입니다.
사용자는 식물을 모니터링하고, 경험을 공유하며, 식물 관리 일정을 한 곳에서 관리할 수 있습니다.
================================================================================
Raspberry Pi 기반 스마트팜 IoT 시스템
- 실시간 환경 센서 데이터 수집 (온습도, 조도, 토양수분)
- MariaDB 데이터베이스에 저장
- 자동/수동 액추에이터 제어 (펌프, 선풍기, LED)
- PIR 동작 감지

개발 기간: 2025.09.11 ~ 2025.09.24
================================================================================
"""

import time
import board
import adafruit_dht
import mysql.connector
import spidev
import RPi.GPIO as GPIO

# ============================================================================
# 📌 GPIO 핀 설정 (Raspberry Pi BCM 모드)
# ============================================================================
LED_PIN = 4          # 메인 보조 조명 LED
led_G = 20           # 녹색 LED (정상 상태)
led_Y = 26           # 노란색 LED (동작 감지)
pir_sensor_pin = 16  # PIR 센서 (동작 감지)
fan_A = 13           # 선풍기 컨트롤 A (정방향)
fan_B = 19           # 선풍기 컨트롤 B (역방향)
PUMP_PIN = 6         # 펌프 제어
ACTIVE_LOW = True    # ACTIVE_LOW: True면 LOW=ON, False면 HIGH=ON

# ============================================================================
# 🎛️ 제어 모드 설정 (AUTO 또는 MANUAL)
# ============================================================================
control_mode = {
    "PUMP": "AUTO",   # 펌프: 토양 수분 기반 자동 제어
    "FAN": "AUTO",    # 선풍기: 온습도 기반 자동 제어
    "LED": "AUTO"     # LED: 조도 기반 자동 제어
}

# 수동 제어 시 상태 저장
manual_states = {
    "PUMP": "OFF",
    "FAN": "OFF",
    "LED": "OFF"
}

# ============================================================================
# 🔧 액추에이터 제어 함수들
# ============================================================================

def pump_on():
    """펌프 ON - 물주기 시작"""
    if ACTIVE_LOW:
        GPIO.output(PUMP_PIN, GPIO.LOW)   # ACTIVE_LOW: LOW신호 = ON
    else:
        GPIO.output(PUMP_PIN, GPIO.HIGH)  # HIGH신호 = ON
    log_actuator("PUMP", "ON")

def pump_off():
    """펌프 OFF - 물주기 중지"""
    if ACTIVE_LOW:
        GPIO.output(PUMP_PIN, GPIO.HIGH)  # ACTIVE_LOW: HIGH신호 = OFF
    else:
        GPIO.output(PUMP_PIN, GPIO.LOW)   # LOW신호 = OFF
    log_actuator("PUMP", "OFF")

def fan_on():
    """선풍기 ON - 환기 시작"""
    GPIO.output(fan_A, GPIO.HIGH)  # 정방향 회전
    GPIO.output(fan_B, GPIO.LOW)
    log_actuator("FAN", "ON")

def fan_off():
    """선풍기 OFF - 환기 중지"""
    GPIO.output(fan_A, GPIO.LOW)
    GPIO.output(fan_B, GPIO.LOW)
    log_actuator("FAN", "OFF")

def led_on():
    """LED ON - 보조 조명 켜기"""
    GPIO.output(LED_PIN, GPIO.HIGH)
    log_actuator("LED", "ON")

def led_off():
    """LED OFF - 보조 조명 끄기"""
    GPIO.output(LED_PIN, GPIO.LOW)
    log_actuator("LED", "OFF")

# ============================================================================
# 🔌 GPIO 초기화
# ============================================================================
GPIO.setmode(GPIO.BCM)           # BCM 핀 모드 사용
GPIO.setwarnings(False)          # GPIO 경고 무시

# 출력 핀 설정
GPIO.setup(PUMP_PIN, GPIO.OUT)
GPIO.output(PUMP_PIN, GPIO.HIGH) # 초기 상태: OFF
GPIO.setup(LED_PIN, GPIO.OUT)
GPIO.output(LED_PIN, GPIO.LOW)   # 초기 상태: OFF
GPIO.setup(led_G, GPIO.OUT)
GPIO.setup(led_Y, GPIO.OUT)
GPIO.setup(fan_A, GPIO.OUT)
GPIO.setup(fan_B, GPIO.OUT)

# 입력 핀 설정
GPIO.setup(pir_sensor_pin, GPIO.IN)  # PIR 센서 입력

# ============================================================================
# 🌡️ DHT-22 센서 초기화 (온습도 센서)
# ============================================================================
sensor_dht = adafruit_dht.DHT22(board.D17, use_pulseio=False)

# ============================================================================
# 🆔 Raspberry Pi 시리얼 번호 조회
# ============================================================================
def get_raspberry_serial():
    """
    /proc/cpuinfo에서 Raspberry Pi 고유 시리얼 번호 추출
    - 여러 개의 라즈베리파이 기기 구분에 사용
    - DB 저장 시 어느 기기인지 식별 가능
    """
    try:
        with open('/proc/cpuinfo', 'r') as f:
            for line in f:
                if line.startswith('Serial'):
                    return line.split(':')[1].strip()
        return "Unknown"
    except Exception as e:
        print(f"Error reading serial: {e}")
        return "Unknown"

my_device_serial = get_raspberry_serial()

if my_device_serial and my_device_serial != "Unknown":
    print(f"✅ Detected Raspberry Pi Serial: {my_device_serial}")
else:
    print("⚠️ Warning: Could not detect Raspberry Pi Serial")

# ============================================================================
# 💾 MariaDB 데이터베이스 연결 설정
# ============================================================================
DB_CONFIG = {
    'host': '192.168.30.97',  # 데이터베이스 서버 IP
    'user': 'rb',              # DB 사용자
    'password': 'mariadb',     # DB 비밀번호
    'database': 'team_db'      # 사용 데이터베이스
}

conn = None
cursor = None

try:
    # 데이터베이스 연결
    conn = mysql.connector.connect(**DB_CONFIG)
    cursor = conn.cursor()
    
    # ========================================================================
    # 📊 테이블 1: sensor_data (센서 데이터 저장)
    # ========================================================================
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS sensor_data (
        ENV_NUM INT PRIMARY KEY AUTO_INCREMENT,           -- 센서 데이터 고유 ID
        SENSOR_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 수집 시간
        TEMPERATURE FLOAT,                               -- 온도 (℃)
        HUMIDITY FLOAT,                                  -- 습도 (%)
        ILLUMINANCE FLOAT,                               -- 조도 (Lux)
        SOIL_MOISTURE FLOAT,                             -- 토양 수분 (%)
        RASP_NUM VARCHAR(50)                             -- 라즈베리파이 시리얼
    )
    """)
    conn.commit()

    # ========================================================================
    # 📊 테이블 2: actuator_log (액추에이터 작동 로그)
    # ========================================================================
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS actuator_log (
        LOG_ID INT PRIMARY KEY AUTO_INCREMENT,           -- 로그 고유 ID
        ACT_NAME VARCHAR(50) NOT NULL,                   -- 액추에이터 이름 (PUMP/FAN/LED/MOTION)
        RASP_NUM VARCHAR(50),                            -- 라즈베리파이 시리얼
        STATE ENUM('ON', 'OFF') NOT NULL,                -- 상태 (ON/OFF)
        EVENT_TIME DATETIME DEFAULT CURRENT_TIMESTAMP    -- 작동 시간
    )
    """)
    conn.commit()
    
    # ========================================================================
    # 📊 테이블 3: actuator_control (액추에이터 제어 명령)
    # ========================================================================
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS actuator_control (
        CONTROL_ID INT PRIMARY KEY AUTO_INCREMENT,       -- 제어 ID
        ACT_NAME VARCHAR(50) NOT NULL,                   -- 액추에이터 이름
        RASP_NUM VARCHAR(50),                            -- 라즈베리파이 시리얼
        COMMAND ENUM('ON', 'OFF', 'AUTO') NOT NULL,      -- 제어 명령
        MODE ENUM('AUTO', 'MANUAL') DEFAULT 'AUTO',      -- 모드 (자동/수동)
        CREATED_TIME DATETIME DEFAULT CURRENT_TIMESTAMP, -- 명령 생성 시간
        PROCESSED BOOLEAN DEFAULT FALSE,                 -- 처리 완료 여부
        INDEX idx_processed (PROCESSED, RASP_NUM)        -- 인덱스 (빠른 조회)
    )
    """)
    conn.commit()
    
    print("✅ Database tables initialized successfully")
    
except mysql.connector.Error as err:
    print(f"❌ Database error: {err}")
    GPIO.cleanup()
    exit()

# ============================================================================
# 🔌 SPI 설정 (센서 통신 인터페이스)
# ============================================================================
spi = spidev.SpiDev()
spi.open(0, 0)                   # SPI 포트 0, 칩셀렉트 0 열기
spi.max_speed_hz = 1000000       # 1MHz 속도

# ============================================================================
# 📡 센서 채널 설정
# ============================================================================
ldr_channel = 0                  # LDR (조도 센서) - ADC 채널 0
R_FIXED = 10000.0                # 고정 저항값 (10kΩ)
CALIBRATION_CONSTANT_LUX = 1.86  # 조도 보정 상수

soil_moisture_channel = 1         # 토양 수분 센서 - ADC 채널 1
SOIL_MIN = 0                      # 토양 센서 최소값
SOIL_MAX = 1023                   # 토양 센서 최대값

# ============================================================================
# 🌿 바질(Basil) 최적 환경 조건
# ============================================================================
BASIL_OPTIMAL_SOIL_MOISTURE_MIN = 25    # 토양 수분 최소 (%)
BASIL_OPTIMAL_SOIL_MOISTURE_MAX = 40    # 토양 수분 최대 (%)
BASIL_OPTIMAL_LUX_MIN = 20000           # 조도 최소 (Lux)
BASIL_OPTIMAL_LUX_MAX = 60000           # 조도 최대 (Lux)
BASIL_OPTIMAL_TEMP_MIN = 20             # 온도 최소 (℃)
BASIL_OPTIMAL_TEMP_MAX = 30             # 온도 최대 (℃)
BASIL_OPTIMAL_HUMIDITY_MIN = 40         # 습도 최소 (%)
BASIL_OPTIMAL_HUMIDITY_MAX = 60         # 습도 최대 (%)

# ============================================================================
# 🔧 센서 데이터 변환 함수들
# ============================================================================

def soil_moisture_percent(raw_value):
    """
    토양 센서 원본값(0-1023)을 퍼센트(0-100%)로 변환
    - 높은 값 = 건조함
    - 낮은 값 = 습함
    """
    if raw_value is None:
        return None
    moisture_percent = ((SOIL_MAX - raw_value) / (SOIL_MAX - SOIL_MIN)) * 100
    return round(max(0, min(100, moisture_percent)), 1)

def readadc(adcnum):
    """
    SPI를 통해 ADC 값 읽기 (MCP3008 ADC 칩)
    - 0-7번 채널 중 하나 선택 가능
    - 10비트 분해능 (0-1023)
    """
    if adcnum > 7 or adcnum < 0:
        return -1
    r = spi.xfer2([1, (8 + adcnum) << 4, 0])
    data = ((r[1] & 3) << 8) + r[2]
    return data

def calculate_ldr_resistance(adc_value):
    """
    ADC 값을 LDR 저항값으로 변환
    공식: R_LDR = R_FIXED * (ADC_VALUE / (1024 - ADC_VALUE))
    """
    if adc_value is None or adc_value <= 0:
        return float('inf')
    if adc_value >= 1023:
        return 0.0
    resistance_ldr = R_FIXED * (adc_value / (1024.0 - adc_value))
    return resistance_ldr

def convert_resistance_to_lux(ldr_resistance):
    """
    LDR 저항값을 조도(Lux)로 변환
    공식: Lux = CALIBRATION_CONSTANT * LDR_RESISTANCE
    """
    if ldr_resistance is None:
        return None
    if ldr_resistance == float('inf'):
        return 0.0
    if ldr_resistance <= 0:
        return 0.0
    lux = CALIBRATION_CONSTANT_LUX * ldr_resistance
    return int(lux)

# ============================================================================
# 📝 로깅 및 제어 함수
# ============================================================================

prev_states = {
    "FAN": None,
    "PUMP": None,
    "LED": None,
    "MOTION": None
}

def log_actuator(act_name, state):
    """
    액추에이터 상태 변화만 DB에 기록
    - 상태가 변할 때만 로그 저장 (중복 방지)
    - 언제 어떤 기기가 켜졌는지 추적 가능
    """
    global prev_states
    
    # 이전 상태와 동일하면 기록 안 함 (중복 방지)
    if prev_states.get(act_name) == state:
        return 
    
    try:
        cursor.execute(
            "INSERT INTO actuator_log (ACT_NAME, RASP_NUM, STATE) VALUES (%s, %s, %s)",
            (act_name, my_device_serial, state)
        )
        conn.commit()
        prev_states[act_name] = state
        print(f"[LOG] {act_name} -> {state} Recorded")
    except mysql.connector.Error as e:
        print(f"❌ Actuator log error: {e}")

last_sensor_insert = 0  # 마지막 센서 데이터 저장 시간
last_control_check = 0  # 마지막 제어 명령 확인 시간

print("✅ PIR Ready...")
time.sleep(1)

# ============================================================================
# 🔄 센서 수집 함수 (재시도 로직 포함)
# ============================================================================

def read_dht_with_retry(max_retries=3, delay=2):
    """
    DHT-22 센서에서 온습도 데이터 읽기
    - 읽기 실패 시 최대 3회까지 자동 재시도
    - 센서 통신 불안정성 대비
    - 성공 시 (온도, 습도) 반환, 실패 시 (None, None) 반환
    """
    for attempt in range(max_retries):
        try:
            temp = sensor_dht.temperature
            humid = sensor_dht.humidity
            
            # 유효한 데이터 수신 확인
            if temp is not None and humid is not None:
                return temp, humid
            
            print(f"⚠️ DHT retry {attempt + 1}")
            time.sleep(delay)
            
        except RuntimeError as e:
            print(f"❌ DHT error {attempt + 1}: {e}")
            if attempt < max_retries - 1:
                time.sleep(delay)
    
    return None, None

# ============================================================================
# 📱 웹/앱에서 수동 제어 명령 확인
# ============================================================================

def check_manual_control():
    """
    DB의 actuator_control 테이블에서 미처리 명령 조회
    - 웹/모바일 앱에서 보낸 제어 명령 실행
    - 웹 UI에서 펌프/팬/LED 수동 제어 가능
    - 명령 실행 후 PROCESSED = TRUE로 업데이트
    """
    global control_mode, manual_states
    
    try:
        # 미처리 명령 조회 (PROCESSED = FALSE)
        cursor.execute("""
            SELECT CONTROL_ID, ACT_NAME, COMMAND, MODE
            FROM actuator_control
            WHERE RASP_NUM = %s AND PROCESSED = FALSE
            ORDER BY CREATED_TIME ASC
        """, (my_device_serial,))
        
        commands = cursor.fetchall()
        
        for control_id, act_name, command, mode in commands:
            print(f"📱 [MANUAL COMMAND] {act_name} -> {command} ({mode})")
            
            if mode == "MANUAL":
                # 수동 모드: 명령 즉시 실행
                control_mode[act_name] = "MANUAL"
                manual_states[act_name] = command
                
                if act_name == "PUMP":
                    if command == "ON":
                        pump_on()
                    else:
                        pump_off()
                elif act_name == "FAN":
                    if command == "ON":
                        fan_on()
                    else:
                        fan_off()
                elif act_name == "LED":
                    if command == "ON":
                        led_on()
                    else:
                        led_off()
                        
            elif command == "AUTO":
                # 자동 모드로 전환
                control_mode[act_name] = "AUTO"
                print(f"🔄 [MODE CHANGE] {act_name} -> AUTO")
            
            # 명령 처리 완료 표시
            cursor.execute("""
                UPDATE actuator_control
                SET PROCESSED = TRUE
                WHERE CONTROL_ID = %s
            """, (control_id,))
            conn.commit()
            
    except mysql.connector.Error as e:
        print(f"❌ Manual control check error: {e}")

# ============================================================================
# 🤖 자동 제어 로직 함수들
# ============================================================================

def auto_control_pump(soil_moisture_percent_value):
    """
    토양 수분 기반 펌프 자동 제어
    - 토양 수분 < 최소값 → 펌프 ON (물 공급)
    - 토양 수분 >= 최소값 → 펌프 OFF
    """
    if control_mode["PUMP"] == "MANUAL":
        return  # 수동 모드면 자동 제어 무시
    
    if soil_moisture_percent_value is not None:
        if soil_moisture_percent_value < BASIL_OPTIMAL_SOIL_MOISTURE_MIN:
            print("💧 Soil low - Pump ON (AUTO)")
            pump_on()
        else:
            pump_off()
            print("💧 Pump OFF (AUTO)")

def auto_control_fan(temperature, humidity):
    """
    온습도 기반 선풍기 자동 제어
    - 온도 > 최대값 OR 습도 > 최대값 → 팬 ON (환기)
    - 그 외 → 팬 OFF
    """
    if control_mode["FAN"] == "MANUAL":
        return  # 수동 모드면 자동 제어 무시
    
    if (temperature is not None and temperature > BASIL_OPTIMAL_TEMP_MAX) or \
       (humidity is not None and humidity > BASIL_OPTIMAL_HUMIDITY_MAX):
        fan_on()
        print("💨 FAN ON (AUTO)")
    else:
        fan_off()
        print("💨 FAN OFF (AUTO)")

def auto_control_led(lux_out_of_range):
    """
    조도 기반 LED 보조 조명 자동 제어
    - 조도가 범위 벗어남 → LED ON (보조 조명)
    - 조도가 범위 내 → LED OFF
    """
    if control_mode["LED"] == "MANUAL":
        return  # 수동 모드면 자동 제어 무시
    
    if lux_out_of_range:
        led_on()
        print("💡 LED ON (AUTO)")
    else:
        led_off()
        print("💡 LED OFF (AUTO)")

# ============================================================================
# ♾️ 메인 루프 - 1초 주기로 센서 수집 및 제어 실행
# ============================================================================

try:
    while True:
        lux_out_of_range_alert = False

        try:
            now = time.time()
            
            # ====================================================================
            # 1️⃣ 1초마다 수동 제어 명령 확인 (웹/앱에서의 명령)
            # ====================================================================
            if now - last_control_check >= 1:
                check_manual_control()
                last_control_check = now

            # ====================================================================
            # 2️⃣ DHT-22 센서에서 온습도 읽기 (재시도 포함)
            # ====================================================================
            temperature, humidity = read_dht_with_retry(max_retries=3, delay=2)

            if temperature is None or humidity is None:
                print("⚠️ Warning: DHT failed")

            # ====================================================================
            # 3️⃣ LDR 센서에서 조도 읽기 및 변환
            # ====================================================================
            raw_ldr_value = readadc(ldr_channel)
            estimated_lux = None
            if raw_ldr_value != -1:
                ldr_res = calculate_ldr_resistance(raw_ldr_value)
                estimated_lux = convert_resistance_to_lux(ldr_res)

            # ====================================================================
            # 4️⃣ 토양 수분 센서 읽기 및 변환
            # ====================================================================
            soil_moisture_raw = readadc(soil_moisture_channel)
            soil_moisture_percent_value = None
            if soil_moisture_raw != -1:
                soil_moisture_percent_value = soil_moisture_percent(soil_moisture_raw)

            # ====================================================================
            # 5️⃣ 현재 센서 데이터 출력
            # ====================================================================
            print("=" * 60)
            print(f"🌿 Basil Environment:")
            print(f"Mode - PUMP:{control_mode['PUMP']} FAN:{control_mode['FAN']} LED:{control_mode['LED']}")

            if temperature is not None:
                print(f"🌡️ Temp: {temperature:.1f}°C (Opt: {BASIL_OPTIMAL_TEMP_MIN}-{BASIL_OPTIMAL_TEMP_MAX}°C)")
            else:
                print("🌡️ Temp: N/A")

            if humidity is not None:
                print(f"💧 Humidity: {humidity:.1f}% (Opt: {BASIL_OPTIMAL_HUMIDITY_MIN}-{BASIL_OPTIMAL_HUMIDITY_MAX}%)")
            else:
                print("💧 Humidity: N/A")

            if estimated_lux is not None:
                print(f"💡 Lux: {estimated_lux:.0f} (Opt: {BASIL_OPTIMAL_LUX_MIN}-{BASIL_OPTIMAL_LUX_MAX})")
                # 조도가 최적 범위 벗어났는지 확인
                if not (BASIL_OPTIMAL_LUX_MIN <= estimated_lux <= BASIL_OPTIMAL_LUX_MAX):
                    lux_out_of_range_alert = True
            else: 
                print("💡 Lux: N/A")

            if soil_moisture_percent_value is not None:
                print(f"🌱 Soil: {soil_moisture_percent_value:.1f}% (Opt: {BASIL_OPTIMAL_SOIL_MOISTURE_MIN}-{BASIL_OPTIMAL_SOIL_MOISTURE_MAX}%)")
            else:
                print("🌱 Soil: N/A")

            # ====================================================================
            # 6️⃣ 자동 제어 실행
            # ====================================================================
            auto_control_pump(soil_moisture_percent_value)
            auto_control_fan(temperature, humidity)
            auto_control_led(lux_out_of_range_alert)

            # ====================================================================
            # 7️⃣ PIR 센서 (동작 감지)
            # ====================================================================
            if GPIO.input(pir_sensor_pin) == GPIO.HIGH:
                GPIO.output(led_Y, GPIO.HIGH)  # 노란색 LED 점등
                GPIO.output(led_G, GPIO.LOW)
                log_actuator("MOTION", "ON")
                print("👁️ Motion Detected!")
            else:
                GPIO.output(led_G, GPIO.HIGH)  # 녹색 LED 점등
                GPIO.output(led_Y, GPIO.LOW)
                log_actuator("MOTION", "OFF")
                print("👁️ No Motion")

            # ====================================================================
            # 8️⃣ 2초 주기로 센서 데이터 DB에 저장
            # ====================================================================
            if now - last_sensor_insert >= 2:
                # NULL 데이터는 DB에 저장하지 않음 (데이터 품질 보장)
                if temperature is None or humidity is None:
                    print("⏭️ Skip DB: Temp/Humidity None")
                else:
                    try:
                        cursor.execute(
                            """INSERT INTO sensor_data 
                               (TEMPERATURE, HUMIDITY, ILLUMINANCE, SOIL_MOISTURE, RASP_NUM) 
                               VALUES (%s, %s, %s, %s, %s)""",
                            (temperature, humidity, estimated_lux, soil_moisture_percent_value, my_device_serial)
                        )
                        conn.commit()
                        last_sensor_insert = now
                        print("💾 Data saved to DB")
                    except mysql.connector.Error as db_err:
                        print(f"❌ DB insert error: {db_err}")

            # ====================================================================
            # ⏱️ 1초 대기
            # ====================================================================
            time.sleep(1)

        except RuntimeError as error:
            print(f"❌ DHT Error: {error}")
            time.sleep(2)
        except Exception as e:
            print(f"❌ Loop error: {e}")
            time.sleep(2)

except KeyboardInterrupt:
    print("\n🛑 Program stopped by user")
finally:
    # ========================================================================
    # 🔌 정리 작업 - 모든 리소스 해제
    # ========================================================================
    try:
        # 모든 액추에이터 OFF
        GPIO.output(LED_PIN, GPIO.LOW)
        GPIO.output(fan_A, GPIO.LOW)
        GPIO.output(fan_B, GPIO.LOW)
        GPIO.output(PUMP_PIN, GPIO.HIGH)  # ACTIVE_LOW: HIGH = OFF
    except Exception:
        pass
    
    # GPIO 정리
    GPIO.cleanup()
    
    # SPI 연결 종료
    try:
        if spi:
            spi.close()
    except Exception:
        pass
    
    # 데이터베이스 커서 종료
    try:
        if cursor:
            cursor.close()
    except Exception:
        pass
    
    # 데이터베이스 연결 종료
    try:
        if conn:
            conn.close()
    except Exception:
        pass
    
    print("✅ Cleanup done. Exit.")

