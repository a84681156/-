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
    <link rel="stylesheet" href="<c:url value='/member/css/jobs.css'/>">

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

    <div id="jobsContainer">
    
        <div id="jobsIntro">
            <img src="<c:url value='/img/boardmain.png'/>" >
            <div>
                JOBS <br>
                본인의 기술스택과 성향에 맞는 구인구직 공고를 만날 수 있는 구인구직 게시판
            </div>
        </div><!-- crewsIntro -->
    
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
                     <c:forEach var="jobsboardDTO" items="${list}">
	                    <tbody>
							<tr>
								<td class="jobsPostNo">
									${jobsboardDTO.jobs_post_no}
								</td>
								<td class="jobsImg">
									<div class="jobs_img">
	                                   	<img src="<c:url value='/img/no_Img.gif'/>" alt="">
	                               	</div>
								</td>
								<td class="jobsTitle">
									<a href="<c:url value= '/jobs/read${ph.sc.getQueryString() }&jobs_post_no=${jobsboardDTO.jobs_post_no }' />">
										${jobsboardDTO.jobs_title} 
									</a>
								</td>
								<td class="jobsInfo">
	                                <ul>
	                                    <li>구인구직 : ${jobsboardDTO.jobs_employ}</li>
                                    	<li>근무파트 : ${jobsboardDTO.jobs_part}</li>
                                    	<li>근무형태 : ${jobsboardDTO.jobs_type}</li>
                                    	<li>경력유무 : ${jobsboardDTO.jobs_career}</li>
                                    	<li>근무지역 : ${jobsboardDTO.jobs_local}</li>
	                                </ul>
	                            </td>
	                            <c:choose>
						            <c:when test="${jobsboardDTO.jobs_reg_date.time >= startOfToday}">
						              	<td class="regdate">
						              		<fmt:formatDate value="${jobsboardDTO.jobs_reg_date}" pattern="HH:mm" type="time"/>
						              	</td>
						            </c:when>
						            <c:otherwise>
						              	<td class="regdate">
						              		<fmt:formatDate value="${jobsboardDTO.jobs_reg_date}" pattern="yyyy-MM-dd" type="date"/>
						             	</td>
						            </c:otherwise>
					            </c:choose>
                          		<td class="jobsProgress">
                          		 	${jobsboardDTO.jobs_progress}
                          		</td>
								<td class="jobsWriter">
									${jobsboardDTO.jobs_writer}
								</td>
								<td class="jobsHits">
									${jobsboardDTO.jobs_cnt}
								</td>
	                           	<td class="jobsRecomms">
	                           		${jobsboardDTO.jobs_recommend}
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
                <a href="<c:url value='/jobs/write'/>">글쓰기</a>
            </button>
        </div>

        <form action="<c:url value='/jobs/list'/>" class="srcForm" method="get">
            <select class="search-option" name="option">
            <!--  ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""} : 너겨받은 A or 공백이면 선택하겠다 다른거면 공백이라는 뜻 -->
            	<option value="A" ${ph.sc.option=='A' || ph.sc.option=='C' ? "selected" : ""}>제목+내용</option>
          		<option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
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
		       				<a href="<c:url value='/jobs/list${ph.sc.getQueryString(ph.beginPage-1) }'/>"> &lt;</a>   
						</li>
					</c:if>
					<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
						<li>
		       				<a href="<c:url value='/jobs/list${ph.sc.getQueryString(i) }'/>"> ${i}</a>
						</li>
					</c:forEach>
					<c:if test="${ph.showNext}">
						<li>
		       				<a href="<c:url value='/jobs/list${ph.sc.getQueryString(ph.endPage+1) }'/>"> &gt;</a>   
						</li>
					</c:if>
   				</ul>
			</div><!-- pageBtn -->
		</c:if>

        
        
    </div><!-- jobsContainer -->
    
	<%@include file="./include/footer.jsp"%>
</body>
</html>