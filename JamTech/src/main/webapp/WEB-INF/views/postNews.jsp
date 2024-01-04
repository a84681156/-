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
	                        <td class="postTitle" colspan="5">
	                            <label>제목</label>
	                            <p name="news_title">
	                            	<c:out value='${newsboardDTO.news_title }'/>
	                            	<input type="hidden" name="news_title" value="${newsboardDTO.news_title }">
	                            </p>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<td class="postInfo">
	                            <label>글번호</label>
	                            <p name="news_post_no">
	                            	<c:out value='${newsboardDTO.news_post_no}'/>
	                            	<input type="hidden" name="news_post_no" value="${newsboardDTO.news_post_no }">
	                            </p>
	                        </td>
	                        <td class="postInfo">
	                            <label>작성자</label>
	                            <p name="news_writer">
	                            	<c:out value='${newsboardDTO.news_writer}'/>
	                            	<input type="hidden" name="news_writer" value="${newsboardDTO.news_writer }">
	                            </p>
	                        </td>
	                        <td class="postInfo">
	                            <label>조회수</label>
	                            <p name="news_cnt">
	                            	<c:out value='${newsboardDTO.news_cnt}'/>
	                            	<input type="hidden" name="news_cnt" value="${newsboardDTO.news_cnt }">
	                            </p>
	                        </td>
	                         <td class="postInfo">
	                            <label>작성일</label>
	                            <p name="news_reg_date">
		                            <c:choose>
							            <c:when test="${newsboardDTO.news_reg_date.time >= startOfToday}">
							              		<fmt:formatDate value="${newsboardDTO.news_reg_date}" pattern="HH:mm" type="time"/>
							            </c:when>
							            <c:otherwise>
							              		<fmt:formatDate value="${newsboardDTO.news_reg_date}" pattern="yyyy-MM-dd" type="date"/>
							            </c:otherwise>
						            </c:choose>
						            <input type="hidden" name="news_reg_date" value="${newsboardDTO.news_reg_date }">
								</p>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td class="postContent" colspan="5">
	                            <div class="postContentImg">
	                                <img src="<c:url value='/img/no_Img.gif'/>" alt="" >
	                            </div>
	                            <div class="contentText" name="news_content">
	                                <c:out value='${newsboardDTO.news_content }'/>
	                                <input type="hidden" name="news_content" value="${newsboardDTO.news_content }">
	                            </div>
	                        </td>
	                    </tr>
                    	<tr>
	                        <td class="postRecomm_List" colspan="5">
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
                    <td class="postCommentWrite" colspan="5">
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
                      <td class="postComment" colspan="5"> </td>
                  </tr>
	        </table>
    	</div><!-- postMainBox -->
    </div><!-- container -->

    <%@include file="./include/footer.jsp"%>
    
       	<script>
   		let news_post_no = ${newsboardDTO.news_post_no};
   		
	   	//1.댓글 목록을 보려주는 함수
		let showList = function(news_post_no){
			$.ajax({
	            type:'GET', // 요청 메서드
	            url: '/biz/newscomments?news_post_no='+news_post_no, // 요청 URI
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
				tmp += '<li data-news_comment_no=' + comments.news_comment_no
				tmp += ' data-news_comment_pcno=' + comments.news_comment_pcno
				tmp += ' data-news_post_no=' + comments.news_post_no + '>'
				tmp += ' <div>'
				if(comments.news_comment_no != comments.news_comment_pcno){
					tmp += '<i>ㄴ</i>'
				}
				tmp += '  <span class="news_comment_writer">' + comments.news_comment_writer + '</span>'
				tmp += '  <span class="news_comment_reg_date">' + dateToString(comments.news_comment_up_date) + '</span>'
				tmp += ' </div>'
				if(comments.news_comment_no != comments.news_comment_pcno){
					tmp += '<div class="commentContent" id="replyCommentContent">' + comments.news_comment_content + '</div>'
				} else if(comments.news_comment_no == comments.news_comment_pcno){
					tmp += ' <div class="commentContent">' + comments.news_comment_content + '</div>'	
				}
				if(comments.news_comment_no != comments.news_comment_pcno){
					tmp += ' <button class="modBtn" id="commentBtn">수정</button>'
					tmp += ' <button class="delBtn" id="commentBtn">삭제</button>'
				} else if(comments.news_comment_no == comments.news_comment_pcno){
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
			showList(news_post_no);
			
			//sendBtn누르면 함수실행하는 함수
			$("#sendBtn").click(function(){
				//val() : 값을 가져온다라는 뜻
				let news_comment_content = $("textarea[name=comments]").val();
				
				if(news_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("textarea[name=comments]").focus();
					return;
				}
				
				$.ajax({
	                type:'POST', // 요청 메서드
	                url: '/biz/newscomments?news_post_no='+news_post_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({news_post_no: news_post_no, news_comment_content: news_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글이 등록되었습니다.");
	                   
	                 	//목록을 보여는 함수
	                   	showList(news_post_no);
	                    
	                },
	                error   : function(){ alert("댓글 등록에 실패했습니다.") } 
	            }); // $.ajax()
			})//sendBtn
			
			//.modBtn누르면 함수실행하는 함수
			$(".postComment").on("click", ".modBtn", function(){
				
				// bno는 showList에서 하드코딩으로 만들어 놨지만 원래는 이방식으로 가져와야한다.
				let news_comment_no = $(this).parent().attr("data-news_comment_no");
				let news_post_no = $(this).parent().attr("data-news_post_no");
				
				//댓글입력버튼 없앰
				$("#sendBtn").css("display", "none");
				
				//댓글수정버튼 띄움
				$("#modBtn").css("display", "block");
				
				
				
				//1.내가 선택한 것의 부모의 span.comments를 가져옴
				let news_comment_content = $("div.commentContent", $(this).parent()).text();
				//2.comments 내용을 input에 적어주기
				$("textarea[name=comments]").val(news_comment_content);
				//3.cno 전달하기
				$("#modBtn").attr("data-news_comment_no", news_comment_no)
				
			})
		
			//#modBtn 실제 수정
			$("#modBtn").click(function(){
				//val() : 값을 가져온다라는 뜻
				let news_comment_content = $("textarea[name=comments]").val();
				let news_comment_no = $(this).attr("data-news_comment_no");
				
				if(news_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("textarea[name=comments]").focus();
					return;
				}
				
				$.ajax({
	                type:'PATCH', // 요청 메서드
	                url: '/biz/newscomments/'+news_comment_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({news_comment_no: news_comment_no, news_comment_content: news_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글이 수정되었습니다.");
	                
	                 	//목록을 보여는 함수
	                   	showList(news_post_no);
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
				let news_comment_no = $(this).parent().attr("data-news_comment_no");
				let news_post_no = $(this).parent().attr("data-news_post_no");
				let news_comment_pcno = $(this).children().attr("data-news_comment_pcno");
				
				$.ajax({
	                type:'DELETE', // 요청 메서드
	                url: '/biz/newscomments/'+news_comment_no+'?news_post_no='+news_post_no, // 요청 URI
	                
	                success : function(result){
	                   alert("댓글을 삭제했습니다.");
	                   
	                 	//목록을 보여는 함수
	                   showList(news_post_no);
	                    
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
				let news_comment_content = $("input[name=replyComments]").val();
				let news_comment_pcno = $("#replyForm").parent().attr("data-news_comment_pcno");
				
				if(news_comment_content.trim() == ''){
					alert("댓글을 입력하세요");
					$("input[name=replyComments]").focus();
					return;
				}
				
				$.ajax({
	                type:'POST', // 요청 메서드
	                url: '/biz/newscomments?news_post_no='+news_post_no, // 요청 URI 
	                headers : { "content-type": "application/json"}, //요청헤더
	                //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
	                data : JSON.stringify({news_comment_pcno: news_comment_pcno, news_post_no: news_post_no, news_comment_content: news_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
	                success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
	                   	alert("댓글을 등록했습니다.");
	                   
	                 	//목록을 보여는 함수
	                   	showList(news_post_no);
	                    
	                },
	                error   : function(){ alert("댓글 등록에 실패했습니다.") } 
	            }); // $.ajax()
	            
	            $("#replyForm").css("display", "none");
	            $("input[name=replyComments]").val('');
	            $("#replyForm").appendTo("body");
			})
			
		})
   	
   	</script>
    
    <script>
		//게시글 목록페이지 이동
		$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
	   		$("#listBtn").on("click", function(){
	   			location.href="<c:url value='/news/list?page=${page}&pageSize=${pageSize}'/>"
	   		})
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