package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface CrewsBoardService {

	//1게시글 목록
	List<CrewsBoardDTO> getList() throws Exception;

	//2게시글 읽기
	CrewsBoardDTO read(Integer crew_post_no) throws Exception;

	//3게시글 쓰기, 3-1첨부파일업로드
	void write(CrewsBoardDTO crewboardDTO, MultipartHttpServletRequest mpRequest) throws Exception;
	
	//3-2첨부파일조회
	List<Map<String, Object>> selectFileList(Integer crew_post_no) throws Exception;
	
	//3-3.첨부파일다운
	Map<String, Object> selectFileInfo(Integer crew_file_no) throws Exception;

	//4게시글 수정
	void modify(CrewsBoardDTO crewboardDTO, MultipartHttpServletRequest mpRequest, String[] files, String[] fileNames)
			throws Exception;

	//5게시글 삭제
	int remove(Integer crew_post_no, String crew_writer) throws Exception;

	//6전체 게시글 개수
	int getCount() throws Exception;

	//8게시글 추천수 증가
	int increaseRecommend(Integer crew_post_no) throws Exception;

	//8-1게시글 추천수 취소
	int decreaseRecommend(Integer crew_post_no) throws Exception;
	
	//8-2게시글 추천수 개수
	int recommendCnt(Integer crew_post_no) throws Exception;

	//9게시글 페이징
	List<CrewsBoardDTO> getPage(Map map) throws Exception;

	//10게시글 검색
	List<CrewsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;

	//11게시글 검색 개수 확인
	int getSearchResultCount(SearchCondition sc) throws Exception;




}