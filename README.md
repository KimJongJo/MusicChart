# MusicChart

# 뮤직 차트
html, css, javascript, java, servlet, jsp, oracle(DB) 를 사용해서 간단한 CRUD 기능이 들어가 있는 뮤직 차트를 만들었습니다.

인원 : 1명 <br>
프로젝트 기간 : 1일

C - 회원가입 <br>
R - 노래 검색 <br>
U - 노래 수정 <br>
D - 플레이리스트에서 제거 <br>

# Table
 뮤직 차트 - MUSIC_BOARD(SONG_NO, SONG_TITLE, SONG_SINGER, SONG_LYRICS, SONG_LIKE, SONG_GENRE, SONG_DEL) <br>
 재생 목록 - PLAYLIST(LIST_NO, SONT_TITLE, SONT_SINGER, SONG_LYRICS, SONG_LIKE,CH, LIST_DEL) <br>
 회원 - MEMBER(MEMBER_NO, MEMBEr_ID, MEMBER_PW, MEMBER_NICKNAME, MEMBER_DEL) <br>

## 메인화면
![image](https://github.com/user-attachments/assets/341cbbda-dc09-4e82-bafd-59f8ef773529)

## 회원가입
![image](https://github.com/user-attachments/assets/2e423b51-2a61-42c9-8b2f-5d4ae1f3ed98)

유효성 검사
<ul>
  <li>
    아이디 : 4~13 글자의 한글, 영어, 숫자를 넣을 수 있습니다.
  </li>
  <li>
    비밀번호 : 비밀번호 확인의 input 값과 일치해야 가입 가능합니다.
  </li>
  <li>
    닉네임 : 3~11 글자의 한글, 영어, 숫자를 넣을 수 있습니다.
  </li>
</ul>

위의 세 조건이 모두 만족해야 회원가입이 가능합니다.

## 로그인
로그인을 하게되면 로그인 한 계정의 재생 목록을 출력합니다.
![image](https://github.com/user-attachments/assets/39b544a0-4ef2-446b-a5f7-2b2038458ec4)

## 노래 추가
노래 추가하기 버튼을 누르면 DB에 저장된 노래 목록을 불러서 화면에 나타나게 합니다.
![image](https://github.com/user-attachments/assets/f2bcbcd1-d9da-4329-ba5b-4f1daba2fd07)

![image](https://github.com/user-attachments/assets/89ecec3e-814e-41be-880b-6bb019d57ea6)

![image](https://github.com/user-attachments/assets/8690aad0-bc0a-44dd-9f50-3bf2799e5ae3)

## 검색
검색창을 통해 입력을 하게 되면 입력한 글자를 포함한 노래들을 불러와서 화면에 나타나게 합니다.
### 제목으로 검색
![image](https://github.com/user-attachments/assets/56c9b6b1-2acc-47d5-ae5e-b25eaa53d5d9)

![image](https://github.com/user-attachments/assets/8896ed82-7ed8-4d18-ace5-79be418f203f)

### 가수이름으로 검색


![image](https://github.com/user-attachments/assets/d178c8e5-fbc7-4f12-a76c-680fa32651c0)

![image](https://github.com/user-attachments/assets/9364a21d-1f75-44dc-8229-5ec469deb3f3)


## 플레이 리스트에서 삭제
플레이 리스트 오른쪽에 파란 X 표시를 클릭하면 클릭한 노래가 플레이리스트에서 삭제됩니다.
![image](https://github.com/user-attachments/assets/0e426c15-6792-4b53-b1f9-b5942ef5eb92)

![image](https://github.com/user-attachments/assets/5c5898be-eb18-45e5-8535-37001dff68b4)

![image](https://github.com/user-attachments/assets/1e12f3ff-8b80-482f-967e-fb760dcb589c)


## 노래 정보 보기
제목을 클릭하게 되면 클릭한 노래의 정보가 나타납니다.
![image](https://github.com/user-attachments/assets/46717f63-f67e-4c57-b5f7-a02509529f34)

![image](https://github.com/user-attachments/assets/897d97f4-1786-4b18-864b-51b89edcdcdb)

## 가수의 노래 목록 보기
가수를 클릭하게 되면 클릭한 가수의 노래 목록이 나타납니다.
![image](https://github.com/user-attachments/assets/8ad3ddce-edc6-4dd0-8d4c-1c1d6a359a24)

![image](https://github.com/user-attachments/assets/5499465d-a56e-4749-9007-773e825b85e8)


## 노래 수정
운영자 아이디로 로그인을 하게 되면 운영자 모드로 넘어갑니다.

![image](https://github.com/user-attachments/assets/9ac4adb7-fb4a-4306-83ef-f63e6e3d4eee)

![image](https://github.com/user-attachments/assets/8202a6b5-2a8b-4e6e-85e9-4944ea2c2ddd)


운영자 아이디로 로그인을 했을 때 노래 제목을 클릭하면 클릭한 노래를 수정할 수 있는 창이 나타납니다.

![image](https://github.com/user-attachments/assets/7583ff42-fa16-41f9-82ab-d53d58b69a66)

![image](https://github.com/user-attachments/assets/58c2a3ef-8388-40a5-b577-271e4fe7ac10)


