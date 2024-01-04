package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.biz.dao.QABoardDAO;
import com.tech.biz.domain.QABoardDTO;
import com.tech.biz.domain.SearchCondition;

@Service
public class QABoardServiceImpl implements QABoardService {
	@Autowired
	QABoardDAO qaboardDAO;
	
	//1게시글 목록
	@Override
	public List<QABoardDTO> getList() throws Exception {
		return qaboardDAO.selectAll();
	}
	
	//2게시글 읽기
	@Override
	public QABoardDTO read(Integer qa_post_no) throws Exception{
		QABoardDTO qaboardDTO = qaboardDAO.select(qa_post_no);
		
		//7게시글 조회수 증가
		qaboardDAO.increaseCnt(qa_post_no);
		return  qaboardDTO;
	}
	
	//3게시글 쓰기
	@Override
	public int write(QABoardDTO qaboardDTO) throws Exception{
		return qaboardDAO.insert(qaboardDTO);
	}
	
	//4게시글 수정
	@Override
	public int modify(QABoardDTO qaboardDTO) throws Exception{
		return qaboardDAO.update(qaboardDTO);
	}
	
	//5게시글 삭제
	@Override
	public int remove(Integer qa_post_no, String qa_writer) throws Exception {
	    return qaboardDAO.delete(qa_post_no, qa_writer);
	}
	
	//6전체 게시글 개수
	@Override
	public int getCount() throws Exception {
        return qaboardDAO.count();
    }
	
	
	//8게시글 추천수 증가
	@Override
	public int increaseRecommend(Integer qa_post_no) throws Exception {
        return qaboardDAO.increaseRecommend(qa_post_no);
    }
	
	//9게시글 페이징
	@Override
	public List<QABoardDTO> getPage(Map map) throws Exception {
        return qaboardDAO.selectPage(map);
    }
	
	//10게시글 검색
	@Override
	public List<QABoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception{
		return qaboardDAO.searchSelectPage(sc);
	}
	
	//11게시글 검색 개수 확인
	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception{
		return qaboardDAO.searchResultCnt(sc);
	}
	
	//10게시글 검색
	@Override
	public List<QABoardDTO> newQA() throws Exception{
		return qaboardDAO.newQA();
	}
}
