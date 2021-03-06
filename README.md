# Spring session practice
> Spring에서 HttpSession과 Intercepter를 이용해 인가를 구현해본다. 
> 즉, 권한에 따라 행위에 제한을 둔다. 그리고 redis를 이용해 session을 저장해본다. 

### Environment
- Spring 2.4.5
- mvc, data-jpa, web, h2 
- java 8

### 기능 요구사항

- 인터셉터 부분 다시 듣기
- 일단 db 없이 만들어보기 (H2 이용)
- [x]  User, Post Domain Entity
- [x]  Controller, Service CRUD 
    - [x]  Post Create 시 User 정보 -> `@ArgumentResolver`

[//]: # (- [ ]  CRUD Test Code 작성)
- [x]  Session Handler 제작
    - [x]  SessionController
        - [x]  Check Session Info
- [x]  일단 모든 권한이 가능하도록 Intercepter을 통해 Session 관리
- [x]  권한
   - [x] User는 Get Method, ADMIN은 모든 권한
   - [X] 권한 별로 Interceptor을 다르게 둬야할듯.