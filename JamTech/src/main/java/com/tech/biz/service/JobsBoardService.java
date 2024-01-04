package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import com.tech.biz.domain.JobsBoardDTO;
import com.tech.biz.domain.SearchCondition;

public interface JobsBoardService {
	//1게시글 목록
	List<JobsBoardDTO> getList() throws Exception;
	
	//2게시글 읽기
	JobsBoardDTO read(Integer jobs_post_no) throws Exception;
	
	//3게시글 쓰기
	int write(JobsBoardDTO jobsboardDTO) throws Exception;
	
	//4게시글 수정
	int modify(JobsBoardDTO jobsboardDTO) throws Exception;
	
	//5게시글 삭제
	int remove(Integer jobs_post_no, String jobs_writer) throws Exception;
	
	//6전체 게시글 개수
	int getCount() throws Exception;
	
	//8게시글 추천수 증가
	int increaseRecommend(Integer jobs_post_no) throws Exception;
	
	//8-1게시글 추천수 취소
	int decreaseRecommend(Integer jobs_post_no) throws Exception;
	
	//8-2게시글 추천수 개수
	int recommendCnt(Integer jobs_post_no) throws Exception;
	
	//9게시글 페이징
	List<JobsBoardDTO> getPage(Map map) throws Exception;
	
	//10게시글 검색
	List<JobsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;
	
	//11게시글 검색 개수 확인
	int getSearchResultCount(SearchCondition sc) throws Exception;
	
	//12newJobs
	List<JobsBoardDTO> newJobs() throws Exception;



}