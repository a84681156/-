<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<c:url value='/include/css/header_footer.css'/>" type="text/css">

<!-- 로그인 상태에 따라 링크 설정 -->
<c:set var="loginOutLink" value="${sessionScope.user_id==null ? '/login/loginPage' : '/login/logout' }" />
<c:set var="signMypageLink" value="${sessionScope.user_id==null ? '/register/agree' : '/myPage/myPage' }" />
<!-- 화면에 표시되는 문자 설정 -->
<c:set var="loginOut" value="${sessionScope.user_id==null ? 'Login' : 'Logout' }" />
<c:set var="signMypage" value="${sessionScope.user_id==null ? 'Sing in' : 'MyPage' }" />

<header id="header">
    <div id="headerIn">
        <h1 id="logo">
            <a href="<c:url value='/'/>" >
                <img src="<c:url value='/img/logo.png'/>" alt="" >
            </a>
        </h1>

        
        <nav id="gnb">
            <ul>
                <li>
                    <a href="<c:url value='/news/list'/>" >NEWS</a>
                </li>
                <li>
                    <a href="<c:url value='/crews/list'/>" >CREWS</a>
                </li>
                <li>
                    <a href="<c:url value='/jobs/list'/>" >JOBS</a>
                </li>
                <li>
                    <a href="<c:url value='/qa/list'/>" >QA</a>
                </li>
            </ul>
        </nav><!--gnb-->

        <div id="util">
            <div id="bfLogin">
                <ul>
                    <li>
                        <a href="<c:url value='${loginOutLink }'/>">${loginOut }</a>
                    </li>
    
                    <li>
                        <a href="<c:url value='${signMypageLink }'/>">${signMypage }</a>
                    </li>

                    <li>
                        <a href="<c:url value='/notice/list'/>">Notice</a>
                    </li>
                </ul>
            </div>
            
        </div><!--util-->
    </div><!--headerIn-->

</header><!--header-->

