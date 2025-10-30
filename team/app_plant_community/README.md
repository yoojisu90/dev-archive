# Plant Community App

식물 애호가들을 위한 모바일 커뮤니티 애플리케이션

## 프로젝트 소개

Plant Community는 식물을 사랑하는 사람들이 모여 정보를 공유하고, 재배 일지를 기록하며, 실시간으로 소통할 수 있는 모바일 애플리케이션입니다.

## 기술 스택

### Frontend
- **React Native** (0.81.4) - 크로스 플랫폼 모바일 앱 개발
- **Expo** (~54.0.13) - React Native 개발 프레임워크
- **Expo Router** (~6.0.11) - 파일 기반 라우팅 시스템
- **WebSocket (@stomp/stompjs)** - 실시간 채팅 통신
- **SockJS Client** - WebSocket 폴백 지원
- **Axios** - HTTP 클라이언트
- **AsyncStorage** - 로컬 데이터 저장

### Backend
- **Spring Boot** - RESTful API 서버
- **MyBatis** - SQL 매퍼 프레임워크
- **MariaDB** - 관계형 데이터베이스
- **WebSocket (STOMP)** - 실시간 양방향 통신

## 주요 기능

### 1. 인증 및 프로필 관리
- 회원가입 및 로그인
- 프로필 이미지 업로드 및 수정
- 사용자 정보 관리

### 2. 커뮤니티 게시판
- 게시글 작성, 수정, 삭제
- 카테고리별 게시글 분류
- 이미지 첨부 기능
- 댓글 기능

### 3. 실시간 채팅 시스템
#### 채팅방 관리
- 1:1 채팅방 생성
- 단체 채팅방 생성 및 관리
- 동적 채팅방 이름 생성
- 참여자 추가/제거

#### 실시간 메시징
- WebSocket 기반 실시간 메시지 전송/수신
- 텍스트, 이미지, 파일 전송 지원
- 읽지 않은 메시지 카운트
- 마지막 메시지 시간 표시

#### 채팅 UI/UX
- 메시지 타입별 다른 UI (텍스트/이미지/파일)
- 이미지 전체화면 뷰어
- 파일 다운로드 및 열기
- 입력 중 표시 (typing indicator)

### 4. 나의 농장 (MyFarm)
- 재배 중인 식물 관리
- 캘린더 기반 일지 작성
- 식물별 재배 기록 조회

## 프로젝트 구조

```
app_plant_community/
├── app/
│   ├── (tabs)/              # 탭 기반 네비게이션
│   │   ├── (home)/          # 홈/게시판
│   │   │   ├── index.jsx    # 게시글 목록
│   │   │   ├── write.jsx    # 게시글 작성
│   │   │   └── boardDetail.jsx
│   │   ├── chat/            # 채팅
│   │   │   ├── index.jsx    # 채팅방 목록
│   │   │   └── room.jsx     # 채팅방 화면
│   │   ├── myFarm/          # 나의 농장
│   │   │   ├── index.jsx
│   │   │   ├── calendar/    # 재배 일지 캘린더
│   │   │   ├── farm/        # 농장 관리
│   │   │   └── logs/        # 일지 목록
│   │   └── myPage/          # 마이페이지
│   │       ├── index.jsx
│   │       └── editProfile.jsx
│   └── auth/                # 인증
│       ├── login.jsx
│       └── join.jsx
├── utils/
│   ├── api.js              # API 요청 함수
│   ├── storage.js          # AsyncStorage 유틸
│   └── websocket.js        # WebSocket 서비스
└── components/             # 재사용 가능한 컴포넌트
```

## 주요 개발 내용 및 개선 사항

### 1. 실시간 채팅 시스템 구현 및 최적화

#### WebSocket 연결 안정화
**문제**: 중복 WebSocket 연결로 인한 "There is no underlying STOMP connection" 에러 발생

**해결**:
- WebSocket 싱글톤 패턴 구현
- 연결 상태 확인 로직 추가
- 기존 연결 정리 후 새 연결 생성

