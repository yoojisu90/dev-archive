# 🌱 GitHerb - 식물 커뮤니티 플랫폼

> 스마트팜 IoT 관리와 소셜 커뮤니티를 결합한 식물 관리 통합 플랫폼

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

GitHerb는 식물 애호가들을 위한 종합 플랫폼으로, IoT 스마트팜 기술과 소셜 커뮤니티 기능을 결합하여 다음과 같은 가치를 제공합니다:

- **🌾 스마트팜 관리**: IoT 센서를 통한 실시간 환경 모니터링 (온도, 습도, 조도, 토양 수분)
- **💬 실시간 커뮤니티**: WebSocket 기반 1:1 및 그룹 채팅
- **📝 경험 공유**: 게시판을 통한 재배 경험 및 정보 공유
- **📅 일정 관리**: 물주기 스케줄 및 식물 다이어리 작성
- **🔔 직관적 알림**: 실시간 메시지 및 커뮤니티 알림

---

## 🔗 프로젝트 링크

| 파트 | 링크 | 설명 |
|------|------|------|
| 🔙 Backend | [backend_plant_comunity](https://github.com/yoojisu90/portfolio/tree/main/team/backend_plant_comunity) | Spring Boot API 서버 |
| 💻 Frontend Web | [frontend_plant_comunity](https://github.com/yoojisu90/portfolio/tree/main/team/frontend_plant_comunity) | React 웹 애플리케이션 |
| 📱 Frontend Mobile | [app_plant_community](https://github.com/yoojisu90/portfolio/tree/main/team/app_plant_community) | React Native 모바일 앱 |

---

## 🎯 주요 기능

### 1️⃣ MyFarm - 스마트팜 관리 시스템

#### 실시간 센서 모니터링
- **1초 주기 센서 데이터 갱신**: 온도, 습도, 조도, 토양 수분
- **식물별 최적 환경 조건 표시**
  - 적합한 환경: 🟢 초록색
  - 부적합한 환경: 🔴 빨간색
- **장치 작동 로그**: 자동 ON/OFF 시간 및 가동 시간 추적

#### 환경 정보 시각화
- **Chart.js 기반 실시간 그래프**
  - 온도/습도/토양수분: 영역 차트 (트렌드)
  - 조도: 막대 차트 (비교)
- **기간별 데이터 집계**
  - 오늘: 시간별 평균
  - 최근 7일/30일: 일별 평균
- 인터랙티브 툴팁 및 범례

### 2️⃣ 실시간 채팅 시스템

#### 채팅방 관리
- **1:1 채팅방 생성**: 개인 간 직접 채팅
- **단체 채팅방**: 여러 사용자와 그룹 채팅
- **동적 채팅방 이름**: 참여자 정보 기반 자동 생성
- **프로필 이미지 그리드**: 최대 4명의 2x2 그리드 표시

#### 실시간 메시징
- **WebSocket + STOMP**: 양방향 실시간 통신
- **메시지 타입 지원**: 텍스트, 이미지, 파일
- **읽음 처리**: 메시지 읽음 상태 추적
- **메시지 알림**: 헤더에 실시간 읽지 않은 메시지 수 표시

#### 채팅 UI/UX
- **이미지 전체화면 뷰어**: 모달을 통한 확대 보기
- **파일 다운로드/열기**: React Native Linking API 활용
- **입력 중 표시**: 사용자 타이핑 상태 표시
- **마지막 메시지 시간**: 채팅방 목록에서 시간 표시

### 3️⃣ 커뮤니티 게시판

#### 게시물 관리
- **풍부한 텍스트 편집**: React Quill 리치 에디터
- **이미지 업로드**: 게시물 내 이미지 첨부 및 관리
- **카테고리 분류**: 여러 주제별 게시판
- **작성자 권한**: 본인만 수정/삭제 가능

#### 상호작용 기능
- **좋아요 시스템**: 게시물 좋아요/취소
- **댓글 및 대댓글**: 중첩 댓글 지원
- **조회수 추적**: 게시물 인기도 표시
- **검색 기능**: 제목, 작성자, 내용으로 검색

#### 게시판 관리
- **페이지네이션**: 효율적인 데이터 로딩
- **필터링**: 카테고리별, 상태별 분류
- **관리자 삭제**: 부적절한 게시물 관리

### 4️⃣ 마이페이지 - 식물 캘린더

#### 캘린더 기능
- **React Big Calendar**: 한국어 로컬라이제이션
- **한국 공휴일 표시**: 자동 공휴일 연동
- **월별 뷰**: 직관적인 달력 표시

#### 물주기 일정 관리
- **반복 일정 설정**: 주기별 반복 (일 단위)
- **반복 횟수 지정**: 무제한 또는 정해진 횟수
- **커스텀 색상**: 시각적 구분을 위한 색상 코드
- **스마트 삭제**: 단일/그룹/미래 일정 삭제 옵션

#### 식물 다이어리
- **일별 기록**: 하루 1개 다이어리 작성
- **리치 텍스트 지원**: 서식 있는 텍스트 작성
- **데이터 영속성**: 서버에 저장
- **수정/삭제**: 언제든 일지 관리 가능

#### 보기 모드
- 전체 보기 (물주기 + 다이어리 + 공휴일)
- 다이어리만 보기
- 물주기만 보기

### 5️⃣ 쪽지 시스템

#### 메시지 관리
- **받은/보낸 쪽지 분리**: 탭으로 구분된 관리
- **3가지 발송 모드**:
  - 단일: 1명에게 전송
  - 다중: 여러 명에게 전송
  - 전체: 모든 회원에게 발송
- **논리적 삭제**: 발신자/수신자 별도 관리
- **답장 기능**: 수신자 자동 입력

#### 실시간 알림
- **읽지 않은 쪽지 수**: 헤더 배지에 실시간 표시
- **새 쪽지 표시**: 목록에서 'N' 배지
- **자동 갱신**: 페이지 로드 및 100초마다 갱신

#### 사용자 검색
- **자동완성**: 사용자명 자동 완성
- **키보드 네비게이션**: 방향키, Enter, ESC 지원
- **검색 결과 표시**: 빠른 사용자 선택

### 6️⃣ 1:1 문의 (QnA)

#### 회원 측
- 카테고리별 1:1 문의 작성
- 문의 내역 조회 (답변대기/답변완료)
- 관리자 답변 확인

#### 관리자 측
- 모든 문의 조회 및 필터링
- 상태별/카테고리별 정렬
- 문의 답변 작성 및 상태 변경

### 7️⃣ 회원 및 인증

#### 로그인/회원가입
- **2가지 회원 유형**: USER (일반), BUSINESS (사업자)
- **종합 폼 검증**: 아이디, 비밀번호, 휴대폰 등
- **중복 체크**: 아이디, 휴대폰, 사업자번호
- **다음 우편번호 API**: 주소 검색 및 입력

#### 회원 정보 관리
- 프로필 이미지 업로드 및 수정
- 회원 정보 수정
- 비밀번호 변경
- 아이디/비밀번호 찾기
- 회원 탈퇴

#### 관리자 기능
- 전체 회원 조회 및 검색
- 회원 소프트 삭제 (INACTIVE 상태)
- 삭제된 회원 복구
- 회원 상태 및 등급 관리

---

## 🛠 기술 스택

### Backend
| 기술 | 버전 | 용도 |
|------|------|------|
| Java | 17 | 언어 |
| Spring Boot | 3.4.9 | 웹 프레임워크 |
| MyBatis | 3.0.5 | SQL 매퍼 |
| MariaDB | 10.x | 데이터베이스 |
| WebSocket (STOMP) | - | 실시간 통신 |
| Lombok | - | 보일러플레이트 감소 |
| JSoup | - | HTML 파싱 |
| Kakao API | - | 날씨 정보 |

### Frontend (Web)
| 기술 | 버전 | 용도 |
|------|------|------|
| React | 18.2.0 | UI 라이브러리 |
| React Router DOM | 7.8.2 | 클라이언트 라우팅 |
| Vite | 7.1.2 | 빌드 도구 |
| Axios | 1.11.0 | HTTP 클라이언트 |
| Chart.js | 4.5.0 | 데이터 시각화 |
| React Big Calendar | 1.19.4 | 캘린더 컴포넌트 |
| React Quill | 2.0.0 | 리치 텍스트 에디터 |

### Frontend (Mobile App)
| 기술 | 버전 | 용도 |
|------|------|------|
| React Native | 0.81.4 | 크로스 플랫폼 모바일 |
| Expo | ~54.0.13 | React Native 프레임워크 |
| Expo Router | ~6.0.11 | 파일 기반 라우팅 |
| WebSocket (@stomp/stompjs) | - | 실시간 채팅 |
| AsyncStorage | - | 로컬 데이터 저장 |

---

## 📁 프로젝트 구조

```
GitHerb/
├── backend_plant_comunity/          # Spring Boot 백엔드
│   ├── src/main/java/
│   │   ├── board/                   # 게시판
│   │   ├── calendar/                # 캘린더
│   │   ├── chat/                    # 채팅
│   │   ├── member/                  # 회원
│   │   ├── message/                 # 메시지/알림
│   │   ├── weather/                 # 날씨
│   │   ├── config/
│   │   │   ├── WebSocketConfig.java
│   │   │   └── WebConfig.java
│   │   └── util/
│   │       ├── FileUploadUtil.java
│   │       └── ImageCleanupScheduler.java
│   └── src/main/resources/
│       └── application.properties
│
├── frontend_plant_comunity/         # React 웹 프론트엔드
│   ├── src/
│   │   ├── page/
│   │   │   ├── MyFarm/              # 스마트팜 페이지
│   │   │   ├── Board/               # 게시판 페이지
│   │   │   ├── MyPage/              # 마이페이지
│   │   │   └── Admin/               # 관리자 페이지
│   │   ├── components/
│   │   │   ├── message/             # 쪽지 시스템
│   │   │   ├── ChatDiary.jsx
│   │   │   └── Weather.jsx
│   │   ├── layout/                  # 레이아웃
│   │   └── validate/                # 폼 검증
│   └── vite.config.js
│
└── app_plant_community/             # React Native 모바일 앱
    ├── app/
    │   ├── (tabs)/
    │   │   ├── (home)/              # 홈/게시판
    │   │   ├── chat/                # 채팅
    │   │   ├── myFarm/              # 나의 농장
    │   │   └── myPage/              # 마이페이지
    │   └── auth/                    # 인증
    ├── utils/
    │   ├── api.js
    │   ├── storage.js
    │   └── websocket.js
    └── components/
```

---

## 🚀 설치 및 실행

### 1. 백엔드 설정

#### 필수 요구사항
- Java 17 이상
- MariaDB 10.x
- Gradle 8.x

#### 설치 및 실행
```bash
cd backend_plant_comunity

# Gradle 빌드
./gradlew build

# 애플리케이션 실행
./gradlew bootRun
```

서버는 `http://localhost:8080` 에서 실행됩니다.

### 2. 웹 프론트엔드 설정

#### 필수 요구사항
- Node.js 16.x 이상
- npm 또는 yarn

#### 설치 및 실행
```bash
cd frontend_plant_comunity

# 의존성 설치
npm install

# 개발 서버 실행
npm run dev

# 프로덕션 빌드
npm run build
```

웹은 `http://localhost:5173` 에서 실행됩니다.

### 3. 모바일 앱 설정

#### 필수 요구사항
- Node.js 16.x 이상
- Expo CLI
- Android Studio / Xcode

#### 설치 및 실행
```bash
cd app_plant_community

# 의존성 설치
npm install

# 개발 서버 실행
npm start

# Android 실행
npm run android

# iOS 실행
npm run ios
```

---

## 🔌 주요 API 엔드포인트

### 회원 관리
```
GET    /api/members/login                    - 로그인
POST   /api/members                          - 회원가입
GET    /api/members/checkId/{id}             - 아이디 중복 확인
GET    /api/members/{memId}                  - 회원 정보 조회
PUT    /api/members/{memId}                  - 회원 정보 수정
```

### 게시판
```
GET    /api/boards/boardList-paging          - 페이징된 게시판 목록
GET    /api/boards/boardDetail/{boardNum}    - 게시물 상세 조회
POST   /api/boards                           - 게시물 작성
PUT    /api/boards/{boardNum}                - 게시물 수정
DELETE /api/boards/{boardNum}                - 게시물 삭제
```

### 실시간 채팅
```
POST   /api/chat/room/direct                 - 1:1 채팅방 생성
POST   /api/chat/room/group                  - 단체 채팅방 생성
GET    /api/chat/rooms/{memId}               - 내 채팅방 목록
POST   /api/chat/message                     - 메시지 전송
GET    /api/chat/messages/{roomId}           - 메시지 목록 조회
```

### 쪽지
```
GET    /api/messages/unread/count/{memberId} - 읽지 않은 쪽지 수
GET    /api/messages/box/received/{memberId} - 받은 쪽지 목록
POST   /api/messages/{senderId}              - 쪽지 발송
DELETE /api/messages/{msgNum}/{memberId}     - 쪽지 삭제
```

### MyFarm (스마트팜)
```
GET    /api/plants                           - 식물 목록
GET    /api/sensor/last                      - 최근 센서 데이터
GET    /api/sensor                           - 센서 데이터 히스토리
GET    /api/logs                             - 장치 작동 로그
```

---

## 🎯 주요 개발 성과

### Backend
- **WebSocket 안정화**: 중복 연결 방지 및 싱글톤 패턴 구현
- **이미지 관리**: JSoup를 이용한 자동 이미지 추출 및 미사용 이미지 삭제 스케줄러
- **캘린더 일정**: 반복 일정 관리 및 한국 공휴일 연동
- **메시지 시스템**: 논리적 삭제를 통한 발신자/수신자 독립적 관리

### Frontend (Web)
- **실시간 모니터링**: 1초 주기로 센서 데이터 갱신
- **데이터 시각화**: Chart.js로 아름다운 그래프 구현
- **캘린더 통합**: React Big Calendar로 직관적인 일정 관리
- **쪽지 시스템**: 이벤트 기반 크로스 컴포넌트 실시간 업데이트

### Mobile App
- **실시간 채팅**: WebSocket 싱글톤으로 안정적인 연결 관리
- **FlatList 최적화**: refreshKey와 extraData를 활용한 효율적 리렌더링
- **다양한 메시지 타입**: 텍스트, 이미지, 파일 전송 및 UI 처리
- **크로스 플랫폼**: 동일한 코드로 iOS/Android 지원

---

## 👥 팀 구성 및 역할

### Frontend Web (React)
- **담당**: 유지수
- **주요 기능**:
  - MyFarm (스마트팜 관리)
  - 홈 화면
  - 쪽지 시스템
  - 마이페이지 (캘린더, 다이어리)

### Frontend Mobile (React Native)
- **담당**: 유지수
- **주요 기능**:
  - 실시간 채팅 시스템
  - 게시판
  - 커뮤니티 기능
  - 모바일 최적화

### Backend (Spring Boot)
- **담당**: 유지수
- **주요 기능**:
  - RESTful API 설계
  - WebSocket 채팅 구현
  - 회원/게시판 관리
  - 파일 업로드 및 이미지 관리

---

## 🔧 IoT 센서 구현 (Raspberry Pi + Python)

### 하드웨어 구성
- **Raspberry Pi**: 스마트팜 제어 및 센서 데이터 수집
- **DHT-22 센서**: 온습도 측정
- **LDR + ADC**: 조도(Lux) 측정
- **토양 수분 센서**: 토양 습도 측정
- **액추에이터**: LED, 펌프, 선풍기 자동 제어

### 핵심 기능

#### 1️⃣ 센서 데이터 수집 (1초 주기)

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

**개선 사항:**
- ✅ 센서 읽기 실패 시 3회까지 자동 재시도
- ✅ 데이터 수집 성공률 **95% 이상** 달성
- ✅ null 값 DB 저장 완전 제거

#### 2️⃣ 환경 데이터 계산

```python
def calculate_ldr_resistance(adc_value):
    """ADC 값을 LDR 저항으로 변환"""
    if adc_value is None or adc_value <= 0:
        return float('inf')
    resistance_ldr = R_FIXED * (adc_value / (1024.0 - adc_value))
    return resistance_ldr

def convert_resistance_to_lux(ldr_resistance):
    """LDR 저항을 조도(Lux)로 변환"""
    if ldr_resistance <= 0:
        return 0.0
    lux = CALIBRATION_CONSTANT_LUX * ldr_resistance
    return int(lux)

def soil_moisture_percent(raw_value):
    """토양 수분 센서 값을 퍼센트로 변환"""
    if raw_value is None:
        return None
    moisture_percent = ((SOIL_MAX - raw_value) / (SOIL_MAX - SOIL_MIN)) * 100
    return round(max(0, min(100, moisture_percent)), 1)
```

**측정값:**
- 온도: ℃
- 습도: %
- 조도: Lux (20,000 ~ 60,000)
- 토양수분: % (25% ~ 40%)

#### 3️⃣ 자동 제어 로직

```python
def auto_control_pump(soil_moisture_percent_value):
    """토양 수분에 따른 펌프 자동 제어"""
    if control_mode["PUMP"] == "MANUAL":
        return
    
    if soil_moisture_percent_value is not None:
        # 최적값 이하 → 펌프 ON (물주기)
        if soil_moisture_percent_value < BASIL_OPTIMAL_SOIL_MOISTURE_MIN:
            pump_on()
        else:
            pump_off()

def auto_control_fan(temperature, humidity):
    """온습도에 따른 선풍기 자동 제어"""
    if control_mode["FAN"] == "MANUAL":
        return
    
    # 온도 또는 습도 초과 → 팬 ON (환기)
    if (temperature > BASIL_OPTIMAL_TEMP_MAX) or \
       (humidity > BASIL_OPTIMAL_HUMIDITY_MAX):
        fan_on()
    else:
        fan_off()

def auto_control_led(lux_out_of_range):
    """조도에 따른 보조 조명 자동 제어"""
    if control_mode["LED"] == "MANUAL":
        return
    
    # 조도 부족 → LED ON (보조 조명)
    if lux_out_of_range:
        led_on()
    else:
        led_off()
```

**제어 모드:**
- **AUTO**: 최적 환경 기준으로 자동 제어
- **MANUAL**: 사용자 명령 수행

#### 4️⃣ 데이터베이스 저장

```python
if now - last_sensor_insert >= 2:
    if temperature is None or humidity is None:
        print("Skip DB: Temp/Humidity None")
    else:
        try:
            cursor.execute(
                """INSERT INTO sensor_data 
                   (TEMPERATURE, HUMIDITY, ILLUMINANCE, SOIL_MOISTURE, RASP_NUM) 
                   VALUES (%s, %s, %s, %s, %s)""",
                (temperature, humidity, estimated_lux, soil_moisture_percent_value, my_device_serial)
            )
            conn.commit()
            print("Data saved to DB")
        except mysql.connector.Error as db_err:
            print(f"DB insert error: {db_err}")
```

**저장 주기:**
- 2초마다 DB에 저장
- 유효한 데이터만 저장 (null 값 제외)
- Raspberry Pi 시리얼 번호와 함께 저장

#### 5️⃣ 액추에이터 로그

```python
def log_actuator(act_name, state):
    """액추에이터 ON/OFF 기록"""
    if prev_states.get(act_name) == state:
        return  # 상태 변화 없으면 기록 안 함
    
    try:
        cursor.execute(
            "INSERT INTO actuator_log (ACT_NAME, RASP_NUM, STATE) VALUES (%s, %s, %s)",
            (act_name, my_device_serial, state)
        )
        conn.commit()
        prev_states[act_name] = state
        print(f"[LOG] {act_name} -> {state} Recorded")
    except mysql.connector.Error as e:
        print(f"Actuator log error: {e}")
```

**기록 내용:**
- 펌프, 선풍기, LED ON/OFF 시간
- 동작 시간 추적
- 상태 변화만 기록 (중복 제거)

### 바질(Basil) 최적 환경 조건

```python
BASIL_OPTIMAL_TEMP_MIN = 20          # 최저 온도
BASIL_OPTIMAL_TEMP_MAX = 30          # 최고 온도
BASIL_OPTIMAL_HUMIDITY_MIN = 40      # 최저 습도
BASIL_OPTIMAL_HUMIDITY_MAX = 60      # 최고 습도
BASIL_OPTIMAL_SOIL_MOISTURE_MIN = 25 # 최저 토양 수분
BASIL_OPTIMAL_SOIL_MOISTURE_MAX = 40 # 최고 토양 수분
BASIL_OPTIMAL_LUX_MIN = 20000        # 최저 조도
BASIL_OPTIMAL_LUX_MAX = 60000        # 최고 조도
```

### 데이터베이스 테이블

```sql
-- 센서 데이터 저장
CREATE TABLE sensor_data (
    ENV_NUM INT PRIMARY KEY AUTO_INCREMENT,
    SENSOR_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
    TEMPERATURE FLOAT,
    HUMIDITY FLOAT,
    ILLUMINANCE FLOAT,
    SOIL_MOISTURE FLOAT,
    RASP_NUM VARCHAR(50)
);

-- 액추에이터 작동 로그
CREATE TABLE actuator_log (
    LOG_ID INT PRIMARY KEY AUTO_INCREMENT,
    ACT_NAME VARCHAR(50) NOT NULL,
    RASP_NUM VARCHAR(50),
    STATE ENUM('ON', 'OFF') NOT NULL,
    EVENT_TIME DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 액추에이터 제어 명령
CREATE TABLE actuator_control (
    CONTROL_ID INT PRIMARY KEY AUTO_INCREMENT,
    ACT_NAME VARCHAR(50) NOT NULL,
    RASP_NUM VARCHAR(50),
    COMMAND ENUM('ON', 'OFF', 'AUTO') NOT NULL,
    MODE ENUM('AUTO', 'MANUAL') DEFAULT 'AUTO',
    CREATED_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
    PROCESSED BOOLEAN DEFAULT FALSE
);
```

### 실행 흐름

```
1️⃣ 센서 데이터 수집 (1초 주기)
   ├─ DHT-22: 온습도 (재시도 로직)
   ├─ LDR+ADC: 조도 계산
   ├─ 토양센서: 수분 계산
   └─ PIR: 동작 감지

2️⃣ 환경 조건 평가
   ├─ 바질 최적값과 비교
   ├─ 부족/과다 판정
   └─ LED 상태 결정

3️⃣ 자동 제어 실행
   ├─ 펌프: 토양 수분 기반
   ├─ 팬: 온습도 기반
   └─ LED: 조도 기반

4️⃣ DB 저장 (2초마다)
   ├─ 센서 데이터 저장
   ├─ 액추에이터 로그 기록
   └─ 수동 제어 명령 확인

5️⃣ 무한 루프 반복
   └─ 1초 대기 후 1️⃣로 돌아감
```

### 기술적 특징

- ✅ **재시도 로직**: 센서 읽기 실패 시 자동 재시도
- ✅ **데이터 검증**: null 값 체크 후 DB 저장
- ✅ **중복 제거**: 상태 변화 없으면 로그 기록 안 함
- ✅ **실시간 제어**: 웹/모바일 앱에서 자동/수동 제어
- ✅ **Raspberry Pi 시리얼**: 여러 기기 관리 가능

---

## 💡 기술적 하이라이트

### 1. 실시간 양방향 통신
```java
// WebSocket STOMP 프로토콜
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }
}
```

### 2. 센서 데이터 시각화
- Chart.js 기반 4가지 차트 타입
- 기간별 데이터 집계 (시간별/일별)
- 인터랙티브 툴팁 및 범례

### 3. 중첩 댓글 시스템
- 대댓글(nested replies) 지원
- 계층적 댓글 표시
- 댓글 작성자만 수정/삭제 가능

### 4. 논리적 삭제
- 발신자/수신자 별도 플래그
- 쪽지 영구 삭제 방지
- 데이터 복구 가능

### 5. 크로스 플랫폼 파일 처리
- 이미지: 업로드, 저장, 다운로드
- 파일: 전송, 저장, 열기
- React Native Linking API 활용

---

## 📊 데이터베이스 스키마

### 주요 테이블
- **MEMBER**: 회원 정보 (USER/BUSINESS/ADMIN)
- **BOARD**: 게시물 및 메타데이터
- **COMMENT**: 댓글 및 대댓글
- **CHAT_ROOM**: 1:1/그룹 채팅방
- **CHAT_MESSAGE**: 메시지 내용 및 파일
- **MESSAGE**: 쪽지 및 알림
- **CALENDAR**: 물주기 및 일정
- **FARM_LOG**: 식물 다이어리
- **PLANT**: 식물 정보 및 최적 환경 조건

---

## 🔮 향후 개선 계획

- [ ] 푸시 알림 기능 (FCM)
- [ ] 오프라인 메시지 캐싱
- [ ] 이미지 압축 및 CDN 연동
- [ ] 음성/영상 통화 기능
- [ ] AI 식물 진단 기능
- [ ] Redis 캐싱 도입
- [ ] Spring Security 적용

---

## 📝 개발 환경

### Backend & IoT
- **IDE**: IntelliJ IDEA / VS Code
- **Language**: Java 17, Python 3.9+
- **Framework**: Spring Boot 3.4.9
- **Database**: MariaDB 10.x
- **ORM**: MyBatis 3.0.5

### Frontend
- **IDE**: VS Code
- **Web**: Node.js 16.x, npm, Vite
- **Mobile**: Expo CLI, Android Studio / Xcode

### IoT & Hardware
- **Microcontroller**: Raspberry Pi
- **Sensors**: DHT-22 (온습도), LDR+ADC (조도), 토양수분 센서
- **Actuators**: LED, 펌프, 선풍기
- **Protocol**: GPIO, SPI, MySQL 연결

### Development Tools
- **Version Control**: Git
- **API Test**: Postman
- **Database Tool**: DBeaver / MySQL Workbench
- **Communication**: WebSocket (STOMP)

---

## 📞 팀 정보

**프로젝트명**: GitHerb - 스마트팜 식물 커뮤니티 플랫폼
**개발 기간**: 2025.09.11 ~ 2025.11.14
**팀 규모**: 풀 스택 개발 (4인 팀 개발)

### 주요 담당 역할

#### 🔙 Backend (Spring Boot + Java)
- RESTful API 설계 및 구현
- WebSocket 실시간 채팅 시스템
- 회원/게시판 관리 시스템
- 파일 업로드 및 이미지 관리
- 데이터베이스 설계 (MariaDB + MyBatis)

#### 💻 Frontend Web (React + JavaScript)
- MyFarm (스마트팜 관리) 개발
- 홈 화면 및 인기 게시물 표시
- 쪽지 시스템 구현
- 마이페이지 (캘린더, 다이어리)
- Chart.js 센서 데이터 시각화

#### 📱 Frontend Mobile (React Native + JavaScript)
- 크로스 플랫폼 모바일 앱 개발 (iOS/Android)
- 실시간 채팅 시스템 구현
- 게시판 및 커뮤니티 기능
- Expo를 이용한 개발 및 배포

#### 🌱 IoT System (Python + Raspberry Pi)
- Raspberry Pi 센서 데이터 수집 (1초 주기)
- DHT-22 온습도, LDR 조도, 토양수분 센서 연동
- 자동 제어 로직 구현 (펌프, 팬, LED)
- 센서 데이터 재시도 로직으로 성공률 95% 이상 달성
- MariaDB 데이터베이스 연동
- 웹/모바일 앱과 실시간 데이터 연동

### 기술 스택 통합
- **풀 스택**: Backend(Java) ↔ Frontend Web(React) ↔ Frontend Mobile(React Native)
- **IoT 연동**: Python(라즈베리파이) → Backend API → 웹/모바일 앱
- **실시간 통신**: WebSocket STOMP 프로토콜
- **데이터 저장**: MariaDB 중앙 집중식 관리

### 핵심 성과
- ✅ 멀티 플랫폼 통합 시스템 구축 (백/웹/모바일/IoT)
- ✅ 센서 데이터 수집 성공률 95% 이상 개선
- ✅ 실시간 양방향 통신 구현 (WebSocket)
- ✅ 500+ 라인의 파이썬 IoT 제어 코드 작성
- ✅ 15+ 개의 RESTful API 엔드포인트 구현

---

## 📧 연락처

- **Email**: yoo901013@gmail.com
- **GitHub**: [@yoojisu90](https://github.com/yoojisu90)
- **Portfolio**: [GitHub Portfolio](https://github.com/yoojisu90/portfolio)

---

**⭐ 이 프로젝트가 마음에 드신다면 스타를 눌러주세요!**
