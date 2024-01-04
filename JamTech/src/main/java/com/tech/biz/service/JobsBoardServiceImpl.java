package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.biz.dao.JobsBoardDAO;
import com.tech.biz.domain.JobsBoardDTO;
import com.tech.biz.domain.NewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Service
public class JobsBoardServiceImpl implements JobsBoardService {
	@Autowired
	JobsBoardDAO jobsboardDAO;
	
	//1게시글 목록
	@Override
	public List<JobsBoardDTO> getList() throws Exception {
		return jobsboardDAO.selectAll();
	}
	
	//2게시글 읽기
	@Override
	public JobsBoardDTO read(Integer jobs_post_no) throws Exception{
		JobsBoardDTO jobsboardDTO = jobsboardDAO.select(jobs_post_no);
		
		//7게시글 조회수 증가
		jobsboardDAO.increaseCnt(jobs_post_no);
		return  jobsboardDTO;
	}
	
	//3게시글 쓰기
	@Override
	public int write(JobsBoardDTO jobsboardDTO) throws Exception{
		return jobsboardDAO.insert(jobsboardDTO);
	}
	
	//4게시글 수정
	@Override
	public int modify(JobsBoardDTO jobsboardDTO) throws Exception{
		return jobsboardDAO.update(jobsboardDTO);
	}
	
	//5게시글 삭제
	@Override
	public int remove(Integer jobs_post_no, String jobs_writer) throws Exception {
	    return jobsboardDAO.delete(jobs_post_no, jobs_writer);
	}
	
	//6전체 게시글 개수
	@Override
	public int getCount() throws Exception {
        return jobsboardDAO.count();
    }
	
	
	//8게시글 추천수 증가
	@Override
	public int increaseRecommend(Integer jobs_post_no) throws Exception {
        return jobsboardDAO.increaseRecommend(jobs_post_no);
    }
	
	//8-1게시글 추천수 취소
	@Override
	public int decreaseRecommend(Integer jobs_post_no) throws Exception {
        return jobsboardDAO.decreaseRecommend(jobs_post_no);
    }
	
	//8-2게시글 추천수 개수
	@Override
	public int recommendCnt(Integer jobs_post_no) throws Exception {
        return jobsboardDAO.recommendCnt(jobs_post_no);
    }
	
	//9게시글 페이징
	@Override
	public List<JobsBoardDTO> getPage(Map map) throws Exception {
        return jobsboardDAO.selectPage(map);
    }
	
	//10게시글 검색
	@Override
	public List<JobsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception{
		return jobsboardDAO.searchSelectPage(sc);
	}
	
	//11게시글 검색 개수 확인
	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception{
		return jobsboardDAO.searchResultCnt(sc);
	}
	
	//12newJobs
	@Override
	public List<JobsBoardDTO> newJobs() throws Exception{
		return jobsboardDAO.newJobs();
	}
	
	
}	
