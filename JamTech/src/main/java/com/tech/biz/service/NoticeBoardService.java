package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.NoticeBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface NoticeBoardService {

	//1게시글 목록
	List<NoticeBoardDTO> getList() throws Exception;

	//2게시글 읽기
	NoticeBoardDTO read(Integer notice_post_no) throws Exception;

	//3게시글 쓰기
	int write(NoticeBoardDTO noticeboardDTO) throws Exception;

	//4게시글 수정
	int modify(NoticeBoardDTO noticeboardDTO) throws Exception;

	//5게시글 삭제
	int remove(Integer notice_post_no, String notice_writer) throws Exception;

	//6전체 게시글 개수
	int getCount() throws Exception;

	//9게시글 페이징
	List<NoticeBoardDTO> getPage(Map map) throws Exception;

	//10게시글 검색
	List<NoticeBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;

	//11게시글 검색 개수 확인
	int getSearchResultCount(SearchCondition sc) throws Exception;

}