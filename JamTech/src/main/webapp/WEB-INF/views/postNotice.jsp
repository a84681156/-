<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

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
    <link rel="stylesheet" href="<c:url value='/member/css/postAll.css'/>" >

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
            <div class="postMainBox">
                <table>
        			<form action="" id="form">>
	                    <tr>
	                        <td class="postTitle" colspan="9">
	                            <label>제목</label>
	                            <p name="notice_title">
	                            	<c:out value='${noticeboardDTO.notice_title }'/>
	                            	<input type="hidden" name="notice_title" value="${noticeboardDTO.notice_title }">
	                            </p>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<td class="postInfo">
	                            <label>글번호</label>
	                            <p name="notice_post_no">
	                            	<c:out value='${noticeboardDTO.notice_post_no}'/>
	                            	<input type="hidden" name="notice_post_no" value="${noticeboardDTO.notice_post_no }">
	                            </p>
	                        </td>
	                        <td class="postInfo">
	                            <label>작성자</label>
	                            <p name="notice_writer">
	                            	<c:out value='${noticeboardDTO.notice_writer}'/>
	                            	<input type="hidden" name="notice_writer" value="${noticeboardDTO.notice_writer }">
	                            </p>
	                        </td>
	                        <td class="postInfo">
	                            <label>작성일</label>
	                            <p name="notice_reg_date">
		                            <c:choose>
							            <c:when test="${noticeboardDTO.notice_reg_date.time >= startOfToday}">
							              		<fmt:formatDate value="${noticeboardDTO.notice_reg_date}" pattern="HH:mm" type="time"/>
							            </c:when>
							            <c:otherwise>
							              		<fmt:formatDate value="${noticeboardDTO.notice_reg_date}" pattern="yyyy-MM-dd" type="date"/>
							            </c:otherwise>
						            </c:choose>
						            <input type="hidden" name="notice_reg_date" value="${noticeboardDTO.notice_reg_date }">
								</p>
	                        </td>
<!-- 	                        <td class="ReviseDeleteBtn">
	                            <ul>
	                                <li class="revise">
	                                    <button type="button"><i class="fa-solid fa-pen-to-square"></i></button>
	                                </li>
	                                <li class="delete">
	                                    <button type="button"><i class="fa-solid fa-trash-can"></i></button>
	                                </li>
	                            </ul>
	                        </td> -->
	                    </tr>
	                    <tr>
	                        <td class="postContent" colspan="9">
	                           <div class="contentText" name="notice_content">
	                                <c:out value='${noticeboardDTO.notice_content }'/>
	                                <input type="hidden" name="notice_content" value="${noticeboardDTO.notice_content }">
	                            </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td class="postRecomm_List" colspan="9">
	                            <div>
	                                <a href="<c:url value='/notice/list'/>" >
	                                    <input type="button" class="postListBtn" id="listBtn" value="글목록">
	                                </a>
	                            </div>
	                        </td>  
	                    </tr>
        			</form>
                </table>
            </div><!-- postMainBox -->
    </div><!-- container -->

	<%@include file="./include/footer.jsp"%>
	    
    <script>
		//게시글 목록페이지 이동
		$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
	   		$("#listBtn").on("click", function(){
	   			location.href="<c:url value='/notice/list?page=${page}&pageSize=${pageSize}'/>"
	   		})
	   	})
    </script>
</body>
</html>