```javascript
// utils/websocket.js
connect(onConnected, onError) {
  // 이미 연결 중이거나 연결되어 있으면 무시
  if (this.client && (this.connected || this.client.active)) {
    console.log('WebSocket이 이미 연결되어 있습니다')
    if (onConnected) onConnected()
    return
  }

  // 기존 클라이언트가 있으면 정리
  if (this.client) {
    try {
      this.client.deactivate()
    } catch (e) {
      console.warn('기존 클라이언트 정리 중 에러:', e)
    }
  }
  // ... 연결 로직
}
```

#### 채팅방 목록 실시간 업데이트
**문제**: 새 메시지 수신 시 채팅방 목록이 실시간으로 갱신되지 않음

**해결**:
- `refreshKey` state를 활용한 FlatList 강제 리렌더링
- `extraData` props로 상태 변경 감지

```javascript
// app/(tabs)/chat/index.jsx
const [refreshKey, setRefreshKey] = useState(0)

// 메시지 수신 시 refreshKey 증가
setRefreshKey((prev) => prev + 1)

// FlatList 설정
<FlatList
  key={refreshKey}
  extraData={refreshKey}
  keyExtractor={(item) => `${item.roomId}-${refreshKey}`}
  // ...
/>
```

### 2. 동적 단체 채팅방 이름 생성

**문제**: 1:1 채팅에서 인원 추가 시 "알 수 없는 채팅방"으로 표시

**해결**:
- 참여자 정보 기반 동적 채팅방 이름 생성
- 참여자 수에 따른 표시 방식 차별화

```javascript
// 3명 이하: 모든 이름 표시
if (participantNames.length <= 3) {
  room.roomName = participantNames.join(', ')
}
// 4명 이상: "이름1, 이름2 외 n명"
else {
  room.roomName = `${participantNames.slice(0, 2).join(', ')} 외 ${participantNames.length - 2}명`
}
```

### 3. 단체 채팅방 프로필 이미지 그리드

**기능**: 단체 채팅방에서 최대 4명의 프로필 이미지를 2x2 그리드로 표시

**구현**:
```javascript
// 2x2 그리드 레이아웃
<View style={styles.groupProfileContainer}>
  {item.groupProfileImages.slice(0, 4).map((member) => (
    <View key={member.memId} style={styles.groupProfileItem}>
      {imageUrl ? (
        <Image source={{ uri: imageUrl }} style={styles.groupProfileImage} />
      ) : (
        <View style={styles.groupProfileImage}>
          <Text style={styles.groupProfileText}>{member.name.charAt(0)}</Text>
        </View>
      )}
    </View>
  ))}
</View>
```

### 4. 채팅 메시지 타입별 처리 및 UI 개선

#### 이미지 메시지 전체화면 뷰어
- 이미지 클릭 시 Modal을 통한 전체화면 보기
- 확대/축소 가능한 이미지 뷰어

```javascript
<TouchableOpacity
  onPress={() => {
    setViewingImage(`http://192.168.30.97:8080${item.fileUrl}`)
  }}
>
  <Image
    source={{ uri: `http://192.168.30.97:8080${item.fileUrl}` }}
    style={styles.messageImage}
    resizeMode="cover"
  />
</TouchableOpacity>

{/* 전체화면 이미지 뷰어 */}
<Modal visible={!!viewingImage} transparent={true} animationType="fade">
  <View style={styles.imageViewerContainer}>
    <TouchableOpacity
      style={styles.imageViewerClose}
      onPress={() => setViewingImage(null)}
    >
      <Ionicons name="close" size={32} color="#fff" />
    </TouchableOpacity>
    <Image
      source={{ uri: viewingImage }}
      style={styles.fullScreenImage}
      resizeMode="contain"
    />
  </View>
</Modal>
```

#### 파일 메시지 다운로드/열기
- React Native Linking API를 활용한 파일 열기
- 파일명과 아이콘 표시 (이미지의 경우 파일명 제거로 깔끔한 UI)

```javascript
<TouchableOpacity
  onPress={() => {
    const fileUrl = `http://192.168.30.97:8080${item.fileUrl}`
    Alert.alert('파일', item.content, [
      { text: '취소', style: 'cancel' },
      {
        text: '열기',
        onPress: async () => {
          const supported = await Linking.canOpenURL(fileUrl)
          if (supported) {
            await Linking.openURL(fileUrl)
          }
        }
      }
    ])
  }}
