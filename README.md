# Java와 DB를 연동한 중고 거래 시스템

회원들 간의 중고 거래에 대한 편리성과 채팅 및 리뷰 등록 및 조회 기능을 통해  
효율성을 제공하고자 했습니다.

### 담당 업무
- 로그인 및 회원가입
- 마이페이지 및 로그아웃
- 게시물 삭제

## 업무 상세 1.
__로그인 및 회원가입__
- 회원가입을 통해 회원의 정보를 회원 테이블에 INSERT합니다.
- id와 e-mail 중복 검사를 통해 테이블을 조회하여 해당 data가 없을 경우에만 회원가입이완료되도록 validation check합니다.
- 회원가입 후 id와 password가 일치한 회원 정보를 count() 함수를 이용하여 1이 반환되면 로그인이 진행되도록 구현하였습니다.

## 업무 상세 2.
__마이페이지 및 로그아웃__
- 로그인된 아이디와 인증하고자 하는 아이디가 일치하면 수정화면이 나타나도록 조건을 주었습니다.
- 수정하고자 하는 TextFeild 값을 getText()를 사용하여 값을 가져오고 ArraList에 저장합니다.
- setter메소드를 사용하여 ArrayList에 저장된 값을 VO에 넣어준 후 UPDATE합니다.
- 로그아웃 버튼을 누르게되면 초기화면으로 이동되도록 구현했습니다.

## 업무 상세 3.
__게시물 삭제__
- 본인이 작성한 게시물 리스트를 볼 수 있으며, 삭제하길 원하는 게시물을 입력 후 삭제 버튼을 누르면 해당 게시물이 DELETE되도록 구현했습니다.

## 프로젝트를 마치고
자바 Swing을 이용하여 중고 거래 시스템 GUI 인터페이스를 구현한 프로젝트 입니다.  
이 프로젝트를 진행하면서 처음으로 분산 버전 관리 시스템인 Git을 이용하였습니다. 새로운 branch를 생성하고 관리하는 방법,  file을 수정 후 변경한 사항을 commit하고 push하는 방법, 그리고 pull reqeust를 open하고 merge하는 방법을 익혔고 프로젝트를 효과적으로 관리하여 협업할 수 있었습니다. 또한, ArrayList를 활용하면서 자바 자료구조의 중요성을 느꼈습니다.    
JDBC를 연동하고 직접 SQL Query문을 작성하여 프로젝트에 적용시키면서 제약조건의 중요성을 많이 깨달았습니다. 그리고 회원가입에서 부터 게시물 삭제까지 CRUD 작업을 진행하면서 DB작업의 중요성을 느꼈습니다.
이 프로젝트를 진행하면서 아쉬웠던 점은 프로젝트 초기 테이블을 설계할 때 제약 조건을 제대로 주지못하여 DB에 anomaly가 발생한 점입니다.  
프로젝트 종료 후 테이블 구조를 분석하고 수정하여 해결할 수 있었습니다.


