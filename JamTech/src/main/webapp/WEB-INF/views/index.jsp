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
    
    <!-- 폰트링크 -->
    <link rel="preconnect" href="https://fonts.googleapis.com"><!--출처-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><!--출처-->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet"><!--실제로 사용되는것-->
    
    <!-- 로컬css -->
    <link rel="stylesheet" href="<c:url value='/include/css/header_footer.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='/member/css/style.css'/>" type="text/css">

    <!-- fontAsome -->
    <script src="https://kit.fontawesome.com/159aca3e6d.js" crossorigin="anonymous"></script>

    <!-- 슬릭css -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

    <!-- 스크립트순서 : 쿼리 -> 슬릭 -> 내코드 -->
    <!-- 제이쿼리js -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <!-- 슬릭js -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    <!-- 로그인 상태에 따라 링크 설정 -->
	<c:set var="loginOutLink2" value="${sessionScope.user_id==null ? '/login/login' : '/login/logout' }" />
	<!-- 화면에 표시되는 문자 설정 -->
	<c:set var="loginOut2" value="${sessionScope.user_id==null ? '로그인' : '로그아웃' }" />
	<%-- <c:set var="loginOutForm" value="${sessionScope.user_id==null ? 'BoforeLogin()' : 'AfterLogin()' }" /> --%>
    
      
