# 🌱 GitHerb - 식물 커뮤니티 플랫폼

> 3단계 프로젝트로 완성한 IoT 스마트팜 + 웹/모바일 커뮤니티 통합 플랫폼

![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=java)
![Python](https://img.shields.io/badge/Python-3.9+-3776AB?style=flat-square&logo=python)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.9-6DB33F?style=flat-square&logo=spring-boot)
![React](https://img.shields.io/badge/React-18.2.0-61DAFB?style=flat-square&logo=react)
![React Native](https://img.shields.io/badge/React%20Native-0.81.4-61DAFB?style=flat-square&logo=react)
![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-010101?style=flat-square)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=flat-square&logo=mariadb)
![Raspberry Pi](https://img.shields.io/badge/Raspberry%20Pi-IoT-C51A4A?style=flat-square&logo=raspberry-pi)

---

## 📋 프로젝트 개요

GitHerb는 3단계 프로젝트로 진행되는 식물 애호가들을 위한 종합 플랫폼으로, 
IoT 스마트팜 기술과 웹/모바일 커뮤니티 기능을 단계별로 구축했습니다.

- **1️⃣ IoT 기기 개발**: Raspberry Pi 센서 수집 및 자동 제어 알고리즘
- **2️⃣ 웹 플랫폼**: React 기반 스마트팜 관리 및 커뮤니티 구축
- **3️⃣ 모바일 앱**: React Native 기반 IoT 연동 및 실시간 채팅

---

## 🎯 프로젝트 단계별 구성

### 📅 Timeline

| 단계 | 기간 | 주제 | 기술 스택 |
|------|------|------|---------|
| **1️⃣ IoT 개발** | 2025.09.11 ~ 09.24 | 스마트팜 IoT 기기 개발 및 자동제어 알고리즘 구축 | Python, Raspberry Pi, GPIO, MySQL |
| **2️⃣ 웹 개발** | 2025.09.25 ~ 10.16 | React 기반 식물 커뮤니티 구축 (웹) | React, Spring Boot, MariaDB, Chart.js |
| **3️⃣ 앱 개발** | 2025.10.17 ~ 11.14 | React Native 기반 IoT 연동 및 실시간 채팅 | React Native, Expo, WebSocket, Spring Boot |

---
## 📊 데이터베이스 설계

### ERD (Entity Relationship Diagram)

![ERD Diagram](./images/ERD관계도.png)

## 🔗 단계별 프로젝트 상세

### 1️⃣ IoT 기기 개발 (2025.09.11 ~ 09.24)

#### 🎯 프로젝트 목표
- Raspberry Pi와 센서를 활용한 실시간 환경 모니터링 시스템 구축
- 식물 최적 환경 조건에 맞춘 자동 제어 알고리즘 개발
- 센서 데이터 정확성 95% 이상 달성

#### 💻 기술 스택
- **Hardware**: Raspberry Pi, DHT-22 (온습도), LDR+ADC (조도), 토양수분 센서
- **Language**: Python 3.9+
- **Database**: MariaDB 10.x
- **Libraries**: Adafruit DHT, RPi.GPIO, mysql-connector-python, spidev

#### 🛠 주요 구현 내용

**하드웨어 구성**
```
Raspberry Pi
├── GPIO (온습도 센서, LED, 펌프, 팬 제어)
├── SPI (LDR 센서 - 조도 측정)
└── I2C (토양 수분 센서)
```

**센서 데이터 수집 (1초 주기)**

```python
def read_dht_with_retry(max_retries=3, delay=2):
    """DHT-22 센서에서 온습도 데이터 수집 (재시도 로직)"""
    for attempt in range(max_retries):
        try:
            temp = sensor_dht.temperature
            humid = sensor_dht.humidity
            
            if temp is not None and humid is not None:
                return temp, humid
            
            time.sleep(delay)
        except RuntimeError as e:
            print(f"DHT error {attempt + 1}: {e}")
            if attempt < max_retries - 1:
                time.sleep(delay)
    
    return None, None
```

**환경 데이터 계산**

```python
def calculate_ldr_resistance(adc_value):
    """ADC 값을 LDR 저항으로 변환"""
    resistance_ldr = R_FIXED * (adc_value / (1024.0 - adc_value))
    return resistance_ldr

def convert_resistance_to_lux(ldr_resistance):
    """LDR 저항을 조도(Lux)로 변환"""
    lux = CALIBRATION_CONSTANT_LUX * ldr_resistance
    return int(lux)

def soil_moisture_percent(raw_value):
    """토양 수분 센서 값을 퍼센트로 변환"""
    moisture_percent = ((SOIL_MAX - raw_value) / (SOIL_MAX - SOIL_MIN)) * 100
    return round(max(0, min(100, moisture_percent)), 1)
```

**자동 제어 알고리즘**

```python
def auto_control_pump(soil_moisture_percent_value):
    """토양 수분 기반 펌프 자동 제어"""
    if soil_moisture_percent_value < BASIL_OPTIMAL_SOIL_MOISTURE_MIN:
        pump_on()  # 물주기
    else:
        pump_off()

def auto_control_fan(temperature, humidity):
    """온습도 기반 선풍기 자동 제어"""
    if (temperature > BASIL_OPTIMAL_TEMP_MAX) or \
       (humidity > BASIL_OPTIMAL_HUMIDITY_MAX):
        fan_on()  # 환기
    else:
        fan_off()

def auto_control_led(lux_out_of_range):
    """조도 기반 LED 보조 조명 자동 제어"""
    if lux_out_of_range:
        led_on()  # 보조 조명
    else:
        led_off()
```

#### 📊 주요 성과
- ✅ 센서 데이터 수집 성공률 **95% 이상** 달성
- ✅ null 값 필터링으로 DB 오류 데이터 완전 제거
- ✅ 3회 재시도 로직으로 안정성 확보
- ✅ 바질(Basil) 최적 환경 조건 기반 자동 제어

#### 📁 프로젝트 구조
```
workspace/
├── iot_sensor_collection.py      # 메인 센서 수집 로직
├── sensor_config.py              # 센서 설정
├── actuator_control.py           # 액추에이터 제어
└── database_schema.sql           # MariaDB 테이블 정의
```

#### 🎥 시연 영상
- [IoT 센서 데이터 수집 시연](https://youtube.com/watch?v=xxx) (예정)
- [자동 제어 알고리즘 시연](https://youtube.com/watch?v=xxx) (예정)

---

### 2️⃣ React 웹 개발 (2025.09.25 ~ 10.16)

#### 🎯 프로젝트 목표
- IoT 센서 데이터를 시각화하는 웹 대시보드 구축
- 식물 커뮤니티 및 게시판 기능 개발
- 실시간 쪽지 시스템 구현

#### 💻 기술 스택
- **Frontend**: React 18.2.0, Vite, Axios
- **UI/Visualization**: Chart.js, React Big Calendar, React Quill
- **Backend**: Spring Boot 3.4.9
- **Database**: MariaDB 10.x
- **API**: RESTful API + Proxy

#### 🛠 주요 구현 내용

**MyFarm - 스마트팜 관리**
- 1초 주기 실시간 센서 데이터 갱신
- 온도, 습도, 조도, 토양수분 시각화
- 식물별 최적 환경 조건 표시 (🟢 적합 / 🔴 부적합)

```javascript
// 센서 데이터 실시간 갱신
useEffect(() => {
  const interval = setInterval(async () => {
    const data = await fetchSensorData();
    setSensorData(data);
  }, 1000);
  
  return () => clearInterval(interval);
}, []);
```

**Chart.js 데이터 시각화**
- 온도/습도/토양수분: 영역 차트 (트렌드)
- 조도: 막대 차트 (비교)
- 기간별 데이터 집계 (오늘/7일/30일)

**커뮤니티 게시판**
- React Quill 리치 텍스트 에디터
- 이미지 업로드 및 관리
- 댓글 및 대댓글 지원
- 좋아요 시스템

**마이페이지 - 식물 캘린더**
- React Big Calendar 통합
- 물주기 반복 일정 설정
- 식물 다이어리 작성
- 한국 공휴일 자동 표시

**쪽지 시스템**
- 받은/보낸 쪽지 분리 관리
- 3가지 발송 모드 (단일/다중/전체)
- 실시간 읽지 않은 쪽지 알림
- 100초마다 자동 갱신

#### 📊 주요 성과
- ✅ 1초 주기 센서 데이터 실시간 갱신
- ✅ 아름다운 Chart.js 그래프 시각화
- ✅ 직관적인 캘린더 기반 일정 관리
- ✅ 이벤트 기반 크로스 컴포넌트 실시간 업데이트

#### 📁 프로젝트 구조
```
frontend_plant_comunity/
├── src/page/
│   ├── MyFarm/                   # 스마트팜 관리
│   │   ├── MyPlantInfo.jsx       # 센서 데이터
│   │   └── EnvironmentInfo.jsx   # 그래프 시각화
│   ├── Board/                    # 게시판
│   ├── MyPage/                   # 마이페이지
│   │   ├── Calendar.jsx          # 캘린더
│   │   └── Diary.jsx             # 다이어리
│   └── Main.jsx                  # 홈 화면
├── components/
│   └── message/                  # 쪽지 시스템
└── vite.config.js
```

#### 🎥 시연 영상
- [MyFarm 센서 시각화](https://youtube.com/watch?v=xxx) (예정)
- [게시판 및 커뮤니티](https://youtube.com/watch?v=xxx) (예정)
- [캘린더 및 쪽지](https://youtube.com/watch?v=xxx) (예정)

---

### 3️⃣ React Native 앱 개발 (2025.10.17 ~ 11.14)

#### 🎯 프로젝트 목표
- 크로스 플랫폼 모바일 앱 개발 (iOS/Android)
- WebSocket 기반 실시간 채팅 시스템 구현
- IoT 데이터와 커뮤니티 기능의 완전한 통합

#### 💻 기술 스택
- **Framework**: React Native 0.81.4, Expo ~54.0.13
- **Routing**: Expo Router ~6.0.11
- **Real-time**: WebSocket (@stomp/stompjs), SockJS
- **HTTP Client**: Axios
- **Storage**: AsyncStorage
- **Backend**: Spring Boot 3.4.9

#### 🛠 주요 구현 내용

**실시간 채팅 시스템**

```javascript
// WebSocket 연결 (싱글톤 패턴)
connect(onConnected, onError) {
  if (this.client && (this.connected || this.client.active)) {
    console.log('WebSocket이 이미 연결되어 있습니다');
    if (onConnected) onConnected();
    return;
  }

  // 기존 클라이언트 정리
  if (this.client) {
    try {
      this.client.deactivate();
    } catch (e) {
      console.warn('기존 클라이언트 정리 중 에러:', e);
    }
  }
  
  // 새로운 연결 생성
  this.client = new Client({
    brokerURL: 'ws://192.168.30.97:8080/ws',
    onConnect: onConnected,
    onError: onError
  });
  
  this.client.activate();
}
```

**1:1 및 그룹 채팅**
- 동적 채팅방 이름 생성
- 프로필 이미지 그리드 (2x2)
- 메시지 타입 지원 (텍스트/이미지/파일)
- 이미지 전체화면 뷰어
- 파일 다운로드/열기

**채팅방 목록 실시간 업데이트**

```javascript
// 메시지 수신 시 FlatList 강제 리렌더링
const [refreshKey, setRefreshKey] = useState(0);

// 새 메시지 수신
onStompMessage(() => {
  setRefreshKey(prev => prev + 1);
});

<FlatList
  key={refreshKey}
  extraData={refreshKey}
  keyExtractor={(item) => `${item.roomId}-${refreshKey}`}
/>
```

**게시판 및 커뮤니티**
- 게시글 작성/수정/삭제
- 댓글 및 대댓글
- 좋아요 시스템
- 검색 기능

**마이페이지**
- 프로필 관리
- 내가 쓴 글 목록
- 캘린더 일정 관리

#### 📊 주요 성과
- ✅ WebSocket 싱글톤으로 안정적인 연결 관리
- ✅ FlatList 최적화로 효율적 리렌더링
- ✅ 다양한 메시지 타입 처리 (텍스트/이미지/파일)
- ✅ 크로스 플랫폼 호환성 (iOS/Android)

#### 📁 프로젝트 구조
```
app_plant_community/
├── app/
│   ├── (tabs)/
│   │   ├── (home)/               # 홈/게시판
│   │   ├── chat/                 # 실시간 채팅
│   │   ├── myFarm/               # 나의 농장
│   │   └── myPage/               # 마이페이지
│   └── auth/                     # 인증
├── utils/
│   ├── api.js                    # API 요청
│   ├── storage.js                # AsyncStorage
│   └── websocket.js              # WebSocket 서비스
└── components/                   # 재사용 컴포넌트
```

#### 🎥 시연 영상
- [실시간 채팅 시스템](https://youtube.com/watch?v=xxx) (예정)
- [1:1 및 그룹 채팅](https://youtube.com/watch?v=xxx) (예정)
- [게시판 및 커뮤니티](https://youtube.com/watch?v=xxx) (예정)
- [MyFarm 모바일 버전](https://youtube.com/watch?v=xxx) (예정)

---

## 🛠 기술 스택 통합도

```
┌─────────────────────────────────────────────┐
│         1️⃣ IoT 기기 개발                     │
│   Python + Raspberry Pi + GPIO/SPI          │
│   (센서 수집 → 자동 제어)                    │
└──────────────────┬──────────────────────────┘
                   ↓ MariaDB
┌──────────────────┴──────────────────────────┐
│      Backend (Spring Boot + Java)            │
│  ├─ RESTful API (회원, 게시판, 채팅)        │
│  ├─ WebSocket (실시간 채팅)                 │
│  └─ 데이터 관리 (MyBatis + MariaDB)         │
└──────┬────────────────────────┬─────────────┘
       ↓                        ↓
  ┌──────────────┐       ┌──────────────────┐
  │ 2️⃣ 웹 개발   │       │  3️⃣ 앱 개발     │
  │ (React)      │       │ (React Native)   │
  │              │       │                  │
  │ - MyFarm     │       │ - 채팅           │
  │ - 게시판     │       │ - 게시판         │
  │ - 캘린더     │       │ - MyFarm         │
  │ - 쪽지       │       │ - iOS/Android    │
  └──────────────┘       └──────────────────┘
```

---

## 📊 데이터베이스 스키마

### 1️⃣ IoT 단계에서 생성
- `sensor_data`: 센서 원본 데이터
- `actuator_log`: 액추에이터 작동 로그
- `actuator_control`: 제어 명령

### 2️⃣ 웹 개발 단계에서 추가
- `member`: 회원 정보
- `board`: 게시물
- `comment`: 댓글
- `message`: 쪽지
- `calendar`: 일정

### 3️⃣ 앱 개발 단계에서 추가
- `chat_room`: 채팅방
- `chat_message`: 메시지
- `chat_participant`: 참여자

---

## 🎓 학습 내용 총정리

### 1️⃣ IoT 개발 학습
- Raspberry Pi GPIO/SPI 프로토콜
- 센서 데이터 수집 및 신호 처리
- 데이터베이스 연동
- 자동 제어 알고리즘 설계

### 2️⃣ 웹 개발 학습
- React 상태 관리 및 Hooks
- 데이터 시각화 (Chart.js)
- 캘린더/다이어리 기능
- RESTful API 설계

### 3️⃣ 모바일 개발 학습
- React Native 크로스 플랫폼 개발
- WebSocket 실시간 통신
- Expo 프레임워크
- 모바일 최적화

## 🚀 설치 및 실행

### 1️⃣ IoT 기기 (Raspberry Pi)
```bash
# Python 의존성 설치
pip install adafruit-circuitpython-dht mysql-connector-python RPi.GPIO spidev

# 스크립트 실행
python iot_sensor_collection.py
```

### 2️⃣ 웹 프론트엔드
```bash
cd frontend_plant_comunity
npm install
npm run dev
```

### 3️⃣ 모바일 앱
```bash
cd app_plant_community
npm install
npm start
```

### 백엔드 (모든 단계 공용)
```bash
cd backend_plant_comunity
./gradlew bootRun
```

---

## 👥 팀 정보

**프로젝트명**: GitHerb - 식물 커뮤니티 플랫폼
**총 개발 기간**: 2025.09.11 ~ 2025.11.14 (65일)
**총 개발 인원**: 1명 (풀 스택 개발)

### 단계별 개발 인력

#### 1️⃣ IoT 기기 개발 (14일)
- Python IoT 프로그래밍
- Raspberry Pi 하드웨어 제어
- 센서 알고리즘 개발

#### 2️⃣ React 웹 개발 (22일)
- 프론트엔드 UI/UX 구현
- 데이터 시각화
- 커뮤니티 기능 개발

#### 3️⃣ React Native 앱 개발 (29일)
- 크로스 플랫폼 모바일 앱 개발
- 실시간 채팅 시스템 구현
- iOS/Android 최적화

### 핵심 성과
- ✅ 3단계 프로젝트로 점진적 기능 확장
- ✅ IoT → 웹 → 모바일로 이어지는 통합 시스템
- ✅ 센서 데이터 수집 성공률 95% 이상
- ✅ 500+ 라인 파이썬 코드
- ✅ 3000+ 라인 React 코드
- ✅ 2000+ 라인 React Native 코드
- ✅ 15+ RESTful API 엔드포인트

---

## 📝 개발 환경

### 1️⃣ IoT 개발
- **하드웨어**: Raspberry Pi 3/4
- **OS**: Raspberry Pi OS (Debian 기반)
- **언어**: Python 3.9+
- **라이브러리**: Adafruit DHT, RPi.GPIO, spidev

### 2️⃣ 웹 개발
- **IDE**: VS Code
- **Frontend**: React 18.2.0, Vite 7.1.2, Node.js 16.x
- **Backend**: IntelliJ IDEA, Spring Boot 3.4.9, Java 17

### 3️⃣ 앱 개발
- **IDE**: VS Code
- **Framework**: React Native 0.81.4, Expo ~54.0.13
- **Platform**: Android Studio, Xcode

### 공통 도구
- **Version Control**: Git
- **Database**: MariaDB 10.x
- **API Test**: Postman
- **Communication**: WebSocket (STOMP)

---

## 🎥 시연 영상

각 단계별 시연 영상을 YouTube에 업로드하여 포트폴리오와 연동합니다.

### 1️⃣ IoT 기기 개발
- 센서 데이터 수집 및 자동 제어
- 장치 작동 로그 기록

### 2️⃣ 웹 개발
- MyFarm 센서 시각화
- 게시판 및 커뮤니티
- 캘린더 및 쪽지 시스템

### 3️⃣ 앱 개발
- 실시간 채팅 시스템
- 모바일 게시판
- MyFarm 모바일 버전
- iOS/Android 호환성

---

## 🔗 프로젝트 링크

| 단계 | 파트 | 링크 |
|------|------|------|
| 1️⃣ | 웹 프론트 | [frontend_plant_comunity](https://github.com/yoojisu90/dev-archive/tree/main/team/frontend_plant_comunity) |
| 2️⃣ | 앱 프론트 | [app_plant_community](https://github.com/yoojisu90/dev-archive/tree/main/team/app_plant_community) |
| 백엔드 | 공통 | [backend_plant_comunity](https://github.com/yoojisu90/dev-archive/tree/main/team/backend_plant_comunity) |
| IoT-Python 센서 및 기기 제어 | 공통 | [IoT-python](https://github.com/yoojisu90/dev-archive/tree/main/IoT-python) |


---

## 📞 연락처

- **Email**: yoo901013@gmail.com
- **GitHub**: [@yoojisu90](https://github.com/yoojisu90)
- **Portfolio**: [GitHub Portfolio](https://github.com/yoojisu90/dev-archive)

---

**⭐ 3단계로 완성한 이 프로젝트가 마음에 드신다면 스타를 눌러주세요!**
