# Schedule-develop Project

---

## 수정 내용
- 보완하기
  - 로그인 기능 (이전 과제 진행 시 도전하다 완성하지 못한 부분)
  - spring security를 사용하지 않고 필터방식을 사용한 이유
    - 가장 큰 이유는 아직 Spring security를 완전히 이해하지 못했기 때문입니다.
    - 다른 이유로는 아직은 단순한 로직을 수행하기 때문에 필터 방식으로도 충분히 구현 가능하기 때문입니다.
  - 토큰 처리 방법으로 헤더가 아닌 쿠키를 선택한 이유
    - 첫 번째로 쿠키에 넣을 경우 관리가 편하다는 장점이 있습니다.
    - 다만, 보안에 취약하다는 단점이 있는데 지금 만드는 프로잭트의 경우 보안을 크게 신경 쓸 정도가 아니기 때문에 쿠키를 선택했습니다.


- 기능 개선
  - 유효성 검사 추가
    - 회원 가입시 아이디의 길이를 2 ~ 15자 제한
    - 회원 가입시 비밀번호가 대/소문자와 숫자, 특수문자를 사용하여 8자 이상으로 설정
  - GlobalExceptionHandler 추가
    - 현재 사용된 예외처리 IllegalArgumentException, RuntimeException 적용
    
---

## 과제 소개
- 일정 관리 앱 서버입니다.
- 일정을 작성 및 조회, 수정, 삭제가 가능합니다.
- 일정별로 댓글을 작성/조회/수정/삭제가 가능합니다.
- 일정을 작성하기 전 먼저 사용자 등록이 필요합니다.

## 기능
### Schedule
- 일정 작성 가능
- 일정 조회 가능
    - 페이지와 페이지 당 보여줄 일정 갯수를 조절 가능
    - 전체 일정 조회 가능
    - 특정 일정 조회 가능
      - 특정 일정을 조회하기 위해서는 해당 일정의 `scheduleKey`가 필요
- 일정 수정 가능
  - 일정을 수정하기 위해서는 해당 일정의 `scheduleKey`가 필요 
  - 일정 수정은 `scheduleDate`, `scheduleTitle`, `scheduleDescription` 만 수정 가능
- 일정 삭제 가능
  - 일정을 삭제하기 위해서는 해당 일정의 `scheduleKey`가 필요
  - 일정 삭제 시 해당 일정에 작성된 댓글이 같이 삭제

### Member
- 비밀번호는 암호화되어 저장됩니다.
- user 추가 가능
- user 정보 조회 가능
    - 정보 조회는 `userKey`와 `password` 필요
- user 정보 수정 가능
    - `eamil`만 수정 가능
    - 수정 시 `password` 필요
- user 정보 삭제 가능
    - 삭제 시 `password` 필요

### Comments
- 댓글 추가 가능
- 댓글 조회 가능
  - 댓글을 조회하기 위해서는 댓글이 작성된 일정의 `scheduleKey`가 필요
- 댓글 수정 가능
  - 댓글을 수정하기 위해서는 해당 댓글의 `commentsKey`가 필요
- 댓글 삭제 가능
  - 댓글을 삭제하기 위해서는 해당 댓글의 `commentsKey`가 필요
---
## API
https://www.notion.so/Schedule-API-85e423564b1847edb264194587353a37

---
## ERD
### 개체
- Schedule
- Member
- Comments
### 속성
- Schedule 
  - `scheduleKey`
  - `writerName`
  - `scheduleDate`
  - `scheduleTitle`
  - `scheduleDescription`
  - `createdDateTime`
  - `modifiedDateTime`
- Member
  - `userKey`
  - `userName`
  - `userEmail`
  - `password`
  - `createdDateTime`
  - `modifiedDateTime`
- Comments
  - `commentsKey`
  - `commenter`
  - `comment`
  - `createdDateTime`
  - `modifiedDateTime`
### 관계
- 사용자는 일정을 작성, 조회, 수정, 삭제할 수 있다.
- 사용자는 댓글을 작성, 조회, 수정, 삭제할 수 있다.
- 사용자는 자신의 정보를 작성, 조회, 수정, 삭제할 수 있다.
- 하나의 일정에 여러개의 댓글이 작성될 수 있다.
- 사용자는 일정을 작성하고 추가로 일정 담당 유저들을 배치할 수 있다.
---
  ![ERD](https://ifh.cc/g/lvXPZJ.png)