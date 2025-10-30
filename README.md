
# 🌱 GitHerb - 식물 커뮤니티 플랫폼

> 스마트팜 IoT 관리와 소셜 커뮤니티를 결합한 식물 관리 통합 플랫폼

![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.9-6DB33F?style=flat-square&logo=spring-boot)
![React](https://img.shields.io/badge/React-18.2.0-61DAFB?style=flat-square&logo=react)
![React Native](https://img.shields.io/badge/React%20Native-0.81.4-61DAFB?style=flat-square&logo=react)
![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-010101?style=flat-square)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=flat-square&logo=mariadb)

---

## 📋 프로젝트 개요

GitHerb는 식물 애호가들을 위한 종합 플랫폼으로, IoT 스마트팜 기술과 소셜 커뮤니티 기능을 결합하여 다음과 같은 가치를 제공합니다:

- **🌾 스마트팜 관리**: IoT 센서를 통한 실시간 환경 모니터링 (온도, 습도, 조도, 토양 수분)
- **💬 실시간 커뮤니티**: WebSocket 기반 1:1 및 그룹 채팅
- **📝 경험 공유**: 게시판을 통한 재배 경험 및 정보 공유
- **📅 일정 관리**: 물주기 스케줄 및 식물 다이어리 작성
- **🔔 직관적 알림**: 실시간 메시지 및 커뮤니티 알림

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
- **주요 기능**:
  - MyFarm (스마트팜 관리)
  - 홈 화면
  - 쪽지 시스템
  - 마이페이지 (캘린더, 다이어리)

### Frontend Mobile (React Native)
- **주요 기능**:
  - 실시간 채팅 시스템
  - 게시판
  - 커뮤니티 기능
  - 모바일 최적화

### Backend (Spring Boot)
- **주요 기능**:
  - RESTful API 설계
  - WebSocket 채팅 구현
  - 회원/게시판 관리
  - 파일 업로드 및 이미지 관리

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

- **IDE**: IntelliJ IDEA / VS Code
- **Version Control**: Git
- **API Test**: Postman
- **Database Tool**: DBeaver / MySQL Workbench

---

## 📞 팀 정보

**프로젝트명**: GitHerb - 식물 커뮤니티 플랫폼
**개발 기간**: 2025.09.11 ~ 2025.11.14
**팀 규모**: 4명 (풀 스택 개발)

### 주요 담당
- 백엔드 API 및 WebSocket 서버
- 웹 프론트엔드 (React)
- 모바일 앱 (React Native)
- 데이터베이스 설계 및 최적화

---

## 🔗 프로젝트 링크

| 파트 | 링크 | 설명 |
|------|------|------|
| 🔙 Backend | [backend_plant_comunity](https://github.com/yoojisu90/portfolio/tree/main/team/backend_plant_comunity) | Spring Boot API 서버 |
| 💻 Frontend Web | [frontend_plant_comunity](https://github.com/yoojisu90/portfolio/tree/main/team/frontend_plant_comunity) | React 웹 애플리케이션 |
| 📱 Frontend Mobile | [app_plant_community](https://github.com/yoojisu90/portfolio/tree/main/team/app_plant_community) | React Native 모바일 앱 |
```

---

## 📧 연락처

- **Email**: yoo901013@gmail.com
- **GitHub**: [@yoojisu90](https://github.com/yoojisu90)
- **Portfolio**: [GitHub Portfolio](https://github.com/yoojisu90/portfolio)

---

**⭐ 이 프로젝트가 마음에 드신다면 스타를 눌러주세요!**
