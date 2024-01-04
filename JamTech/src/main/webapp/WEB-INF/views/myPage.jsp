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
    <link rel="stylesheet" href="<c:url value='/member/css/myPage.css'/>" type="text/css">

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

	<%@include file="./include/header.jsp"%>
	
    <div class="container">

        <div class="mypageBox">

            <h2>마이페이지</h2>

            <div class="mypageInfo">

                <table class="mypageTable">
                    <tr>
                        <th>이름</th>
                        <td>${userDTO.name }</td>

                    </tr>

                    <tr>
                        <th>닉네임</th>
                        <td>${userDTO.nickname }</td>
                    </tr>

                    <tr>
                        <th>전화번호</th>
                        <td>${userDTO.tel }</td>
                    </tr>

                    <tr>
                        <th>이메일</th>
                        <td>${userDTO.email }</td>

                    </tr>
                </table>

            </div><!-- mypageInfo -->
				
            <div class="alterBtnBox">
            	<a href="<c:url value='/myPage/modifyy?user_id=${user_id }'/>" ><input type="button" class="alterBtn" value="정보수정"></a> <br>
            	<a href="<c:url value='/'/>"><input type="button" class="alterBtn" value="취소"></a>
            </div><!-- alterBtnBox -->

        </div><!-- mypageBox -->

    </div><!-- container -->
    
   	<%@include file="./include/footer.jsp"%>

</body>
</html>