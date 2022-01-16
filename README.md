"# MukZziBbaOnline" 

JDK 1.8
이클립스 사용

2022.01.07-2022.01.17

01.07(금)
클라이언트 UI 제작

01.09(일)
부분 모듈화

01.10(월)
모듈화를 염두한 설계로 다시 제작
회원가입 추가
게임 내용을 가위바위보로 변경
프로젝트 이름 수정 TankTank -> MukZziBbaOnline
mainFrame을 싱글톤으로
기본적인 통신확인
가위바위보 에 따라 결과를 계산해서 객체로 결과 돌려줌 (에러)

01.11(화)
ois열 때 에러 발생 (ois자체도 null 값 대입되어 있음)
스트림 생성시 잘못된 생성자를 넣어주는 문제 해결

소켓과 IO스트림 오류 해결, Serializable 인터페이스 상속 문제 해결

가위바위보 실행 결과 서버로 전송하고 서버에서 결과 객체 넘겨받기 구현

로그인 구현 (아이디 비밀번호)
로그인 정보를 서버에 주는 것까지 성공

그 이후에 서버에서 다시 정보를 돌려주려고 하니까 스트림에서 계속 에러 발생
스트림 공부 필요

01.12 (수)
로그인, 회원가입, 통신, 서버측 자료구조 기본적인 것들 구현
가위바위보 하면 결과 반영해서 서버에 업데이트하고 유저에게 다시 전송하는 것 미구현

01.13 (목)
게임 결과 주고받기 구현
결과를 기반으로 서버에서 유저 정보 갱신 구현
유저 정보 보내기 구현

미구현 : 로비로 갈 때마다 새로 받도록 해야 함, 랭킹보드, 채팅

01.14 (금)
클라이언트 측에서 닉네임, 비밀번호 규칙 검증
로그인, 회원가입 ui 수정
프레임 bounds 수정 (화면 중앙)

01.15 (토)
채팅창 구현 (버그 많음)
frame, dialog을 main프레임의 중앙에 배치
UI 전체적으로 개선 (이미지 삽입 등)
랭킹 정확도 개선


아쉬운 점

로컬이 아니라 실제 서버 환경에서 테스트를 해보니 통신에 꽤 시간이 걸렸고,
버튼 하나 누르는 것도 사실은 그 때마다 쓰레드를 나눠야 했는데 그러지 못했음