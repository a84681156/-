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
    <link rel="stylesheet" href="<c:url value='/member/css/writePageQA.css'/>" >

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

        <div class="writePageBox">

            <h1>QA 글수정</h1>
            
            <form action="" id="form">
                <table>
                    <tr>
                        <td colspan="5">
                        	<input type="hidden" class="formControl" name="qa_post_no" value="${param.qa_post_no }">
                        	<input type="hidden" class="formControl" name="qa_reg_date" value="${param.qa_reg_date }">
                        	<input type="hidden" class="formControl" name="qa_cnt" value="${param.qa_cnt }">
                        	<input type="hidden" class="formControl" name="qa_recommend" value="${param.qa_recommend }">
                            <label><i class="fa-solid fa-bars"></i> 제목</label>
                            <input type="text" class="formControl" name="qa_title" value="${param.crew_title }" placeholder="제목을 입력하세요.">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <p>
                                <div><i class="fa-solid fa-server"></i> 질문관련 대분야</div>
                                <select name="qa_big_sep" id="qa_big_sep">
                                    <option value="미선택">--분야선택--</option>
                                    <option value="Front">Front</option>
                                    <option value="Back">Back</option>
                                </select>
                            </p> 
                        </td>

                        <td align="center">
                            <p>
                                <div><i class="fa-solid fa-server"></i> 질문관련 소분야</div>
                                <select name="qa_small_sep" id="qa_small_sep">
                                    <option value="미선택">--분야선택--</option>
                                    <option value="Android">Android</option>
                                    <option value="IOS">IOS</option>
                                    <option value="DB">DB</option>
                                    <option value="AI">AI</option>
                                    <option value="FinTech">FinTech</option>
                                    <option value="BlockChain">BlockChain</option>
                                    <option value="Network">Network</option>
                                    <option value="Robot">Robot</option>
                                    <option value="Game">Game</option>
                                    <option value="BigData">BigData</option>
                                    <option value="SmartCar">SmartCar</option>
                                    <option value="IoT">IoT</option>
                                    <option value="Security">Security</option>
                                    <option value="Cloud">Cloud</option>
                                    <option value="ETC">ETC</option>
                                </select>
                            </p> 
                        </td>

                        <td align="center">
                            <p>
                                <div><i class="fa-solid fa-language"></i> 질문관련 언어</div>
                                <select name="qa_language" id="qa_language">
                                    <option value="미선택">--언어선택--</option>
                                    <option value="Java">Java</option>
                                    <option value="JavaScript">JavaScript</option>
                                    <option value="Python">Python</option>
                                    <option value="Ruby">Ruby</option>
                                    <option value="C">C</option>
                                    <option value="C++">C++</option>
                                    <option value="C#">C#</option>
                                    <option value="PHP">PHP</option>
                                    <option value="Shell">Shell</option>
                                    <option value="Go">Go</option>
                                    <option value="TypeScript">TypeScript</option>
                                    <option value="VisualBasic">VisualBasic</option>
                                    <option value="Assemblylanguage">Assemblylanguage</option>
                                    <option value="Oracle">Oracle</option>
                                    <option value="MySQL">MySQL</option>
                                    <option value="Perl">Perl</option>
                                    <option value="Cotlin">Cotlin</option> 
                                    <option value="Spring">Spring</option>
                                    <option value="JSP">JSP</option>
                                    <option value="MyBatis">MyBatis</option>
                                    <option value="HTML">HTML</option>
                                    <option value="CSS">CSS</option>
                                    <option value="ETC">ETC</option>
                                </select>
                            </p> 
                        </td>

                        <td align="center">
                            <p>
                                <div><i class="fa-solid fa-screwdriver-wrench"></i> 사용중인 IDE</div>
                                <select name="qa_ide" id="qa_ide">
                                    <option value="미선택">--IDE선택--</option>
                                    <option value="Eclipse">Eclipse</option>
                                    <option value="IntelliJ">IntelliJ</option>
                                    <option value="VisualStudioCode"> VisualStudioCode</option>
                                    <option value="Pycharm">Pycharm</option>
                                    <option value="Cloud9">Cloud9</option>
                                    <option value="Atom">Atom</option>
                                    <option value="Codeanywhere">Codeanywhere</option>
                                    <option value="DevC++">DevC++</option>
                                    <option value="CodeBlocks">CodeBlocks</option>
                                    <option value="STS">STS</option>
                                    <option value="Vim">Vim</option>
                                    <option value="Rider">Rider</option>
                                    <option value="Emacs">Emacs</option>
                                    <option value="Webstorm">Webstorm</option>
                                    <option value="AndroidStudio">AndroidStudio</option>
                                    <option value="SublimeText">SublimeText</option>
                                    <option value="Notepad++">Notepad++</option>
                                    <option value="ETC++">ETC</option>
                                </select>
                            </p> 
                        </td>

                        <td>
                            <div><i class="fa-solid fa-user-check"></i> 진행상황</div>
                            <input 
                            type="checkbox" 
                            id="qa_yes"
                            name="qa_progress"
                            value = "완료"
                            onclick="checkOnlyOne(this)"
                            >
                            <label for="qa_yes">QA해결 완료</label>

                            <input 
                            type="checkbox" 
                            id="qa_no"
                            name="qa_progress"
                            value = "미완료"
                            onclick="checkOnlyOne(this)"
                            >
                            <label for="qa_no">QA해결 미완료</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <label><i class="fa-solid fa-book"></i> 본문 내용</label>
                            <textarea class="contentForm" name="qa_content" id="writeContent" cols="30" rows="10" placeholder="내용을 입력하세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <label><i class="fa-solid fa-image"></i> 사진</label>
                            <input type="file" class="formControl" name="qa_img" accept="image/*">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <label><i class="fa-solid fa-paperclip"></i> 첨부파일</label>
                            <input type="file" class="formControl" name="qa_attach" multiple>
                        </td>
                    </tr>
                </table>

                <div class="writeBtnBox">
                    <a><input type="submit" class="writeBtn" id="modifyBtn" value="확인"></a>
                    <a href="<c:url value='/qa/list'/>" ><input type="button" class="writeBtn" value="취소"></a>
                </div><!-- writeBtnBox -->
            </form>
        </div><!-- writePageBox -->
    </div><!-- container -->

    <%@include file="./include/footer.jsp"%>
    
    <script>
  		//게시글 수정
    	$(document).ready(function(){//제이쿼리를 실행하기 위한 준비
    		$("#modifyBtn").on("click", function(){
    			
    			//게시글 수정 상태 -> 수정된 내용을 서버로 전송
    			let form = $("#form");
    			
    			form.attr("action", "<c:url value='/qa/modify?qa_post_no=${qa_post_no}'/>");
    			form.attr("method", "post");
    			
    			form.submit();	
    		})
    	})
     
     
	   	let msg = "${msg}";
	   	
	   	if(msg == "MOD_ERROR"){
			alert("게시글 수정에 실패하였습니다.")
		}
	   	
	   	if(msg == "MOD_OK"){
			alert ("게시글이 수정되었습니다.");
		}
   </script>

    <script src="<c:url value='/member/js/writePageQA.js'/>" ></script>
</body>
</html>