</head>
<body>
	<%@include file="./include/header.jsp"%>
	
    <div id="mainContainer">
    
        <div id="mainConBox">

            <div class="mainContent">
                <div class="mainLeft">
                    <div class="mainLogin">
                        <h4>LOGIN</h4>
                        <form action="<c:url value='${loginOutLink2 }'/>" method="gat" class="mainLoginForm" id="frm" onsubmit="return formCheck(this);">
                        	${loginOutForm}
                        	tmp += '<button type="submit" class="mainLoginForm_loginBtn">' + ${loginOut2 } + '</button>'
                        </form>
                    </div><!-- mainLogin -->
    
                    <div class="mainPopularPost" id="pNewsList">
                        <h4>Popular News</h4>
                    </div><!-- mainNewPost -->
                    
                    <div class="mainTag">
                        <h4>TAG</h4>
                        <div class="mainTagList">
                            <a href="#">#i</a>
                            <a href="#">#android</a>
                            <a href="#">#backend</a>
                            <a href="#">#frontend</a>
                            <a href="#">#ios</a>
                            <a href="#">#kakao</a>
                            <a href="#">#facebook</a>
                            <a href="#">#javascript</a>
                            <a href="#">#machinelearning</a>
                            <a href="#">#ar</a>
                            <a href="#">#instagram</a>
                            <a href="#">#blockchain</a>
                            <a href="#">#game</a>
                            <a href="#">#vr</a>
                            <a href="#">#meta</a>
                            <a href="#">#kinexon</a>
                        </div>
                    </div><!-- mainTag -->
    
                    <div class="mainAd">
                        <h4>ISUE</h4> 
                        <a href="<c:url value='https://firebase.google.com/?hl=ko'/>" >
                        	<img src="<c:url value='/img/AdMain.png'/>" alt="이슈광고이미지">
                        </a>
                    </div><!-- mainAd -->
    
                </div><!-- mainLeft -->
        
                <div class="mainRight">
                    <div class="mainRightTop">
                        <div class="mainSlide">
                            <div><a href="#"><img src="<c:url value='/img/slide-1.jpg'/>" alt=""></a></div>
                            <div><a href="#"><img src="<c:url value='/img/slide-2.jpg'/>" alt=""></a></div>
                            <div><a href="#"><img src="<c:url value='/img/slide-3.jpg'/>" alt=""></a></div>
                            <div><a href="#"><img src="<c:url value='/img/slide-4.jpg'/>" alt=""></a></div> 
                        </div><!-- mainSlide -->
    
                        <div class="indicaotr">
                            <span class="prevArrow">
                            	<img src="<c:url value='/img/a_left.png'/>" alt="">
                            </span>
                            <span class="nextArrow">
                            	<img src="<c:url value='/img/a_right.png'/>" alt="">
                            </span>          
                        </div>
                    </div><!-- mainRightTop -->
            
                    <div class="mainNews" id="nNewsList">
                        <h2>NEW NEWS</h2>
                    </div><!-- mainNews -->
            
                    <div class="mainQA">
                        <h2>NEW QA</h2>
                        <div class="QAList" id="nQAList">
                            
                        </div>
                    
                    </div><!-- mainQA -->
            
                    <div class="mainJobs" id=nJobsList>
                        <h2>NEW JOBS</h2>
                        
                    </div><!-- mainJobs -->
            
                </div><!-- mainRight -->
            </div><!-- mainContent -->

        </div><!-- mainConBox -->
    
    </div><!-- mainContainer -->
    
	<%@include file="./include/footer.jsp"%>
	
	 <!-- 로컬js -->
     <script src="<c:url value='/member/js/script.js'/>"></script>
     <script src="<c:url value='/member/js/loginPage.js'/>"></script>
     
     
     <script>
     //ajax 로그인화면
     let BeforeLogin = function(){
   		 let tmp = '<ul>'
   		 tmp += '<li>'
   		 tmp += '<a href="/register/agree"> 회원가입 </a>'
   		 tmp += '</li>'
		 tmp += '<li>'
   		 tmp += '<a href="/findIdPw/findIdPw">아이디/비번찾기</a>'
   		 tmp += '</li>'
   		 tmp += '</ul>'
   		 tmp += '<i class="fa-solid fa-user"></i>'
   		 tmp += '<input type="text" class="mainLoginFormControl" id="userId" name="user_id" placeholder="아이디"><br>'
   		 tmp += '<i class="fa-solid fa-lock"></i>'
   		 tmp += '<input type="password" class="mainLoginFormControl" id="userPw" name="user_pw" placeholder="비밀번호"><br>'
   		 tmp += '<div class="mainAutoLogin">'
   		 tmp += '<input type="checkbox" class="autologin_chkBox" id="autologin" name=rememberId' + ${empty cookie.user_id.value ? "" : "checked" } + '>'
   		 tmp += '<label class="autologin_text" for="autologin">아이디 저장</label>'
 		 tmp += '</div>'
   		 return tmp + '<button type="submit" class="mainLoginForm_loginBtn">${loginOut2 }</button>'
 	 }//BeforeLogin
    		 
	  let AfterLogin = function(){
	 	  let tmp = '<div class="afterLogin">'
	 	  tmp += '환영합니다.  ${user_id}님' 
	 	  tmp += '</div>' 
		  return tmp + '<button type="submit" class="mainLoginForm_loginBtn">${loginOut2 }</button>'
	  }//AfterLogin		 
    
	  let showLogin = function(){
		  $("#frm").html(BeforeLogin());
	  }//showLogin
	  
	  let showLogin2 = function(){
		  $("#frm").html(AfterLogin());
	  }//showLogin2
     
     $(document).ready(function(){
    	 if(${sessionScope.user_id==null}){
    		 showLogin();  		 
    	 } else{
    		 showLogin2();
    	 }
     })
     
     
     //ajax index
     
     //1.popularNews 목록읽어오기
	  let popularNewsList = function(){
		  $.ajax({
              type:'GET', // 요청 메서드
              url: '/biz/news/popular', // 요청 URI 
              //headers : { "content-type": "application/json"}, //요청헤더
              //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
              //data : JSON.stringify({crew_comment_pcno: crew_comment_pcno, crew_post_no: crew_post_no, crew_comment_content: crew_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
              success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
            	  $("#pNewsList").append(popularNews(result));
                  
              },
              error   : function(){ alert("댓글 등록에 실패했습니다.") } 
          }); // $.ajax()
		  
	  }//popularNewsList
	  
	  //1-1.popularNews 결과를 화면에 보여주는 html
	  let popularNews = function(pNews){
	 	  let tmp = '<ul>';

	 	  pNews.forEach(function(pNews){
		 	  tmp += '<li>'		 	  
		 	  tmp += '<a href="/biz/news/read?news_post_no=' + pNews.news_post_no + '">' + pNews.news_title + '</a>' 
		 	  tmp += '</li>'
	 	  })
	 	  
		  return tmp + '</ul>'
	  }//popularNews	
	  
	  //1-2.화면에 출력 및 클릭시 해당 게시물로 이동
	  $(document).ready(function(){
		  popularNewsList()
      })

      
      
      //2.newNews 목록읽어오기
      let newNewsList = function(){
		  $.ajax({
              type:'GET', // 요청 메서드
              url: '/biz/news/new', // 요청 URI 
              //headers : { "content-type": "application/json"}, //요청헤더
              //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
              //data : JSON.stringify({crew_comment_pcno: crew_comment_pcno, crew_post_no: crew_post_no, crew_comment_content: crew_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
              success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
            	  $("#nNewsList").append(newNews(result));
                  
              },
              error   : function(){ alert("댓글 등록에 실패했습니다.") } 
          }); // $.ajax()
		  
	  }//newNewsList
	  
	  //2-1.newNews 결과를 화면에 보여주는 html
	  let newNews = function(nNews){
		 	  let tmp = '<table class="main_table">';
		 	  tmp += '<tr>'
	 		  nNews.forEach(function(nNews){
			 	  tmp += '<td class="main_table_photo">'
			 	  tmp += '<a href="/biz/news/read?news_post_no=' + nNews.news_post_no + '"><img src="/img/no_Img.gif"></a>'
			 	  tmp += '</td>'
		 	  }) 

		 	  tmp += '</tr>'
		 	  tmp += '<tr>'
	 		  nNews.forEach(function(nNews){
	 			  tmp += '<td>'
 			 	  tmp += '<a href="/biz/news/read?news_post_no=' + nNews.news_post_no + '">' + nNews.news_title + '<br>' + nNews.news_writer + '</a>' 
 			 	  tmp += '</td>'
		 	  })

		 	  tmp += '</tr>'
		 	  
			  return tmp + '</table>'
	  }//newNews
	  
	  //2-2.화면에 출력 및 클릭시 해당 게시물로 이동
	  $(document).ready(function(){
		  newNewsList()
      })
      
      
      //3.newJobs 목록읽어오기
      let newJobsList = function(){
		  $.ajax({
              type:'GET', // 요청 메서드
              url: '/biz/jobs/new', // 요청 URI 
              //headers : { "content-type": "application/json"}, //요청헤더
              //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
              //data : JSON.stringify({crew_comment_pcno: crew_comment_pcno, crew_post_no: crew_post_no, crew_comment_content: crew_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
              success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
            	  $("#nJobsList").append(newJobs(result));
                  
              },
              error   : function(){ alert("댓글 등록에 실패했습니다.") } 
          }); // $.ajax()
		  
	  }//newJobsList
	  
	  //3-1.newNews 결과를 화면에 보여주는 html
	  let newJobs = function(nJobs){
		 	  let tmp = '<table class="main_table">';
		 	  tmp += '<tr>'
	 		  nJobs.forEach(function(nJobs){
			 	  tmp += '<td class="main_table_photo">'
			 	  tmp += '<a href="/biz/jobs/read?jobs_post_no=' + nJobs.jobs_post_no + '"><img src="/img/no_Img.gif"></a>'
			 	  tmp += '</td>'
		 	  })
		 	  
		 	  tmp += '</tr>'
		 	  tmp += '<tr>'
	 		  nJobs.forEach(function(nJobs){
	 		 	  tmp += '<td>'
 			 	  tmp += '<a href="/biz/jobs/read?jobs_post_no=' + nJobs.jobs_post_no + '">' + nJobs.jobs_title + '<br>' + nJobs.jobs_writer + '</a>'
 			 	  tmp += '</td>'
		 	  })

		 	  tmp += '</tr>'
		 	  
			  return tmp + '</table>'
	  }//newJobs

	  //3-2.화면에 출력 및 클릭시 해당 게시물로 이동
	  $(document).ready(function(){
		  newJobsList()
      })

      //4.newQA 목록읽어오기
       let newQAList = function(){
		  $.ajax({
              type:'GET', // 요청 메서드
              url: '/biz/qa/new', // 요청 URI 
              //headers : { "content-type": "application/json"}, //요청헤더
              //dataType : 'json',  // 전송받을 데이터의 타입, 안쓰면 json이 기본임
              //data : JSON.stringify({crew_comment_pcno: crew_comment_pcno, crew_post_no: crew_post_no, crew_comment_content: crew_comment_content}),  // 서버로 전송할 데이터를 객체에서 텍스트로 전환
              success : function(result){ 	// ajax가 성공한 뒤 서버로부터 응답이 도착하면 호출될 함수
            	  $("#nQAList").html(newQA(result));
                  
              },
              error   : function(){ alert("댓글 등록에 실패했습니다.") } 
          }); // $.ajax()
		  
	  }//newQAList
	  
	  //4-1.newQA 결과를 화면에 보여주는 html
	  let newQA = function(nQA){
		 	  let tmp = '<ul>';
		 	  nQA.forEach(function(nQA){
			 	  tmp += '<li>'
			 	  tmp += '<a href="#">' + nQA.qa_title + '</a>'
			 	  tmp += '</li>'
		 	  })
		 	  	  tmp += '</ul>'
		 	  	  
	 	  		tmp += '<ul>'
 	  		  nQA.forEach(function(nQA){
			 	  tmp += '<li>'
			 	  tmp += '<a href="/biz/qa/read?qa_post_no=' + nQA.qa_post_no + '">' + nQA.qa_title + '</a>'
			 	  tmp += '</li>'
		 	  })
		 	  	  tmp += '</ul>'
		 	  	  
 	  		  tmp += '<ul>'
 	  		  nQA.forEach(function(nQA){
			 	  tmp += '<li>'
			 	  tmp += '<a href="/biz/qa/read?qa_post_no=' + nQA.qa_post_no + '">' + nQA.qa_title + '</a>'
			 	  tmp += '</li>'
		 	  })
		 	  	  
			  return tmp + '</ul>'
	  }//newQA

	  //4-2.화면에 출력 및 클릭시 해당 게시물로 이동
	  $(document).ready(function(){
		  newQAList()
      })
      
     </script>
</body>
</html>