>
  {/* 파일 아이콘 및 정보 */}
</TouchableOpacity>
```

### 5. 백엔드 참여자 재초대 로직

**문제**: 나갔던 사용자를 다시 초대 시 duplicate key 에러 발생

**해결**:
- 참여자 존재 여부 확인
- 이미 존재하는 경우 `IS_ACTIVE` 플래그만 재활성화
- 새로운 참여자인 경우 INSERT

```java
// ChatService.java
@Transactional
public void addParticipant(int roomId, String memId) {
    Integer existsCount = chatMapper.checkParticipantExists(roomId, memId);

    if (existsCount != null && existsCount > 0) {
        // 재활성화
        chatMapper.reactivateParticipant(roomId, memId);
    } else {
        // 새로 추가
        chatMapper.insertParticipant(roomId, memId);
    }

    // DIRECT → GROUP 자동 변환 로직
    ChatRoomDTO chatRoom = chatMapper.getChatRoom(roomId);
    if ("DIRECT".equals(chatRoom.getRoomType())) {
        int activeParticipants = chatMapper.countActiveParticipants(roomId);
        if (activeParticipants >= 3) {
            chatMapper.updateRoomType(roomId, "GROUP");
        }
    }
}
```

```xml
<!-- chat-mapper.xml -->
<update id="reactivateParticipant">
    UPDATE CHAT_PARTICIPANT
    SET IS_ACTIVE = TRUE,
        JOINED_AT = NOW(),
        LAST_READ_AT = NOW()
    WHERE ROOM_ID = #{roomId}
      AND MEM_ID = #{memId}
</update>
```

## 기술적 도전과 해결

### 1. React Native 환경에서의 WebSocket 안정성
- **도전**: 앱 포그라운드/백그라운드 전환 시 연결 관리
- **해결**: `useFocusEffect`를 활용한 화면 포커스 기반 연결/해제 관리

### 2. FlatList 리렌더링 최적화
- **도전**: 상태 변경 시에도 FlatList가 업데이트되지 않는 문제
- **해결**: `key`, `extraData`, `keyExtractor` 조합으로 강제 리렌더링

### 3. 크로스 플랫폼 파일 처리
- **도전**: Web API와 React Native API의 차이
- **해결**: `expo-image-picker`, `expo-document-picker`, `Linking` API 활용

### 4. 실시간 데이터 동기화
- **도전**: 채팅방 목록과 메시지의 실시간 동기화
- **해결**: WebSocket 구독 패턴과 상태 관리 최적화

## 실행 방법

### 환경 설정
```bash
# 의존성 설치
npm install

# 개발 서버 실행
npm start

# Android 실행
npm run android

# iOS 실행
npm run ios
```

### 백엔드 서버 설정
```
API_BASE_URL: http://192.168.30.97:8080
WebSocket Endpoint: /ws-chat
```

## 데이터베이스 스키마

### 주요 테이블
- **MEMBER**: 회원 정보
- **BOARD**: 게시글
- **CHAT_ROOM**: 채팅방
- **CHAT_PARTICIPANT**: 채팅 참여자
- **CHAT_MESSAGE**: 채팅 메시지
- **FARM**: 농장 정보
- **PLANT**: 식물 정보
- **FARM_LOG**: 재배 일지

## 향후 개선 계획

- [ ] 푸시 알림 기능 추가
- [ ] 오프라인 메시지 캐싱
- [ ] 이미지 압축 및 최적화
- [ ] 채팅방 검색 기능
- [ ] 메시지 답장 기능
- [ ] 음성/영상 통화 기능

## 개발 환경

- **Node.js**: v16+
- **npm**: v8+
- **Expo CLI**: ~6.0
- **Android Studio** / **Xcode**
- **JDK**: 11+
- **Spring Boot**: 2.x
- **MariaDB**: 10.x

## 라이센스

This project is private.

## 개발자

팀 프로젝트 - GitHerb

---

**개발 기간**: 2025.10.17~2025.11.14

**주요 담당**: 채팅 시스템 개발 및 최적화, 실시간 통신 구현, UI/UX 개선
