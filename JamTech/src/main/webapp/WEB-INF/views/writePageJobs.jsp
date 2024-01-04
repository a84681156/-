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
    <link rel="stylesheet" href="<c:url value='/member/css/writePageJobs.css'/>" >

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

            <h1>JOBS 글쓰기</h1>
            
            <form action="<c:url value='/jobs/write'/>" method="post" >
                <table>
                    <tr>
                        <td colspan="6">
                            <label><i class="fa-solid fa-bars"></i> 제목</label>
                            <input type="text" class="formControl" name="jobs_title" placeholder="제목을 입력하세요.">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <div><i class="fa-solid fa-handshake-simple"></i> 구인구직</div>
                            <input 
                            type="checkbox" 
                            id="guin"
                            name="jobs_employ"
                            value="구인"
                            onclick="checkOnlyOne1(this)"
                            >
                            <label for="guin">구인</label>
                            <input 
                            type="checkbox" 
                            id="gugic"
                            name="jobs_employ"
                            value="구직"
                            onclick="checkOnlyOne1(this)"
                            >
                            <label for="gugic">구직</label>
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-building-user"></i> 근무형태</div>
                            <input 
                            type="checkbox" 
                            id="long"
                            name="jobs_type"
                            value="정규직"
                            onclick="checkOnlyOne2(this)"
                            >
                            <label for="long">정규직</label>
                            <input 
                            type="checkbox" 
                            id="short"
                            name="jobs_type"
                            value="계약직"
                            onclick="checkOnlyOne2(this)"
                            >
                            <label for="short">계약직</label>
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-database"></i> 근무파트</div>
                            <input 
                            type="checkbox" 
                            id="fe"
                            name="jobs_part"
                            value="프론트엔드"
                            onclick="checkOnlyOne3(this)"
                            >
                            <label for="fe">프론트엔드</label>

                            <input 
                            type="checkbox" 
                            id="be"
                            name="jobs_part"
                            value="백엔드"
                            onclick="checkOnlyOne3(this)"
                            >
                            <label for="be">백엔드</label>

                            <input 
                            type="checkbox" 
                            id="both"
                            name="jobs_part"
                            value="ALL"
                            onclick="checkOnlyOne3(this)"
                            >
                            <label for="both">ALL</label>
                        </td>
                        <td align="center">
                           <div><i class="fa-solid fa-location-dot"></i> 근무지역</div>
                                <select name="jobs_local" id="local">
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
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-desktop"></i> 경력유무</div>
                            <input 
                            type="checkbox" 
                            id="junior"
                            name="jobs_career"
                            value="신입"
                            onclick="checkOnlyOne4(this)"
                            >
                            <label for="junior">신입</label>

                            <input 
                            type="checkbox" 
                            id="senior"
                            name="jobs_career"
                            value="경력"
                            onclick="checkOnlyOne4(this)"
                            >
                            <label for="senior">경력</label>

                            <input 
                            type="checkbox" 
                            id="idc"
                            name="jobs_career"
                            value="무관"
                            onclick="checkOnlyOne4(this)"
                            >
                            <label for="idc">무관</label>
                        </td>
                        <td align="center">
                            <div><i class="fa-solid fa-user-check"></i> 진행상황</div>
                            <input 
                            type="checkbox" 
                            id="jobsResult_yes"
                            name="jobs_progress"
                            value="완료"
                            onclick="checkOnlyOne5(this)"
                            >
                            <label for="jobsResult_yes">구인구직완료</label>
                            <input 
                            type="checkbox" 
                            id="jobsResult_no"
                            name="jobs_progress"
                            value="미완료"
                            onclick="checkOnlyOne5(this)"
                            >
                            <label for="jobsResult_no">구인구직미완료</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <label><i class="fa-solid fa-book"></i> 본문 내용</label>
                            <textarea class="contentForm" name="jobs_content" id="writeContent" cols="30" rows="10" placeholder="내용을 입력하세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6"> 
                            <label><i class="fa-solid fa-image"></i> 사진</label>
                            <input type="file" class="formControl" name="jobs_img" accept="image/*">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <label><i class="fa-solid fa-paperclip"></i> 첨부파일</label>
                            <input type="file" class="formControl" name="jobs_attach" multiple>
                        </td>
                    </tr>
                </table>

                <div class="writeBtnBox">
                    <a href="#"><input type="submit" class="writeBtn" value="확인"></a>
                    <a href="<c:url value='/jobs/list'/>" ><input type="button" class="writeBtn" value="취소"></a>
                </div><!-- writeBtnBox -->
            </form>
            
        </div><!-- writePageBox -->
    </div><!-- container -->

    <%@include file="./include/footer.jsp"%>

    <script src="<c:url value='/member/js/writePageJobs.js'/>" ></script>
</body>
</html>