package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.JobsBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Repository
public class JobsBoardDAOImpl implements JobsBoardDAO  {
	
	@Autowired
	SqlSession session;
	
	String namespace="com.tech.biz.dao.JobsBoardDAO.";
	
	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	@Override
	public List<JobsBoardDTO> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
	
	//2.게시글 읽어오기
	@Override
	public JobsBoardDTO select(Integer jobs_post_no) throws Exception{
		return session.selectOne(namespace + "select", jobs_post_no);	
	}
	
	//3.게시글쓰기
	@Override
	public int insert(JobsBoardDTO jobsboardDTO) throws Exception{
		return session.insert(namespace + "insert", jobsboardDTO);
	}
	
	//4.게시글수정
	@Override
	public int update(JobsBoardDTO jobsboardDTO) throws Exception{
		return session.update(namespace + "update", jobsboardDTO);
	}
	
	//5.게시글삭제
	@Override
	public int delete(Integer jobs_post_no, String jobs_writer) throws Exception{
		Map map = new HashMap();
        map.put("jobs_post_no", jobs_post_no);
        map.put("jobs_writer", jobs_writer);
		return session.delete(namespace + "delete", map);
	}
	
	//6.전체 게시글 개수
	@Override
	public int count() throws Exception{
		return session.selectOne(namespace + "count");
	}
	
	//7.게시글조회수 증가
	@Override
	public int increaseCnt(Integer jobs_post_no) throws Exception {
        return session.update(namespace + "increaseCnt", jobs_post_no);
    }
	
	//8.게시글추천수 증가
	@Override
	public int increaseRecommend(Integer jobs_post_no) throws Exception {
        return session.update(namespace + "increaseRecommend", jobs_post_no);
    }
	
	//8-1.게시글추천수 취소
	@Override
	public int decreaseRecommend(Integer jobs_post_no) throws Exception {
        return session.update(namespace + "decreaseRecommend", jobs_post_no);
    }
	
	//8-2.게기글추천수 개수
	@Override
	public int recommendCnt(Integer jobs_post_no) throws Exception {
        return session.selectOne(namespace + "recommendCnt", jobs_post_no);
    }
	
	//9.게시글페이징
	@Override
	public List<JobsBoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
	
	//10.게시글검색
	@Override
	public List<JobsBoardDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
	
	//11.게시글검색 개수 확인
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
	
	//12.newJobs
	@Override
	public List<JobsBoardDTO> newJobs() throws Exception {
        return session.selectList(namespace + "newJobs");
    }
	
}
