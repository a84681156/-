package com.tech.biz.dao;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface CrewsBoardDAO {

	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	List<CrewsBoardDTO> selectAll() throws Exception;

	//2.게시글 읽어오기
	CrewsBoardDTO select(Integer crew_post_no) throws Exception;

	//3.게시글쓰기
	int insert(CrewsBoardDTO crewboardDTO) throws Exception;
	
	//3-1.첨부파일 업로드
	void insertFile(Map<String, Object> map) throws Exception;

	//3-2.첨부파일조회
	List<Map<String, Object>> selectFileList(Integer crew_post_no) throws Exception;
	
	//3-3.첨부파일다운
	Map<String, Object> selectFileInfo(Integer crew_file_no) throws Exception;
	
	//3-4.첨부파일수정
	void updateFile(Map<String, Object> map) throws Exception;
	
	//4.게시글수정
	int update(CrewsBoardDTO crewboardDTO) throws Exception;
	

	//5.게시글삭제
	int delete(Integer crew_post_no, String crew_writer) throws Exception;

	//6.전체 게시글 개수
	int count() throws Exception;

	//7.게시글조회수 증가
	int increaseCnt(Integer crew_post_no) throws Exception;

	//8.게시글추천수 증가
	int increaseRecommend(Integer crew_post_no) throws Exception;
	
	//8-1.게시글추천수 취소
	int decreaseRecommend(Integer crew_post_no) throws Exception;
	
	//8-2.게시글추천수 개수
	int recommendCnt(Integer crew_post_no) throws Exception;

	//9.게시글페이징
	List<CrewsBoardDTO> selectPage(Map map) throws Exception;

	//10.게시글검색
	List<CrewsBoardDTO> searchSelectPage(SearchCondition sc) throws Exception;

	//11.게시글검색 개수 확인
	int searchResultCnt(SearchCondition sc) throws Exception;







}