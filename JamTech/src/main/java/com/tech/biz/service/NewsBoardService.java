package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.NewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface NewsBoardService {

	//1게시글 목록
	List<NewsBoardDTO> getList() throws Exception;
	
	//2게시글 읽기
	NewsBoardDTO read(Integer news_post_no) throws Exception;
	
	//3게시글 쓰기
	int write(NewsBoardDTO newsboardDTO) throws Exception;
	
	//4게시글 수정
	int modify(NewsBoardDTO newsboardDTO) throws Exception;
	
	//5게시글 삭제
	int remove(Integer news_post_no, String news_writer) throws Exception;
	
	//6전체 게시글 개수
	int getCount() throws Exception;
	
	//8게시글 추천수 증가
	int increaseRecommend(Integer news_post_no) throws Exception;
	
	//9게시글 페이징
	List<NewsBoardDTO> getPage(Map map) throws Exception;
	
	//10게시글 검색
	List<NewsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;
	
	//11게시글 검색 개수 확인
	int getSearchResultCount(SearchCondition sc) throws Exception;
	
	//index화면
	//popularNews
	List<NewsBoardDTO> popularNews() throws Exception;
	
	//newNews
	List<NewsBoardDTO> newNews() throws Exception;

}