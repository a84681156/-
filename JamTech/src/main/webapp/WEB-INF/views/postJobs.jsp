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
	        	<form action="" id="form">
		            <tr>
		                <td class="postTitle" colspan="11">
		                    <label>제목</label>
		                    <p name="jobs_title">
		                    	<c:out value='${jobsboardDTO.jobs_title }'/>
		                    	<input type="hidden" name="jobs_title" value="${jobsboardDTO.jobs_title }">
		                    </p>
		                </td>
		            </tr>
		            <tr>
		            	<td class="postInfo">
                           <label>글번호</label>
                           <p name="jobs_post_no">
  	                           <c:out value='${jobsboardDTO.jobs_post_no}'/>
	                           <input type="hidden" name="jobs_post_no" value="${jobsboardDTO.jobs_post_no }">
                           </p>
	                       </td>
		                <td class="postInfo">
		                    <label>작성자</label>
		                    <p name="jobs_writer">
		                    	<c:out value='${jobsboardDTO.jobs_writer}'/>
		                    	<input type="hidden" name="jobs_writer" value="${jobsboardDTO.jobs_writer }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>조회수</label>
		                    <p name="jobs_cnt">
		                    	<c:out value='${jobsboardDTO.jobs_cnt}'/>
		                    	<input type="hidden" name="jobs_cnt" value="${jobsboardDTO.jobs_cnt }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>작성일</label>
		                    <p name="jobs_reg_date">
	                            <c:choose>
						            <c:when test="${jobsboardDTO.jobs_reg_date.time >= startOfToday}">
						              		<fmt:formatDate value="${jobsboardDTO.jobs_reg_date}" pattern="HH:mm" type="time"/>
						            </c:when>
						            <c:otherwise>
						              		<fmt:formatDate value="${jobsboardDTO.jobs_reg_date}" pattern="yyyy-MM-dd" type="date"/>
						            </c:otherwise>
					            </c:choose>
					            <input type="hidden" name="jobs_reg_date" value="${jobsboardDTO.jobs_reg_date }">
							</p>
		                </td>
		                <td class="postInfo">
		                    <label>구인구직</label>
		                    <p name="jobs_employ">
		                    	<c:out value='${jobsboardDTO.jobs_employ }'/>
		                    	<input type="hidden" name="jobs_employ" value="${jobsboardDTO.jobs_employ }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>근무형태</label>
		                    <p name="jobs_type">
		                    	<c:out value='${jobsboardDTO.jobs_type }'/>
		                    	<input type="hidden" name="jobs_type" value="${jobsboardDTO.jobs_type }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>근무파트</label>
		                    <p name="jobs_part">
		                    	<c:out value='${jobsboardDTO.jobs_part }'/>
		                    	<input type="hidden" name="jobs_part" value="${jobsboardDTO.jobs_part }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>경력유무</label>
		                    <p name="jobs_career">
		                    	<c:out value='${jobsboardDTO.jobs_career }'/>
		                    	<input type="hidden" name="jobs_career" value="${jobsboardDTO.jobs_career }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>근무지역</label>
		                    <p name="jobs_local">
		                    	<c:out value='${jobsboardDTO.jobs_local }'/>
		                    	<input type="hidden" name="jobs_local" value="${jobsboardDTO.jobs_local }">
		                    </p>
		                </td>
		                <td class="postInfo">
		                    <label>진행상황</label>
		                    <p name="jobs_progress">
		                    	<c:out value='${jobsboardDTO.jobs_progress }'/>
		                    	<input type="hidden" name="jobs_progress" value="${jobsboardDTO.jobs_progress }">
		                    </p>
		                </td>
		                <td class="ReviseDeleteBtn">
		                    <ul>
		                        <li class="revise">
		                            <button type="button" id="modifyBtn"><i class="fa-solid fa-pen-to-square"></i></button>
		                        </li>
		                        <li class="delete">
		                            <button type="button" id="removeBtn"><i class="fa-solid fa-trash-can"></i></button>
		                        </li>
		                    </ul>
		                </td>
		            </tr>
		            <tr>
		                <td class="postContent" colspan="11">
		                    <div class="postContentImg">
		                        <img src="<c:url value='/img/no_Img.gif'/>" alt="" >
		                    </div>
		                    <div class="contentText" name="jobs_content">
		                        <c:out value='${jobsboardDTO.jobs_content }'/>
		                        <input type="hidden" name="jobs_content" value="${jobsboardDTO.jobs_content }">
		                    </div>
		                </td>
		            </tr>
		            <tr>
		                <td class="postRecomm_List" colspan="11">
							<ul>
								<li class="like">
								     <button type="button" id="recommendBtn1"><i class="fa-regular fa-thumbs-up"></i></button>
								     <button type="button" id="recommendBtn2" style="display:none"><i class="fa-solid fa-thumbs-up"></i></button>
							    </li>
							    <li class="likeNo"> </li>
							</ul>
							<div>
								<input type="button" class="postListBtn" id="listBtn" value="글목록">
							</div>
		                </td>
		            </tr>
	            </form>
                  <tr>
                    <td class="postCommentWrite" colspan="11">
                        <textarea class="postCommentWriteText" name="comments" id="commentWriteBox" cols="20" rows="5" placeholder="댓글을 입력하세요."></textarea> <br>
                        <p>
                        	<input type="button" class="postCommentBtn" id="sendBtn" value="댓글작성">
                        	<input type="button"  class="postCommentBtn" id="modBtn" value="댓글수정" style="display:none">
                        </p>
                    </td>
                      
	           		<div id="replyForm" style="display:none" class="replyForm">
						<input type="text" name="replyComments" class="relpyText" placeholder="답글을 입력하세요.">
						<button type="button" id="wrtRepBtn" class="relpyBtn">등록</button>
						<button type="button" id="closeRepBtn" class="relpyBtn">닫기</button>
					</div>
                  </tr>
                  <tr>
                      <td class="postComment" colspan="11"> </td>
                  </tr>
	        </table>
    	</div><!-- postMainBox -->
    </div><!-- container -->

    <%@include file="./include/footer.jsp"%>
    
   	<!-- 댓글 ajax -->
   	<script>
   		let jobs_post_no = ${jobsboardDTO.jobs_post_no};
   		
	   	//1.댓글 목록을 보려주는 함수
		let showList = function(jobs_post_no){
			$.ajax({
	            type:'GET', // 요청 메서드
	            url: '/biz/jobscomments?jobs_post_no='+jobs_post_no, // 요청 URI
	            //headers : { "content-type": "application/json"}, //요청헤더 
	            //dataType : 'json',  // 전송받을 데이터의 타입
	            //data : JSON.stringify(person),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	            success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                //person2 = JSON.parse(result);    
	                //alert("received="+result);  // result = 서버가 전송한 데이터     
	                $(".postComment").html(toHtml(result)); // 전송받은 데이터 입력 //toHtml() : 곧 만들 함수 
	            },
	            error   : function(){ alert("error") } 
	        }) // $.ajax()
		}//showList
		
		//2.결과를 화면에 출력하는 함수
		let toHtml = function(comments){
			let tmp = "<ul>";
			
			comments.forEach(function(comments){
				tmp += '<li data-jobs_comment_no=' + comments.jobs_comment_no
				tmp += ' data-jobs_comment_pcno=' + comments.jobs_comment_pcno
				tmp += ' data-jobs_post_no=' + comments.jobs_post_no + '>'
				tmp += ' <div>'
				if(comments.jobs_comment_no != comments.jobs_comment_pcno){
					tmp += '<i>ㄴ</i>'
				}
				tmp += '  <span class="jobs_comment_writer">' + comments.jobs_comment_writer + '</span>'
				tmp += '  <span class="jobs_comment_reg_date">' + dateToString(comments.jobs_comment_up_date) + '</span>'
				tmp += ' </div>'
				if(comments.jobs_comment_no != comments.jobs_comment_pcno){
					tmp += '<div class="commentContent" id="replyCommentContent">' + comments.jobs_comment_content + '</div>'
				} else if(comments.jobs_comment_no == comments.jobs_comment_pcno){
					tmp += ' <div class="commentContent">' + comments.jobs_comment_content + '</div>'	
				}
				if(comments.jobs_comment_no != comments.jobs_comment_pcno){
					tmp += ' <button class="modBtn" id="commentBtn">수정</button>'
					tmp += ' <button class="delBtn" id="commentBtn">삭제</button>'
				} else if(comments.jobs_comment_no == comments.jobs_comment_pcno){
					tmp += ' <button class="modBtn" id="commentBtn">수정</button>'
					tmp += ' <button class="delBtn" id="commentBtn">삭제</button>'
					tmp += ' <button class="replyBtn" id="commentBtn">답글</button>'
				}
				

				tmp += '</li>'
			})
			
			return tmp + "</ul>"
		}//toHtml
		
		//3.날짜형식의 숫자가 반드시 두자리로 표현되도록 하는 함수
		let addZero = function(value=1){
			return value > 9 ? value : "0"+value;
		}//addZero
		
		//4.시간 커스텀 밀리초->표준시간양식으로 변경하주는 함수
		// ms=0 매개변수가 혹시나 없으면 기본값을 넣어준다는 의미 자바스크립트 6에서부터 나옴
		let dateToString = function(ms=0){
			let date = new Date(ms);
			let yyyy = date.getFullYear();
			let mm = addZero(date.getMonth()+1);// 0부터 시작하니 +1해줘야함
			let dd = addZero(date.getDate());
			
			let HH = addZero(date.getHours());
			let MM = addZero(date.getMinutes());
			let ss = addZero(date.getSeconds());
			
			return yyyy +  "." + mm + "." + dd + " " + HH + ":" + MM + ":" + ss;
		}//dateToString
		
		//버튼ajax
		$(document).ready(function(){
			
			//최초에 댓글목록을 보여주기위한 함수
			showList(jobs_post_no);
			
			//sendBtn누르면 함수실행하는 함수
			$("#sendBtn").click(function(){
				//val() : 값을 가져온다라는 뜻
				let jobs_comment_content = $("textarea[name=comments]").val();
				
				if(jobs_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("textarea[name=comments]").focus();
					return;
				}
				
				$.ajax({
	                type:'POST', // 요청 메서드
	                url: '/biz/jobscomments?jobs_post_no='+jobs_post_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({jobs_post_no: jobs_post_no, jobs_comment_content: jobs_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글이 등록되었습니다.");
	                	$("textarea[name=comments]").val("");
	                 	//목록을 보여는 함수
	                   	showList(jobs_post_no);
	                    
	                },
	                error   : function(){ alert("댓글 등록에 실패했습니다.") } 
	            }); // $.ajax()
			})//sendBtn
			
			//.modBtn누르면 함수실행하는 함수
			$(".postComment").on("click", ".modBtn", function(){
				
				// bno는 showList에서 하드코딩으로 만들어 놨지만 원래는 이방식으로 가져와야한다.
				let jobs_comment_no = $(this).parent().attr("data-jobs_comment_no");
				let jobs_post_no = $(this).parent().attr("data-jobs_post_no");
				
				//댓글입력버튼 없앰
				$("#sendBtn").css("display", "none");
				
				//댓글수정버튼 띄움
				$("#modBtn").css("display", "block");
				
				
				
				//1.내가 선택한 것의 부모의 span.comments를 가져옴
				let jobs_comment_content = $("div.commentContent", $(this).parent()).text();
				//2.comments 내용을 input에 적어주기
				$("textarea[name=comments]").val(jobs_comment_content);
				//3.cno 전달하기
				$("#modBtn").attr("data-jobs_comment_no", jobs_comment_no)
				
			})
		
			//#modBtn 실제 수정
			$("#modBtn").click(function(){
				//val() : 값을 가져온다라는 뜻
				let jobs_comment_content = $("textarea[name=comments]").val();
				let jobs_comment_no = $(this).attr("data-jobs_comment_no");
				
				if(jobs_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("textarea[name=comments]").focus();
					return;
				}
				
				$.ajax({
	                type:'PATCH', // 요청 메서드
	                url: '/biz/jobscomments/'+jobs_comment_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({jobs_comment_no: jobs_comment_no, jobs_comment_content: jobs_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글이 수정되었습니다.");
	                	$("textarea[name=comments]").val("");
	                 	//목록을 보여는 함수
	                   	showList(jobs_post_no);
	                },
	                error   : function(){ alert("댓글 수정에 실패했습니다.") } 
	            }); // $.ajax()
	            
				//댓글입력버튼 띄움
				$("#sendBtn").css("display", "block");
				
				//댓글수정버튼 없앰
				$("#modBtn").css("display", "none");
			})//modBtn
			
			//.delBtn누르면 함수실행하는 함수 
			//commentsList를 기준으로걸어야하는 이유 :
			$(".postComment").on("click", ".delBtn", function(){
				// bno는 showList에서 하드코딩으로 만들어 놨지만 원래는 이방식으로 가져와야한다.
				let jobs_comment_no = $(this).parent().attr("data-jobs_comment_no");
				let jobs_post_no = $(this).parent().attr("data-jobs_post_no");
				let jobs_comment_pcno = $(this).children().attr("data-jobs_comment_pcno");
				
				$.ajax({
	                type:'DELETE', // 요청 메서드
	                url: '/biz/jobscomments/'+jobs_comment_no+'?jobs_post_no='+jobs_post_no, // 요청 URI
	                
	                success : function(result){
	                   alert("댓글을 삭제했습니다.");
	                   
	                 	//목록을 보여는 함수
	                   showList(jobs_post_no);
	                    
	                },
	                error   : function(){ alert("댓글 삭제에 실패했습니다.") } 
	            }) // $.ajax()
			})
			

			//답글
			//.replyBtn 누르면 답글창 띄움
			$(".postComment").on("click", ".replyBtn", function(){
				//replyForm옮기기
				//.appendTo() : 선택한 요소의 마지막에 붙여줌
				$("#replyForm").appendTo($(this).parent());
				
				//댓글을 입력할 창을 표시
				$("#replyForm").css("display", "block");
			})
			
			//#closeRepBtn 누르면 답글창 닫음
			$(".postComment").on("click", "#closeRepBtn", function(){
				//답글을 입력할 창을 닫기
				$("#replyForm").css("display", "none");
			})
			
			//#wrtRepBtn 누르면 실행하는 함수
			$("#wrtRepBtn").click(function(){
				//val() : 값을 가져온다라는 뜻
				let jobs_comment_content = $("input[name=replyComments]").val();
				let jobs_comment_pcno = $("#replyForm").parent().attr("data-jobs_comment_pcno");
				
				if(jobs_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("input[name=replyComments]").focus();
					return;
				}
				
				$.ajax({
	                type:'POST', // 요청 메서드
	                url: '/biz/jobscomments?jobs_post_no='+jobs_post_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({jobs_comment_pcno: jobs_comment_pcno, jobs_post_no: jobs_post_no, jobs_comment_content: jobs_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글을 등록했습니다.");
	                   	$("input[name=replyComments]").val("");
	                 	//목록을 보여는 함수
	                   	showList(jobs_post_no);
	                    
	                },
	                error   : function(){ alert("댓글 등록에 실패했습니다.") } 
	            }); // $.ajax()
	            
	            $("#replyForm").css("display", "none");
	            $("input[name=replyComments]").val('');
	            $("#replyForm").appendTo("body");
			})
			
		})
   	
   	</script>
    
  	<!-- 게시물 기능 js -->
    <script>
		//게시글 목록페이지 이동
		$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
	   		$("#listBtn").on("click", function(){
	   			location.href="<c:url value='/jobs/list?page=${page}&pageSize=${pageSize}'/>"
	   		})
	   	})
	   	
   	 	//게시글 수정페이지 이동
	   	$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
	   		$("#modifyBtn").on("click", function(){
	   					
	   			if(!confirm("게시물을 수정하시겠습니까?")) return;
	   			
   				let form = $("#form");
	   			form.attr("action", "<c:url value='/jobs/modifyy?page=${page}&pageSize=${pageSize}'/>");
				form.attr("method", "post");
	   			
	   			form.submit();
	   		})
	   	})
	   	//게시글 삭제
	   	$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
	   		$("#removeBtn").on("click", function(){
	   			
	   			//confirm = alert
	   			if(!confirm("게시물을 삭제하시겠습니까?")) return;
	   			
	   			//removeBtn click할 떄만 action이 생성되어서 post방식으로 전송하도록 만들어줌
	   			let form = $("#form");
	   			form.attr("action", "<c:url value='/jobs/remove?page=${page}&pageSize=${pageSize}&jobs_post_no=${jobs_post_no}'/>");
	   			form.attr("method", "post");
	   			
	   			form.submit();	
	   		})
	   	})
	   	
	   	
	   	
	   	//추천수갯수를 읽어오는 함수
		let showCnt = function(jobs_post_no){
			$.ajax({
	            type:'GET', // 요청 메서드
	            url: '/biz/jobs/jobsrecommend?jobs_post_no='+jobs_post_no, // 요청 URI
	            //headers : { "content-type": "application/json"}, //요청헤더 
	            //dataType : 'json',  // 전송받을 데이터의 타입
	            success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                //person2 = JSON.parse(result);    
	                //alert("received="+result);  // result = 서버가 전송한 데이터     
	                $(".likeNo").html(toHtml2(result)); // 전송받은 데이터 입력 //toHtml() : 곧 만들 함수
	            },
	            error   : function(){ alert("error") } 
	        }) // $.ajax()
		}//showList

		
		//2.결과를 화면에 출력하는 함수
		let toHtml2 = function(likeCnt){
			let tmp = " <div class='likeCount' name='jobs_recommend'>";
				tmp += "<span>" + likeCnt + "</span>" 
				tmp += " <input type='hidden' name='jobs_recommend' value='" + likeCnt + "'/>"
			return tmp + " </div>"
		}//toHtml
	   	
		
	 	
	   	$(document).ready(function(){
	   		showCnt(jobs_post_no);
	   		
	   		//추천수 증가
		   	let jobs_recommend = ${jobsboardDTO.jobs_recommend}
			
		   		$('#recommendBtn1').on("click", function(){
		   			$.ajax({
		                type:'PATCH', // 요청 메서드
		                url: '/biz/jobs/jobsincreRecommend/'+jobs_post_no, // 요청 URI 
		                headers : { "content-type": "application/json"}, //요청헤더
		                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
		                data : JSON.stringify({jobs_recommend: jobs_recommend, jobs_post_no: jobs_post_no}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
		                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
		                	showCnt(jobs_recommend+result)
		                },
		                error   : function(){ alert("error11") } 
		            }); // $.ajax()
		            		
		                	$("#recommendBtn2").css("display", "block");
		    				
		    				$("#recommendBtn1").css("display", "none");
		   		})//recommendBtn1

		   	
			//추천수 취소
	   		$('#recommendBtn2').on("click", function(){
	   			$.ajax({
	                type:'PATCH', // 요청 메서드
	                url: '/biz/jobs/jobsdecreRecommend/'+jobs_post_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({jobs_recommend: jobs_recommend, jobs_post_no: jobs_post_no}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                	
	                	showCnt(jobs_recommend)
	                },
	                error   : function(){ alert("error") } 
	            }); // $.ajax()
	            
				$("#recommendBtn1").css("display", "block");
				
				$("#recommendBtn2").css("display", "none");
	   			
	   		})//recommendBtn2
	   	})

	
		
	
		let msg = "${msg}";
	   	
	   	if(msg == "WRT_ERROR"){
			alert("게시글 등록에 실패하였습니다.")
		}
	   	
	   	if(msg == "MOD_ERROR"){
			alert("게시글 수정에 실패하였습니다.")
		}
	   	
	   	if(msg == "MOD_OK"){
			alert ("게시글이 수정되었습니다.");
		}
	   	
	   	
   	</script>      
</body>
</html>