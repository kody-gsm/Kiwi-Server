# New Kiwi Backend

#기능

1. 예약기능

-Request : Sring으로 y M d랑  학번이랑 상태를 받음("yyyy-MM-dd")  
Ex) reservationDate : "2024-10-21" schoolId : "2101", mode : "leave"
-하는 일 : reservationDate까지 mode로 바꿈
Ex) 2024년 10월 21일까지 leave로 바꿈
-URL : reservation
-그 외 알아야 할 것 
Method = POST
return = 에러가 나오면 badRequest로 에러를 보낼거임 그게 아니면 200 : "Success"가 보내짐

3. Mypage기능
-Request : None
-하는 일 : 지금 로그인한 유저의 모든 것을 출력
-URL : user/mypage
-그 외 알아야 할 것
Method = GET
return =
     String schoolNumber;
     String gender;
     String username;
     String mode;
     short attendance;
     short absent;
     short etcAbsent;
     short recoAbsent;
     short diseAbsent;
     short late;
     short etcLate;
     short recoLate;
     short diseLate;
     short earlyLeave;
     short etcLeave;
     short recoLeave;
     short diseLeave;
     short outing;
     short etcOuting;
     short recoOuting;
     short diseOuting;

4. 회원가입 기능
-Request : String으로 username, password, pwCheck, email, gender, schoolNumber를 받음
Ex) username : "진건희", passwrod : "12341234", pwCheck : "12341234", email : "s23054", gender : "WOMAN", schoolNumber : "2318"
-하는 일 : 회원가입(DB에 데이터 추가)
-URL : auth/signup
-그 외 알아야 할 것
Method : POST
return : 200 or error

5. 로그인 기능
-Request : String으로 email, password을 받음
Ex) email : "s23054", password : "12341234"
-하는 일 : 로그인(쿠키랑 세선 추가)
-URL : auth/signin
-그 외 알아야 할 것
Method : POST
return : 200 or error

6. 필터 기능
-Request : String으로 grade와 mode를 받음
Ex) grade : "2300", mode : "leave"
-하는 일 : grade와 mode를 기준으로 DB에서 맞는 데이터를 가져오는 일
-URL : filter
-그 외 알아야 할 것
Method : POST
만약 grade가 없으면 mode만 기준으로 하고 mode가 없으면 grade만 기준으로 한다.
return :
    String gender;
    Short school_number;
    String mode;
    String username;

7. 일괄 출석
-Request : String으로 grade
Ex) grade : "2000"
-하는 일 : grade를 기준으로 DB에 데이터들을 attendance로 바꾸는 일
-URL : alltendance
-그 외 알아야 하는 것
Method : POST
만약 grade가 없으면 전원을 출석으로 바꿈
return : 200 or badrequest

8. 캘린더 기능
-Request : yyyy-MM-dd로 date를 받음
Ex) date : "2024-10-21"
-하는 일 : 지금까지 기록들을 출력함
-URL : calendar
-그 외 알아야 하는 것
Method : POST
reuturn : 바뀐 시간이랑 그때 모드를 가져옴

9. Notice
-참고 사항 글쓴이는 이건 모름...
