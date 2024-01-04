<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>

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
    <link rel="stylesheet" href="<c:url value='/member/css/loginPage.css'/>" type="text/css">

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
    <div id="login">

        <div class="loginBox">
            <h2>로그인</h2>
            <form action="<c:url value='/login/login'/>" method="get" class="loginForm" onsubmit="return formCheck(this);" >
            	<div id="msg">
				    <c:if test="${not empty param.msg}">
						<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
				    </c:if>        
				</div>
                <div class="text">
                    <label class="loginFormTitle"> <i class="fa-solid fa-user"></i> 아이디</label><br>
                    <input type="text" class="login_formControl" id="userId" name="user_id" placeholder="ID" value="${cookie.user_id.value }" autofocus><br><br>
                    <label class="loginFormTitle"> <i class="fa-solid fa-lock"></i> 비밀번호</label><br>
                    <input type="password" class="login_formControl" id="userPw" name="user_pw" placeholder="PASSWORD"><br>
                    <input type="hidden" name="toURL" value="${param.toURL }">
                </div>
                
                <div class="loginMenu">
                    <div class="login_checkboxControl">
                        <input type="checkbox" class="autologin_chkBox" id="autologin" name=rememberId ${empty cookie.user_id.value ? "" : "checked" }> 
                        <label class="autologin_text" for="autologin">아이디 저장</label>
                    </div>

                    <div class="Menu">
                        <ul class="regi_sch">
                            <li>
                                <a href="<c:url value='/register/agree'/>" class="b" >회원가입</a>
                            </li>
                            <span class="login_bar"></span> 
                            <li>
                                <a href="<c:url value='/findIdPw/findIdPw'/>" class="b" >아이디/비밀번호 찾기</a>
                            </li>
                        </ul>

                        <button type="submit" class="logBtn" onclick="loginCheck()"> <i class="fa-solid fa-right-to-bracket"></i> 로그인</button>
                        <div class="returnMain">
                            <a href="<c:url value='/'/>" class="b" >메인페이지 돌아가기</a>
                        </div>
                    </div>
                </div><!-- loginMenu -->
            </form>
        </div><!-- loginBox -->
    </div><!-- login -->
    
    <script src="<c:url value='/member/js/loginPage.js'/>" ></script>
    <script>
	    function formCheck(frm) {
	        let msg ='';
	
	        if(frm.user_id.value.length==0) {
	            setMessage('ID를 입력해주세요.', frm.user_id);
	            return false;
	        }
	
	        if(frm.user_pw.value.length==0) {
	            setMessage('PASSWORD를 입력해주세요.', frm.user_pw);
	            return false;
	        }
	        return true;
	   }
    	
	    function setMessage(msg, element){
	        document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
	
	        if(element) {
	            element.select();
	        }
	   }
    </script>
</body>
</html>