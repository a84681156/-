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
    <!-- 폰트링크 -->
    <link rel="preconnect" href="https://fonts.googleapis.com"><!--출처-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><!--출처-->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"><!--실제로 사용되는것-->
    
    <!-- 로컬css -->
    <link rel="stylesheet" href="<c:url value='/member/css/findIdPw.css'/>" type="text/css">

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
    <div class="findInfo">
        <div class="findInfoCon">
            <h1>회원정보찾기</h1>
            <form action="<c:url value='/findIdPw/findId'/>" method="post">
                <div class="findInfoBox"> 
                    
                        <h2> <i class="fa-solid fa-address-card"></i> 아이디 찾기</h2>

                        <ul>
                            <li class="siteForm2">
                                <label class="findTitle"> <i class="fa-solid fa-user"></i> 이름</label><br>
                                <input type="text" class="find_formControl" id="userName" name="name" placeholder="이름"><br>
                            </li> 
                            <li class="siteForm2">
                                <label class="findTitle"> <i class="fa-solid fa-mobile-screen-button"></i> 전화번호</label><br>
                                <input type="text" class="find_formControl" id="tel" name="tel" placeholder="전화번호"><br>
                            </li>  
                        </ul>
                        <div class="siteForm2">
                            <label class="findTitle"><i class="fa-solid fa-envelope"></i> 이메일</label><br>
                            <input type="text" class="find_formControl" id="email" name="email" placeholder="이메일"><br>
                        </div>
                </div><!-- findInfoBox -->

                <button type="submit" class="find_btn"> <i class="fa-solid fa-right-to-bracket"></i> <a>아이디찾기</a></button>
            </form>

            <form action="<c:url value='/findIdPw/findPw'/>" method="post">
                <div class="findInfoBox"> 
                    
                    <h2> <i class="fa-solid fa-address-card"></i> 비밀번호 찾기</h2>

                    <ul>
                        <li class="siteForm2">
                            <label class="findTitle"> <i class="fa-solid fa-user"></i> 이름</label><br>
                            <input type="text" class="find_formControl" id="userName" name="name" placeholder="이름"><br>
                        </li> 
                        <li class="siteForm2">
                            <label class="findTitle"> <i class="fa-solid fa-mobile-screen-button"></i> 전화번호</label><br>
                            <input type="text" class="find_formControl" id="tel" name="tel" placeholder="전화번호"><br>
                        </li>  
                    </ul>
                    <ul>
                        <li class="siteForm2">
                            <label class="findTitle"> <i class="fa-solid fa-envelope"></i> 이메일</label><br>
                            <input type="text" class="find_formControl" id="email" name="email" placeholder="이메일"><br>
                        </li>
                        <li class="siteForm2">
                            <label class="findTitle"> <i class="fa-solid fa-user"></i> 아이디</label><br>
                            <input type="text" class="find_formControl" id="id" name="user_id" placeholder="아이디"><br>
                        </li>
                    </ul>
                </div><!-- findInfoBox -->

                <button type="submit" class="find_btn2"> <i class="fa-solid fa-right-to-bracket"></i> <a>비밀번호 변경하기</a> </button> 
            </form>
        </div>
    </div>
    
    <script>
	    let msg = "${msg}";
	    
	    if(msg=="FIND_ERR"){
	    	alert("ID찾기에 실패했습니다.");
	    }
    </script>
</body>
</html>