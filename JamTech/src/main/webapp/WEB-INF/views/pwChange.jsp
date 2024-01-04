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
    <link rel="stylesheet" href="<c:url value='/member/css/pwChange.css'/>" type="text/css">

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
    <div class="pwChangeInfo">
        <div class="pwChangeInfoCon">
            <h1>비밀번호변경</h1>
            <form action="<c:url value='/findIdPw/changePw'/>" method="post">
                <div class="pwChangeInfoBox"> 
                    
                    <h2> <i class="fa-solid fa-address-card"></i> 비밀번호 변경하기</h2>

                    <ul>
                        <li class="siteForm2">
                        	<input type="hidden" name="name" value="${userDTO.name}">
                        	<input type="hidden" name="tel" value="${userDTO.tel}">
                        	<input type="hidden" name="email" value="${userDTO.email}">
                        	<input type="hidden" name="user_id" value="${userDTO.user_id}">
                            <label class="pwChangeTitle"> <i class="fa-solid fa-lock"></i> 새 비밀번호</label><br>
                            <input type="password" class="pwChange_formControl" id="newPw" name="user_pw" placeholder="새 비밀번호"><br>
                        </li> 
                        <li class="siteForm2">
                            <label class="pwChangeTitle"> <i class="fa-solid fa-lock"></i> 새 비밀번호 확인</label><br>
                            <input type="password" class="pwChange_formControl" id="newPwChk" name="user_pw2s" placeholder="새 비밀번호 확인"><br>
                        </li>  
                    </ul>
                </div><!-- pwChangeInfoBox -->
                <button type="submit" class="pwChange_btn"> <i class="fa-solid fa-right-to-bracket"></i> <a>비밀번호 변경하기</a> </button>
            </form>
        </div><!-- pwChangeInfoCon -->
    </div><!-- pwChangeInfo -->
    
        <script>
	    let msg = "${msg}";
	    
	    if(msg=="CHANGE_ERR"){
	    	alert("PW변경에 실패했습니다.");
	    }
    </script>
</body>
</html>