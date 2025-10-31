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

## 🎯 프로젝트 개요 및 단계별 구성

| 단계 | 기간 | 주제 | 기술 스택 |
|------|------|------|---------|
| **1️⃣ IoT 개발** | 2025.09.11 ~ 09.24 | 스마트팜 IoT 기기 개발 및 자동제어 알고리즘 구축 | Python, Raspberry Pi, GPIO, MariaDB |
| **2️⃣ 웹 개발** | 2025.09.25 ~ 10.16 | React 기반 식물 커뮤니티 구축 (웹) | React, Spring Boot, MariaDB, Chart.js |
| **3️⃣ 앱 개발** | 2025.10.17 ~ 11.14 | React Native 기반 IoT 연동 및 실시간 채팅 | React Native, Expo, WebSocket, Spring Boot |

---

## 📊 데이터베이스 설계

![ERD Diagram](./images/ERD관계도.png)

---

## 🔗 단계별 프로젝트 요약

### 공통 - Spring boot 백엔드 개발
**[📄백엔드 - 프로젝트 링크](https://github.com/yoojisu90/dev-archive/tree/main/team/backend_plant_comunity)**

---

### 1️⃣ IoT 기기 개발

**🎯 목표**
- Raspberry Pi와 센서를 활용한 실시간 환경 모니터링 시스템 구축
- 식물 최적 환경 조건에 맞춘 자동 제어 알고리즘 개발
- 센서 데이터 정확성 95% 이상 달성

**💻 기술 스택**
- Python 3.9+, Raspberry Pi, DHT-22, LDR+ADC, MariaDB

**📊 주요 성과**
- ✅ 센서 데이터 수집 성공률 **95% 이상** 달성
- ✅ null 값 필터링으로 DB 오류 데이터 완전 제거
- ✅ 3회 재시도 로직으로 안정성 확보
- ✅ 바질(Basil) 최적 환경 조건 기반 자동 제어

**[📄IoT 센서 및 기기 제어 - 프로젝트 링크](https://github.com/yoojisu90/dev-archive/tree/main/IoT-python)**

---

### 2️⃣ React 웹 개발

**🎯 목표**
- IoT 센서 데이터를 시각화하는 웹 대시보드 구축
- 식물 커뮤니티 및 게시판 기능 개발
- 실시간 쪽지 시스템 구현

**💻 기술 스택**
- React 18.2.0, Spring Boot 3.4.9, Chart.js, React Big Calendar, MariaDB

**📊 주요 성과**
- ✅ 1초 주기 센서 데이터 실시간 갱신
- ✅ 아름다운 Chart.js 그래프 시각화
- ✅ 직관적인 캘린더 기반 일정 관리
- ✅ 이벤트 기반 크로스 컴포넌트 실시간 업데이트

**[📄웹 프론트엔드 - 프로젝트 링크](https://github.com/yoojisu90/dev-archive/tree/main/team/frontend_plant_comunity)**

---

### 3️⃣ React Native 앱 개발

**🎯 목표**
- 크로스 플랫폼 모바일 앱 개발 (iOS/Android)
- WebSocket 기반 실시간 채팅 시스템 구현
- IoT 데이터와 커뮤니티 기능의 완전한 통합

**💻 기술 스택**
- React Native 0.81.4, Expo, WebSocket (@stomp/stompjs), Spring Boot 3.4.9

**📊 주요 성과**
- ✅ WebSocket 싱글톤으로 안정적인 연결 관리
- ✅ FlatList 최적화로 효율적 리렌더링
- ✅ 다양한 메시지 타입 처리 (텍스트/이미지/파일)
- ✅ 크로스 플랫폼 호환성 (iOS/Android)

**[📄앱 프론트엔드 - 프로젝트 링크](https://github.com/yoojisu90/dev-archive/tree/main/team/app_plant_community)**

---

## 🎥 시연 영상

### 웹 (React)
<!--
<video width="100%" controls>
  <source src="videos/web_demo.mp4" type="video/mp4">
</video>
-->
*영상 준비 중...*

### 모바일 앱 (React Native)
<!--
<video width="100%" controls>
  <source src="videos/app_demo.mp4" type="video/mp4">
</video>
-->
*영상 준비 중...*

---

## 👥 프로젝트 정보

**프로젝트명**: GitHerb - 식물 커뮤니티 플랫폼
**개발 기간**: 2025.09.11 ~ 2025.11.14 (65일)
**개발 인원**: 4명 (풀 스택 개발)

---

## 📞 연락처

- **Email**: yoo901013@gmail.com
- **GitHub**: [@yoojisu90](https://github.com/yoojisu90)
- **Portfolio**: [GitHub Portfolio](https://github.com/yoojisu90/dev-archive)

---

**⭐ 3단계로 완성한 이 프로젝트가 마음에 드신다면 스타를 눌러주세요!**
