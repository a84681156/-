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
    <link rel="stylesheet" href="<c:url value='/member/css/writePageCrews.css'/>" >

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

            <h1>CREWS 글수정</h1>
            
            <form action="<c:url value='/crews/modify?crew_post_no=${crew_post_no}'/>" method="post" id="form" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td colspan="4">
                        	<input type="hidden" class="formControl" name="crew_post_no" value="${param.crew_post_no }">
                        	<input type="hidden" class="formControl" name="crew_reg_date" value="${param.crew_reg_date }">
                        	<input type="hidden" class="formControl" name="crew_cnt" value="${param.crew_cnt }">
                        	<input type="hidden" class="formControl" name="crew_recommend" value="${param.crew_recommend }">
       						<input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""> 
							<input type="hidden" id="fileNameDel" name="fileNameDel[]" value=""> 
                            <label><i class="fa-solid fa-bars"></i> 제목</label>
                            <input type="text" class="formControl" name="crew_title" value="${param.crew_title }" placeholder="제목을 입력하세요.">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <p>
                                <div><i class="fa-solid fa-location-dot"></i> 프로젝트 진행지역</div>
                                <select name="crew_local" id="local">
                                    <option value="미선택">--지역선택--</option>
                                    <option value="서울특별시">서울특별시</option>
                                    <option value="부산광역시">부산광역시</option>
                                    <option value="대전광역시">대전광역시</option>
                                    <option value="대구광역시">대구광역시</option>
                                    <option value="울산광역시">울산광역시</option>
                                    <option value="광주광역시">광주광역시</option>
                                    <option value="경기도">경기도</option>
                                    <option value="강원도">강원도</option>
                                    <option value="충청남도">충청남도</option>
                                    <option value="충청북도">충청북도</option>
                                    <option value="경상남도">경상남도</option>
                                    <option value="경상북도">경상북도</option>
                                    <option value="전라남도">전라남도</option>
                                    <option value="전라북도">전라북도</option>
                                    <option value="제주도">제주도</option>
                                </select>
                            </p> 
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-desktop"></i> 크루원 경력</div>
                            <select name="crew_career" id="local">
                                <option value="미선택">--연차선택--</option>
                                <option value="1 ~ 3년차">1 ~ 3년차</option>
                                <option value="4 ~ 6년차">4 ~ 6년차</option>
                                <option value="7 ~ 9년차">7 ~ 9년차</option>
                                <option value="10년차 이상">10년차 이상</option>
                            </select> 
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-calendar-check"></i> 프로젝트 진행기간</div>
                            <select name="crew_time" id="local">
                                <option value="미선택">--기간선택--</option>
                                <option value="1개월 미만">1개월 미만</option>
                                <option value="1 ~ 3개월">1 ~ 3개월</option>
                                <option value="4 ~ 6개월">4 ~ 6개월</option>
                                <option value="6개월 이상">6개월 이상</option>
                            </select> 
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-user-check"></i> 진행상황</div>
                            <input 
                            type="checkbox" 
                            id="crews_yes"
                            name="crew_progress"
                            value = "완료"
                            onclick="checkOnlyOne(this)"
                            >
                            <label for="crews_yes">크루모집완료</label>

                            <input 
                            type="checkbox" 
                            id="crews_no"
                            name="crew_progress"
                            value = "미완료"
                            onclick="checkOnlyOne(this)"
                            >
                            <label for="crews_no">크루모집미완료</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <label><i class="fa-solid fa-book"></i> 본문 내용</label>
                            <textarea class="contentForm" name="crew_content" id="writeContent" cols="30" rows="10" placeholder="내용을 입력하세요."><c:out value='${param.crew_content }'/></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4"> 
                            <label><i class="fa-solid fa-image"></i> 파일업로드</label>
                            <input type="file" class="formControl" name="file">
                        </td>
                    </tr>
                    <tr>
						<td id="fileIndex">
							<c:forEach var="file" items="${file}" varStatus="var">
							<div>
								<input type="hidden" id="crew_file_no" name="crew_file_no_${var.index}" value="${file.CREW_FILE_NO }">
								<input type="hidden" id="crew_org_file_name" name="crew_org_file_name" value="crew_file_no_${var.index}">
								<a href="#" id="fileName" onclick="return false;">${file.CREW_ORG_FILE_NAME}</a>(${file.CREW_FILE_SIZE}kb)
								<button id="fileDel" onclick="fn_del('${file.CREW_FILE_NO}','crew_file_no_${var.index}');" type="button">삭제</button><br>
							</div>
							</c:forEach>
						</td>
					</tr>
                </table>

                <div class="writeBtnBox">
                    <a><input type="submit" class="writeBtn" id="modifyBtn" value="글수정"></a>
                    <a href="<c:url value='/crews/list'/>" ><input type="button" class="writeBtn" value="취소"></a>
                </div><!-- writeBtnBox -->
            </form>
            
        </div><!-- writePageBox -->
    </div><!-- container -->

    <%@include file="./include/footer.jsp"%>
    
     <script>
     	//파일추가
		function fn_addFile(){
			var fileIndex = 1;
			//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
			$(".fileAdd_btn").on("click", function(){
				$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
			});
			$(document).on("click","#fileDelBtn", function(){
				$(this).parent().remove();
		});
     
	   	let msg = "${msg}";
	   	
	   	if(msg == "MOD_ERROR"){
			alert("게시글 수정에 실패하였습니다.")
		}
	   	
	   	if(msg == "MOD_OK"){
			alert ("게시글이 수정되었습니다.");
		}
   </script>
   
   <script src="<c:url value='/member/js/writePageCrews.js'/>" ></script>
</body>
</html>