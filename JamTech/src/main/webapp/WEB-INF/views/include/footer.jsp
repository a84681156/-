<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <footer id="footer">
        <div id="footerBox">
            <div id="footerNav">
                <ul>
                    <li>
                        <a href="<c:url value='/siteIntroduce/siteIntroduce'/>" >사이트소개</a>
                    </li>
                    <li>
                        <a href="#">사이트이용약관</a>
                    </li>
                    <li>
                        <a href="#">개인정보처리방침</a>
                    </li>
                    <li>
                        <a href="<c:url value='/relateAd/relateAd'/>" >제휴&약관</a>
                    </li>
                </ul>
            </div><!-- footerNav -->
    
            <div id="footerIn">
    
                <div id="fInfo">
                    <p id="fLogo">
                        <img src="<c:url value='/img/logo.png'/>" alt="siteLogo">
                    </p>
    
                    <div class="Info">
                        <span class="a"> 사이트이름 </span>
                        <span class="footer_bar"></span> 
                        <span class="a"> 대표 : 이재민 </span>
                        <span class="footer_bar"></span> 
                        <span class="a"> 울산광역시 남구 삼산중로 9 </span>
                        <br>
                        <span class="a"> 비즈니스&광고제휴 문의 <a href="<c:url value='https://www.google.co.kr/'/>" class="b" >a84681156@gmail.com</a> / FAX : 02-6442-8081 / 010-8468-1156</span>
                    </div>
                </div><!--fInfo-->
    
                <div id="copyright">
                    <p class="c">&copy;사이트이름. All Rights Reserved.</p>
                </div>
    
            </div><!-- footerIn -->
        </div>
        

    </footer><!-- footer -->