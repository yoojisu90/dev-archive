# 🌱 GitHerb - 스마트 식물 커뮤니티 플랫폼 - frontend - web

IoT 스마트팜 관리와 소셜 커뮤니티 기능을 결합한 식물 관리 통합 플랫폼입니다.
사용자는 식물을 모니터링하고, 경험을 공유하며, 식물 관리 일정을 한 곳에서 관리할 수 있습니다.

## 📋 목차

- [프로젝트 소개](#-프로젝트-소개)
- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [시작하기](#-시작하기)
- [프로젝트 구조](#-프로젝트-구조)
- [팀원 기여](#-팀원-기여)
- [API 엔드포인트](#-api-엔드포인트)

## 🎯 프로젝트 소개

GitHerb는 식물 애호가들을 위한 종합 플랫폼으로, 다음과 같은 가치를 제공합니다:

- **스마트팜 관리**: IoT 센서를 통한 실시간 환경 모니터링
- **커뮤니티**: 식물 재배 경험 공유 및 소통
- **일정 관리**: 물주기 스케줄 및 식물 다이어리 작성
- **1:1 문의**: 관리자와의 원활한 소통 채널

### 사용자 등급

- **BUSINESS**: 스마트팜 보유 사업자 (MyFarm 기능 이용 가능)
- **USER**: 일반 커뮤니티 회원
- **ADMIN**: 관리자 (전체 시스템 관리)

## ✨ 주요 기능

### 1. 🏠 홈 화면
- 스마트팜 기능 소개 (온도, 습도, 조명, 데이터 분석)
- 인기 게시물 표시 (조회수/좋아요 순)
- 카테고리별 게시물 미리보기
- 반응형 2단 레이아웃

### 2. 🌾 MyFarm (스마트팜 관리)

#### 2.1 내 식물 정보
- **실시간 모니터링**: 1초마다 센서 데이터 갱신
- **식물별 최적 조건 표시**:
  - 온도 범위 (°C)
  - 습도 범위 (%)
  - 조도 (Lux)
  - 토양 수분 (%)
- **상태 알림**: 색상 코드로 적합/부적합 표시
  - 🟢 초록색: 적합한 환경
  - 🔴 빨간색: 부적합한 환경
- **장치 작동 로그**: 자동 ON/OFF 시간 계산 및 가동 시간 추적

#### 2.2 환경 정보 (센서 데이터 시각화)
- **Chart.js 기반 실시간 그래프**:
  - 온도: 영역 차트 (Area Chart)
  - 습도: 영역 차트
  - 조도: 막대 차트 (Bar Chart)
  - 토양 수분: 영역 차트
- **기간 선택**: 오늘 / 최근 7일 / 최근 30일
- **데이터 집계**:
  - 1일: 시간별 평균
  - 7일/30일: 일별 평균
- 인터랙티브 툴팁 및 범례

### 3. 💬 쪽지 시스템

#### 3.1 쪽지 알림
- 헤더에 실시간 읽지 않은 쪽지 수 표시
- 1초마다 자동 갱신
- 99+ 개 이상일 경우 "99+" 표시

#### 3.2 쪽지 목록
- **받은 쪽지 / 보낸 쪽지** 탭 구분
- 새 쪽지 'N' 배지 표시
- 논리적 삭제 (발신자/수신자 별도 삭제 플래그)
- 페이지 로드 및 100초마다 자동 갱신
- 이벤트 기반 업데이트 (읽기/삭제 시)

#### 3.3 쪽지 작성
- **3가지 발송 모드**:
  - **Single**: 1명에게 전송
  - **Multiple**: 여러 명에게 전송
  - **All**: 전체 회원에게 전송
- 사용자 검색 및 자동완성
- 키보드 내비게이션 (방향키, Enter, ESC)
- 답장 기능 (수신자 자동 입력)

#### 3.4 쪽지 상세
- 전체 쪽지 내용 표시
- 열람 시 자동으로 읽음 처리
- 답장 및 삭제 기능

### 4. 📝 커뮤니티 게시판

#### 4.1 게시판 목록
- 카테고리별 필터링
- 검색 기능 (작성자, 제목, 제목+내용)
- 페이지네이션
- 좋아요/좋아요 취소 기능
- 조회수, 좋아요 수, 댓글 수 표시

#### 4.2 게시물 상세
- HTML 렌더링 지원
- 작성자 정보 및 메타데이터
- 좋아요 기능
- **댓글 시스템**:
  - 대댓글(nested replies) 지원
  - 댓글 수정 및 삭제
  - 작성자 또는 관리자만 수정 가능

#### 4.3 게시물 작성/수정
- **React Quill** 리치 텍스트 에디터
- 이미지 업로드 및 관리
- 카테고리 선택
- 작성자만 수정/삭제 권한

### 5. 🗓️ 마이페이지 - 식물 캘린더

#### 5.1 캘린더 통합
- React Big Calendar (한국어 로컬라이제이션)
- 월별 뷰
- 한국 공휴일 표시

#### 5.2 물주기 일정 관리
- 반복 물주기 일정 생성
- 주기 설정 (일 단위)
- 반복 횟수 설정
- 커스텀 색상 코드
- **그룹 삭제 옵션**:
  - 단일 이벤트 삭제
  - 이벤트 그룹 삭제
  - 이 이벤트 및 미래 이벤트 삭제
- 사용자별 localStorage 저장

#### 5.3 식물 다이어리
- 일별 다이어리 작성 (하루 1개)
- 다이어리 수정 및 삭제
- 리치 텍스트 지원
- 데이터베이스 저장
- 중복 날짜 방지

#### 5.4 보기 모드
- 전체 보기 (물주기 + 다이어리 + 공휴일)
- 다이어리만 보기
- 물주기만 보기

#### 5.5 날씨 위젯
- 현재 날씨 표시
- 위치 기반 날씨 데이터

### 6. 👤 마이페이지 - 기타 기능

#### 6.1 회원 정보 관리
- 프로필 조회 및 수정
- 비밀번호 변경
- 다음 우편번호 API를 통한 주소 수정
- 사업자 정보 (BUSINESS 회원)
- 회원 탈퇴 기능

#### 6.2 내가 쓴 글 목록
- 작성한 모든 게시물 조회
- 게시물 통계 (조회수, 좋아요, 댓글 수)
- 게시물 상세로 빠른 이동

### 7. ❓ 1:1 문의 (QnA)

#### 7.1 회원 측
- 카테고리별 1:1 문의 작성
- 문의 내역 조회
- 답변 상태 확인 (답변대기/답변완료)
- 관리자 답변 확인

#### 7.2 관리자 측
- 모든 문의 조회
- 상태별 필터링 (대기/완료)
- 카테고리별 필터링
- 회원 정보 팝업
- 문의 답변 작성
- 상태 변경

### 8. 👨‍💼 관리자 기능

#### 8.1 회원 관리
- 전체 회원 조회
- 이름/아이디 검색
- 회원 소프트 삭제 (INACTIVE 상태 변경)
- 삭제된 회원 복구
- 회원 등급 및 상세 정보 확인

#### 8.2 게시판 관리
- 전체 게시물 조회
- 작성자 계정 상태 확인
- 부적절한 게시물 삭제
- 게시물 상세 조회

### 9. 🔐 인증 및 회원가입

#### 9.1 로그인
- 아이디/비밀번호 검증
- 계정 상태 검증 (ACTIVE/INACTIVE)
- 세션 기반 인증
- 역할별 리다이렉션

#### 9.2 회원가입
- **2가지 회원 유형** (USER/BUSINESS)
- **종합 폼 검증**:
  - 아이디 (4-16자, 영문+숫자)
  - 비밀번호 (8-16자, 영문+숫자+특수문자)
  - 휴대폰 번호
  - 사업자 번호 (BUSINESS만)
- **중복 체크**:
  - 아이디 중복 확인
  - 휴대폰 중복 확인
  - 사업자 번호 중복 확인
- 다음 우편번호 API 연동

#### 9.3 아이디/비밀번호 찾기
- 이름과 휴대폰 번호로 아이디 찾기
- 아이디와 휴대폰 번호로 비밀번호 찾기

## 🛠️ 기술 스택

### Frontend Core
- **React 18.2.0** - UI 라이브러리
- **React Router DOM 7.8.2** - 클라이언트 사이드 라우팅
- **Vite 7.1.2** - 빌드 도구 및 개발 서버
- **Axios 1.11.0** - HTTP 클라이언트

### UI & Visualization
- **Chart.js 4.5.0** & **React-Chartjs-2 5.3.0** - 센서 데이터 시각화
- **React Big Calendar 1.19.4** - 캘린더 컴포넌트
- **React Quill 2.0.0** - 리치 텍스트 에디터
- **Bootstrap Icons 1.13.1** - 아이콘 라이브러리

### Date & Time
- **Moment.js 2.30.1** - 날짜 포맷팅
- **date-fns 4.1.0** - 날짜 유틸리티
- **dayjs 1.11.18** - 경량 날짜 라이브러리
- **date-holidays 3.26.1** - 한국 공휴일 캘린더

### Additional Libraries
- **React Daum Postcode 3.2.0** - 한국 주소 검색
- **UUID 13.0.0** - 고유 ID 생성

### Backend Integration
- **Proxy Server**: Vite 개발 서버가 `/api` 요청을 `http://localhost:8080`로 프록시
- **Session Management**: sessionStorage를 사용한 로그인 정보 저장
- **Cookie Authentication**: Axios `withCredentials: true` 설정

### State Management
- React 내장 상태 관리 (useState, useEffect)
- sessionStorage (인증 정보)
- localStorage (사용자별 캘린더 데이터)
- Custom Events (쪽지 시스템 크로스 컴포넌트 통신)

## 🚀 시작하기

### 필수 요구사항
- Node.js 16.x 이상
- npm 또는 yarn
- 백엔드 서버 (http://localhost:8080)

### 설치 및 실행

```bash
# 의존성 설치
npm install

# 개발 서버 실행 (http://localhost:5173)
npm run dev

# 프로덕션 빌드
npm run build

# 빌드 미리보기
npm run preview

# 린트 검사
npm run lint
```

### 환경 설정

프록시 설정은 `vite.config.js`에 정의되어 있습니다:

```javascript
server: {
  proxy: {
    '/api': {
      target: 'http://localhost:8080',
      changeOrigin: true,
    }
  }
}
```

## 📁 프로젝트 구조

```
frontend_plant_comunity/
├── src/
│   ├── assets/              # 정적 리소스
│   │   └── images/          # 배너 및 농장 이미지
│   ├── common/              # 재사용 가능한 UI 컴포넌트
│   │   ├── Button.jsx
│   │   ├── Input.jsx
│   │   ├── Modal.jsx
│   │   ├── Select.jsx
│   │   └── Title.jsx
│   ├── components/          # 기능별 컴포넌트
│   │   ├── message/         # 쪽지 시스템
│   │   │   ├── MessageAlarm.jsx
│   │   │   ├── MessageDetail.jsx
│   │   │   ├── MessageList.jsx
│   │   │   └── MessageWrite.jsx
│   │   ├── CalendarDiary.jsx
│   │   ├── DeletePlan.jsx
│   │   ├── Join.jsx
│   │   ├── Login.jsx
│   │   ├── PageNextAndPrev.jsx
│   │   ├── WateringPlan.jsx
│   │   └── Weather.jsx
│   ├── layout/              # 레이아웃 컴포넌트
│   │   ├── BasicLayout.jsx
│   │   ├── BoardLayout.jsx
│   │   ├── Header.jsx
│   │   └── MyPageSideLayout.jsx
│   ├── page/                # 페이지 컴포넌트
│   │   ├── Admin/           # 관리자 페이지
│   │   ├── Board/           # 게시판 페이지
│   │   ├── MyFarm/          # 스마트팜 페이지
│   │   ├── MyPage/          # 마이페이지
│   │   ├── QnA/             # 문의 페이지
│   │   ├── Main.jsx         # 홈 화면
│   │   └── Find.jsx         # 아이디/비밀번호 찾기
│   ├── validate/            # 폼 검증
│   │   └── joinValidate.js
│   ├── App.jsx              # 메인 라우팅
│   └── main.jsx             # 진입점
├── index.html
├── vite.config.js
└── package.json
```

## 👥 팀원 기여

### 주요 담당 기능

#### 1. MyFarm (스마트팜 관리 시스템)
**담당자**: 본인

**구현 기능**:
- 실시간 센서 데이터 모니터링 (1초 주기 갱신)
- 식물별 최적 환경 조건 표시 및 상태 판단
- Chart.js 기반 센서 데이터 시각화 (온도, 습도, 조도, 토양수분)
- 기간별 데이터 집계 및 그래프 표시 (시간별/일별)
- 장치 작동 로그 및 가동 시간 추적

**관련 파일**:
- [src/page/MyFarm.jsx](src/page/MyFarm.jsx)
- [src/page/MyPlantInfo.jsx](src/page/MyPlantInfo.jsx)
- [src/page/EnvironmentInfo.jsx](src/page/EnvironmentInfo.jsx)

#### 2. 홈 화면
**담당자**: 본인

**구현 기능**:
- 스마트팜 주요 기능 소개 섹션
- 인기 게시물 표시 (조회수/좋아요 기준)
- 반응형 카드 레이아웃
- 게시물 미리보기 및 상세 페이지 연동

**관련 파일**:
- [src/page/Main.jsx](src/page/Main.jsx)

#### 3. 쪽지 시스템 (메시징)
**담당자**: 본인

**구현 기능**:
- 실시간 읽지 않은 쪽지 알림 (헤더 배지)
- 받은 쪽지 / 보낸 쪽지 분리 관리
- 3가지 발송 모드 (단일, 다중, 전체 발송)
- 사용자 검색 및 자동완성
- 키보드 내비게이션
- 논리적 삭제 (발신자/수신자 별도 플래그)
- 이벤트 기반 실시간 업데이트
- 답장 기능

**관련 파일**:
- [src/components/message/MessageAlarm.jsx](src/components/message/MessageAlarm.jsx)
- [src/components/message/MessageList.jsx](src/components/message/MessageList.jsx)
- [src/components/message/MessageDetail.jsx](src/components/message/MessageDetail.jsx)
- [src/components/message/MessageWrite.jsx](src/components/message/MessageWrite.jsx)

### 기타 기능

다른 팀원들이 담당한 기능:
- 커뮤니티 게시판 시스템
- 마이페이지 (회원 정보, 내가 쓴 글, 식물 캘린더)
- 1:1 문의 시스템
- 관리자 페이지 (회원/게시판/문의 관리)
- 회원가입 및 인증 시스템

## 🔌 API 엔드포인트

### 인증 & 회원
```
GET    /api/members/login                    - 로그인
POST   /api/members                          - 회원가입
GET    /api/members/checkId/{id}             - 아이디 중복 확인
GET    /api/members/checkTell/{tell}         - 휴대폰 중복 확인
GET    /api/members/checkBusinessNum/{num}   - 사업자번호 중복 확인
GET    /api/members/findId                   - 아이디 찾기
GET    /api/members/findPw                   - 비밀번호 찾기
GET    /api/members/{memId}                  - 회원 정보 조회
PUT    /api/members/{memId}                  - 회원 정보 수정
PUT    /api/members/{memId}/withdraw         - 회원 탈퇴
GET    /api/members/status/{memId}           - 회원 상태 조회
GET    /api/members/search?keyword={keyword} - 회원 검색
```

### 게시판
```
GET    /api/boards/boardList-paging          - 페이징된 게시판 목록
GET    /api/boards/boardList                 - 전체 게시판 목록
GET    /api/boards/boardDetail/{boardNum}    - 게시물 상세
GET    /api/boards/{memId}                   - 회원별 게시물 목록
POST   /api/boards                           - 게시물 작성
PUT    /api/boards/{boardNum}                - 게시물 수정
DELETE /api/boards/{boardNum}                - 게시물 삭제
GET    /api/categories                       - 카테고리 목록
```

### 댓글
```
GET    /api/comments/{boardNum}              - 댓글 목록 조회
POST   /api/comments                         - 댓글 작성
PUT    /api/comments/{commentNum}            - 댓글 수정
DELETE /api/comments/{commentNum}            - 댓글 삭제
```

### 좋아요
```
GET    /api/likes/{boardNum}/check           - 좋아요 상태 확인
POST   /api/likes/{boardNum}                 - 좋아요 토글
```

### 쪽지
```
GET    /api/messages/unread/count/{memberId}              - 읽지 않은 쪽지 수
GET    /api/messages/box/received/{memberId}              - 받은 쪽지 목록
GET    /api/messages/box/sent/{memberId}                  - 보낸 쪽지 목록
GET    /api/messages/{messageId}                          - 쪽지 상세
POST   /api/messages/{senderId}                           - 쪽지 발송
DELETE /api/messages/{msgNum}/{memberId}?deleteType={type} - 쪽지 삭제
```

### MyFarm (스마트팜)
```
GET    /api/plants                           - 식물 목록
GET    /api/sensor/last                      - 최근 센서 데이터
GET    /api/sensor                           - 센서 데이터 히스토리
GET    /api/logs                             - 장치 작동 로그
```

### 다이어리
```
GET    /api/diaries?memId={memId}            - 회원별 다이어리 목록
POST   /api/diaries                          - 다이어리 작성
PUT    /api/diaries/{diaryId}                - 다이어리 수정
DELETE /api/diaries/{diaryId}                - 다이어리 삭제
```

### 문의 (QnA)
```
GET    /api/qna/member/{memId}               - 회원 문의 목록
GET    /api/qna/admin/list                   - 관리자 문의 목록
GET    /api/qna/detail/{qnaNum}              - 문의 상세
GET    /api/qna/categories                   - 문의 카테고리 목록
POST   /api/qna                              - 문의 작성
POST   /api/qna/admin/{qnaNum}/answer        - 문의 답변
PUT    /api/qna/admin/{qnaNum}/status        - 문의 상태 변경
```

### 관리자
```
GET    /api/members/admin/list               - 전체 회원 목록
GET    /api/members/admin/search             - 회원 검색
PUT    /api/members/admin/{memId}/delete     - 회원 삭제
PUT    /api/members/admin/{memId}/restore    - 회원 복구
```

### 날씨
```
GET    /api/weather/geocode                  - 날씨 정보
```

## 🎨 라우팅 구조

```
/                           → 홈 화면
/board                      → 게시판 목록
/write-board               → 게시물 작성
/board/detail/:boardNum    → 게시물 상세
/update-board/:boardNum    → 게시물 수정

/myfarm                     → MyFarm 컨테이너
  /my-plant-info           → 내 식물 정보
  /environment-info        → 환경 정보 (그래프)

/mypage                     → 마이페이지 컨테이너
  /my-info                 → 회원 정보 수정
  /my-board-list           → 내가 쓴 글
  /my-calendar             → 식물 캘린더

/qna                        → 문의 목록
/qna/:qnaNum               → 문의 상세
/qnaboard                   → 문의 작성

/messages                   → 쪽지함 (받은/보낸)
/messages/:messageId       → 쪽지 상세
/messages/write            → 쪽지 작성

/find                       → 아이디/비밀번호 찾기

/admin                      → 관리자 컨테이너
  /qna                     → 문의 관리
  /board                   → 게시판 관리
  /member                  → 회원 관리
```

## 🔑 주요 기술적 특징

### 실시간 데이터 업데이트
- 센서 데이터: 1초마다 갱신
- 쪽지 알림: 1초마다 갱신
- 이벤트 기반 업데이트: window events를 이용한 크로스 컴포넌트 통신

### 데이터 시각화
- Chart.js로 아름다운 센서 데이터 그래프
- 반응형 차트 및 커스터마이징 가능한 시간 범위
- 영역 차트 (트렌드), 막대 차트 (비교)

### 고급 기능
- React Quill을 이용한 리치 텍스트 편집
- 이미지 업로드 및 관리
- 반복 이벤트를 지원하는 캘린더
- 대댓글을 지원하는 중첩 댓글
- 쪽지 논리적 삭제 (soft delete)
- 다중 수신자 메시징

### 사용자 경험
- sessionStorage를 이용한 로그인 지속성
- 역할 기반 UI 렌더링
- 로딩 상태 및 에러 핸들링
- 파괴적 작업에 대한 확인 대화상자
- 빈 상태 처리

## 📄 라이선스

이 프로젝트는 팀 프로젝트로 제작되었습니다.

---

**개발 기간**: 2025년
**팀 프로젝트**: 식물 커뮤니티 플랫폼
**Frontend Repository**: [frontend_plant_comunity](https://github.com/yoojisu90/frontend_plant_comunity)
