<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com"><!--출처-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><!--출처-->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"><!--실제로 사용되는것-->
    
    <!-- 로컬css -->
    <link rel="stylesheet" href="<c:url value='/member/css/join.css'/>" type="text/css">

    <!-- fontAsome -->
    <script src="https://kit.fontawesome.com/159aca3e6d.js" crossorigin="anonymous"></script>

    <!-- 슬릭css -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <!-- 스크립트순서 : 쿼리 -> 슬릭 -> 내코드 -->
    <!-- 제이쿼리js -->
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <!-- 슬릭js -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

</head>
<body>
    <section class="join">
        
        <form action="<c:url value = "/register/save"/>" method="post" class="joinForm">
            <h1>회원가입정보 입력</h1>
            <div class="userInfo">
                <div class="site">
                    <h2> <i class="fa-solid fa-address-card"></i> 사이트이용정보 입력</h2>
                    <ul>
                        <li class="siteForm">
                            <label class="infoTitle"> 
                                <i class="fa-solid fa-user"></i>아이디
                            </label><br>

                            <input 
                            type="text" 
                            class="join_formControl" 
                            id="userId" 
                            name="user_id" 
                            placeholder="아이디 입력(6~16자리)"
                            
                            >

                            <button type="button" class="doubleCheck" id="idChk">
                                <i class="fa-solid fa-check"></i>중복체크
                            </button>
                        </li>
                            
                        <li class="siteForm">
                            <label class="infoTitle"> 
                                <i class="fa-solid fa-user"></i> 닉네임
                            </label><br>
                            <input 
                            type="text"  
                            class="join_formControl" 
                            id="userNickName" 
                            name="nickname"
                            placeholder="닉네임 입력(2자리 이상)"
                            >

                            <button type="button" class="doubleCheck" id="nicknameChk">
                                <i class="fa-solid fa-check"></i>중복체크
                            </button>
                        </li>
                    </ul>

                    <ul>
                        <li class="siteForm">
                            <label class="infoTitle"> 
                                <i class="fa-solid fa-lock"></i> 비밀번호
                            </label><br>
                            <input 
                            type="password" 
                            class="join_formControl" 
                            id="userPw" 
                            name="user_pw"
                            placeholder="비밀번호 입력(8~16자리)" 
                            ><br>
                        </li>

                        <li class="siteForm">
                            <label class="infoTitle">
                                <i class="fa-solid fa-lock"></i>비밀번호 확인
                            </label><br>
                            <input 
                            type="password" 
                            class="join_formControl" 
                            id="userPw2" 
                            name="user_pw2" 
                            placeholder="비밀번호 확인"
                            ><br>
                        </li>
                    </ul>
                </div><!-- site -->

                <div class="personal">
                    <h2> <i class="fa-solid fa-address-card"></i> 개인정보 입력</h2>

                    <ul>
                        <li class="siteForm2">
                            <label class="infoTitle">
                                <i class="fa-solid fa-user"></i>
                                이름</label><br>
                            <input 
                            type="text" 
                            class="join_formControl" 
                            id="userName" 
                            name="name" 
                            placeholder="이름 입력"
                            ><br>
                        </li> 
                        <li class="siteForm2">
                            <label class="infoTitle">
                                <i class="fa-solid fa-mobile-screen-button"></i>
                                전화번호
                            </label><br>
                            <input 
                            type="text" 
                            class="join_formControl" 
                            id="userTel" 
                            name="tel" 
                            placeholder="전화번호 입력 ex)010-0000-0000"
                            ><br>
                        </li>  
                    </ul>
                    <ul>
                        <li class="siteForm2">
                            <label class="infoTitle">
                                <i class="fa-solid fa-envelope"></i> 이메일
                            </label><br>
                            <input 
                            type="email" 
                            class="join_formControl" 
                            id="userEmail" 
                            name="email" 
                            placeholder="이메일 입력 ex)xxxx@xxxx.xxx"
                            ><br>
                        </li>
                        <li class="siteForm2">
                            <label class="infoTitle" for="user_company">
                                <i class="fa-solid fa-building"></i> 기업회원
                            </label>   
                            <input 
                            type="checkbox" 
                            class="join_chkBoxControl_user" 
                            id="user_company" 
                            name="membertype"
                            value="기업회원"
                            onclick="checkOnlyOne(this)"
                            >

                            <label class="infoTitle" for="user_personal">
                                <i class="fa-solid fa-user"></i> 개인회원
                            </label>
                            <input 
                            type="checkbox" 
                            class="join_chkBoxControl_user" 
                            id="user_personal" 
                            name="membertype"
                            value="개인회원"
                           	onclick="checkOnlyOne(this)"
                            >
                        </li>
                    </ul>
                    
                </div><!-- personal -->

                <div class="emailSms">
                    <h2> <i class="fa-solid fa-address-card"></i> 기타 개인설정 (선택사항)</h2>
                    <ul>
                        <li class="siteForm2">
                            <label class="infoTitle">
                                <i class="fa-solid fa-envelope"></i> 이메일수신여부
                            </label><br>
                            <label class="agree_text" for="agree_email">
                                Email을 수신받겠습니다.
                            </label>
                            <input 
							type="checkbox" 
							class="join_chkBoxControl_emailSms" 
							id="agree_email" 
							name="reception"
							value="이메일수신"
						    onclick="checkOnlyOne1(this)"
							><br>
                            
                        </li>
                        <li class="siteForm2">
                            <label class="infoTitle">
                                <i class="fa-solid fa-message"></i> SMS수신여부
                            </label><br>
                            <label class="agree_text" for="agree_sms">
                                SMS를 수신받겠습니다.
                            </label>
                            <input 
                            type="checkbox" 
                            class="join_chkBoxControl_emailSms" 
                            id="agree_sms" 
                            name="reception"
                            value="문자수신"
                            onclick="checkOnlyOne1(this)"
                            ><br>
                            
                        </li>
                    </ul>
                </div><!-- emailSms -->
            </div><!-- userInfo -->

            <button type="submit" class="join_btn" onclick="joinCheck()"><i class="fa-solid fa-right-to-bracket"></i>회원가입</button>

            <script src="<c:url value='/member/js/join.js'/>" ></script>
        </form>
    </section><!-- join -->
    
    
    <script>

			//id중복확인
			$('#idChk').on("click", function(){
				let user_id = $("#userId").val();
				$.ajax({
					type:'POST',
					url: '/biz/register/idChk',
					headers : { "Content-Type" : "application/json"},
					dataType: 'text',  // 전송받을 데이터의 타입
		            data: user_id,  // 서버로 전송할 데이터
		            success: function(result){
						if(result=='y'){
							alert("사용가능한 아이디입니다.");
						} else if(result=='n'){
							alert("이미 사용중인 아이디입니다.")
						}
					},
					error : function(){ alert("error")}
				});
			});//idChk
			
			//nickname중복확인
			$('#nicknameChk').on("click", function(){
				let nickname = $("#userNickName").val();
				$.ajax({
					type:'POST',
					url: '/biz/register/nicknameChk',
					headers : { "Content-Type" : "application/json"},
					dataType: 'text',  // 전송받을 데이터의 타입
		            data: nickname,  // 서버로 전송할 데이터
		            success: function(result){
		            	if(nickname==''){
		            		alert("")
		            	}
						if(result=='y'){
							alert("사용가능한 닉네임입니다.");
						} else if(result=='n'){
							alert("이미 사용중인 닉네임입니다.")
						}
					},
					error : function(){ alert("error")}
				});
			});//nicknameChk
		
    </script>
    
    <script>
	    let msg = "${msg}";
	    
	    if(msg=="JOIN_ERROR"){
	    	alert("회원가입에 실패하였습니다.");
	    }
    </script>
</body>
</html>