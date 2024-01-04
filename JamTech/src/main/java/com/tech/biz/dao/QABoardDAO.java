package com.tech.biz.dao;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.QABoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface QABoardDAO {

	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	List<QABoardDTO> selectAll() throws Exception;

	//2.게시글 읽어오기
	QABoardDTO select(Integer qa_post_no) throws Exception;

	//3.게시글쓰기
	int insert(QABoardDTO qaboardDTO) throws Exception;

	//4.게시글수정
	int update(QABoardDTO qaboardDTO) throws Exception;

	//5.게시글삭제
	int delete(Integer qa_post_no, String qa_writer) throws Exception;

	//6.전체 게시글 개수
	int count() throws Exception;

	//7.게시글조회수 증가
	int increaseCnt(Integer qa_post_no) throws Exception;

	//8.게시글추천수 증가
	int increaseRecommend(Integer qa_post_no) throws Exception;

	//9.게시글페이징
	List<QABoardDTO> selectPage(Map map) throws Exception;

	//10.게시글검색
	List<QABoardDTO> searchSelectPage(SearchCondition sc) throws Exception;

	//11.게시글검색 개수 확인
	int searchResultCnt(SearchCondition sc) throws Exception;
	
	//12.newQA읽어오기
	List<QABoardDTO> newQA() throws Exception;

}