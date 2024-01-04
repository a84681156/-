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
    
    <!-- 폰트링크 -->
    <link rel="preconnect" href="https://fonts.googleapis.com"><!--출처-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><!--출처-->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"><!--실제로 사용되는것-->
    
    <!-- 로컬css -->
 
    <link rel="stylesheet" href="<c:url value='/member/css/qa.css'/>">

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
	
	<script>
		let msg="${msg}";
		if(msg == "DEL_OK") {
			alert("게시글이 삭제되었습니다.");	
		}
	    if(msg=="LIST_ERR") {
		    alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
	    }
		if(msg == "WRT_OK") {
			alert("성공적으로 등록되었습니다.");			
		}
		if (msg == "MOD_OK") {
			alert("게시글 수정을 성공하였습니다.");			
		}
		if(msg == "DEL_ERROR"){
			alert ("게시글 삭제에 실패하였습니다.");
		}
	</script>

    <div id="qaContainer">
    
        <div id="qaIntro">
            <img src="<c:url value='/img/boardmain.png'/>" >
            <div>
                QA <br>
                개발과정에서 생긴 궁금증을 질답으로 해결하는 개발자들만의 커뮤니티 게시판
            </div>
        </div><!-- qaIntro -->

        <div id="board-list">
            <div class="container">
                <table class="board-table">
                    <thead>
                    <tr>
                        <th scope="col" class="th-num">번호</th>
                        <th scope="col" class="th-img">이미지</th>
                        <th scope="col" class="th-title">제목</th>
                        <th scope="col" class="th-Inof">정보</th>
                        <th scope="col" class="th-date">등록일</th>
                        <th scope="col" class="th-result">진행상황</th>
                        <th scope="col" class="th-writer">작성자</th>
                        <th scope="col" class="th-hits">조회수</th>
                        <th scope="col" class="th-recomms">추천수</th>
                    </tr>
                    </thead>
                    <c:forEach var="qaboardDTO" items="${list}">
	                    <tbody>
		                    <tr>
		                        <td class="qaPostNo">
									${qaboardDTO.qa_post_no}
								</td>
		                        <td class="qaImg">
									<div class="qa_img">
	                                   	<img src="<c:url value='/img/no_Img.gif'/>" alt="">
	                               	</div>
								</td>
		                        <td class="qaTitle">
									<a href="<c:url value= '/qa/read${ph.sc.getQueryString() }&qa_post_no=${qaboardDTO.qa_post_no }' />">
										${qaboardDTO.qa_title} 
									</a>
								</td>
		                        <td class="qainfo">
		                            <ul>
		                                <li>대분야 : ${qaboardDTO.qa_big_sep}</li>
		                                <li>소분야 : ${qaboardDTO.qa_small_sep}</li>
		                                <li>언어 : ${qaboardDTO.qa_language}</li>
		                                <li>IDE : ${qaboardDTO.qa_ide}</li>
		                            </ul>
		                        </td>
		                        <c:choose>
						            <c:when test="${qaboardDTO.qa_reg_date.time >= startOfToday}">
						              	<td class="regdate">
						              		<fmt:formatDate value="${qaboardDTO.qa_reg_date}" pattern="HH:mm" type="time"/>
						              	</td>
						            </c:when>
						            <c:otherwise>
						              	<td class="regdate">
						              		<fmt:formatDate value="${qaboardDTO.qa_reg_date}" pattern="yyyy-MM-dd" type="date"/>
						             	</td>
						            </c:otherwise>
					            </c:choose>
		                        <td class="qaProgress">
                          		 	${qaboardDTO.qa_progress}
                          		</td>
								<td class="qaWriter">
									${qaboardDTO.qa_writer}
								</td>
								<td class="qaCnt">
									${qaboardDTO.qa_cnt}
									
								</td>
	                           	<td class="qaRecommend">
	                           		${qaboardDTO.qa_recommend}
	                           	</td>
		                    </tr>
						</tbody>
                    </c:forEach>
                    <tr>
                    	<td colspan="9" style="text-align: center; border: none;">
	                    	<div class="noPost">
								<c:if test="${ph.getTotalCnt()==null || ph.getTotalCnt()==0 }">
									<div>게시물이 없습니다.</div>		
								</c:if>
							</div>
                    	</td>
                    </tr>
                </table><!-- board-table -->
            </div><!-- container -->
        </div><!-- board-list -->
        

        <div class="writeBtn">
            <button type="button">
                <a href="<c:url value='/qa/write'/>" >글쓰기</a>
            </button>
        </div>

        <form action="<c:url value='/qa/list'/>" class="srcForm" method="get">
            <select class="search-option" name="option">
            <!--  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""} : 너겨받은 A or 공백이면 선택하겠다 다른거면 공백이라는 뜻 -->
            	<option value="A" ${ph.sc.option=='A' || ph.sc.option=='C' ? "selected" : ""}>제목+내용</option>
          		<option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
          		<option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
            </select>
            <input type="text" class="srcText" name="keyword" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
            <button type="submit" class="srcBtn"><i class="fa-solid fa-magnifying-glass"></i></button>
        </form>

        <c:if test="${ph.getTotalCnt()!=null && ph.getTotalCnt()!=0 }">
			<div class="pageBtn">
				<ul>
					<c:if test="${ph.showPrev}">
						<li>
		       				<a href="<c:url value='/qa/list${ph.sc.getQueryString(ph.beginPage-1) }'/>"> &lt;</a>   
						</li>
					</c:if>
					<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
						<li>
		       				<a href="<c:url value='/qa/list${ph.sc.getQueryString(i) }'/>"> ${i}</a>
						</li>
					</c:forEach>
					<c:if test="${ph.showNext}">
						<li>
		       				<a href="<c:url value='/qa/list${ph.sc.getQueryString(ph.endPage+1) }'/>"> &gt;</a>   
						</li>
					</c:if>
   				</ul>
			</div><!-- pageBtn -->
		</c:if>

    </div><!-- qaContainer -->
    
   	<%@include file="./include/footer.jsp"%>
</body>
</html>