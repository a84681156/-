package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.QABoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface QABoardService {

	//1게시글 목록
	List<QABoardDTO> getList() throws Exception;

	//2게시글 읽기
	QABoardDTO read(Integer qa_post_no) throws Exception;

	//3게시글 쓰기
	int write(QABoardDTO qaboardDTO) throws Exception;

	//4게시글 수정
	int modify(QABoardDTO qaboardDTO) throws Exception;

	//5게시글 삭제
	int remove(Integer qa_post_no, String qa_writer) throws Exception;

	//6전체 게시글 개수
	int getCount() throws Exception;

	//8게시글 추천수 증가
	int increaseRecommend(Integer qa_post_no) throws Exception;

	//9게시글 페이징
	List<QABoardDTO> getPage(Map map) throws Exception;

	//10게시글 검색
	List<QABoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;

	//11게시글 검색 개수 확인
	int getSearchResultCount(SearchCondition sc) throws Exception;

	//12.newQA읽어오기
	List<QABoardDTO> newQA() throws Exception;

}