package com.tech.biz.dao;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.NoticeBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface NoticeBoardDAO {

	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	List<NoticeBoardDTO> selectAll() throws Exception;

	//2.게시글 읽어오기
	NoticeBoardDTO select(Integer notice_post_no) throws Exception;

	//3.게시글쓰기
	int insert(NoticeBoardDTO noticeBoardDTO) throws Exception;

	//4.게시글수정
	int update(NoticeBoardDTO noticeBoardDTO) throws Exception;

	//5.게시글삭제
	int delete(Integer notice_post_no, String notice_writer) throws Exception;

	//6.전체 게시글 개수
	int count() throws Exception;

	//9.게시글페이징
	List<NoticeBoardDTO> selectPage(Map map) throws Exception;

	//10.게시글검색
	List<NoticeBoardDTO> searchSelectPage(SearchCondition sc) throws Exception;

	//11.게시글검색 개수 확인
	int searchResultCnt(SearchCondition sc) throws Exception;

}