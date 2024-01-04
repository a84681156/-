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
    <link rel="stylesheet" href="<c:url value='/member/css/pwResult.css'/>" >

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
    <section class="pwChangeResult">
        <div class="pwChangeResultBox">
            <label>비밀번호가 변경되었습니다. 재 로그인 해주십시오.</label>
        </div>
        <div class="result_btn">
            <a href="<c:url value='/'/>" >메인페이지로 돌아가기</a>
        </div>
    </section>
    
        <script>
	    let msg = "${msg}";
	    
	    if(msg=="CHANGE_OK"){
	    	alert("PW변경에 성공했습니다.");
	    }
    </script>
</body>
</html>