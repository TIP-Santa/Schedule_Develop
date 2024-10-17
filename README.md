# Schedule-develop Project
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