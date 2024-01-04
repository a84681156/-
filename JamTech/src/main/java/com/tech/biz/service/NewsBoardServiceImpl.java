package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.biz.dao.NewsBoardDAO;
import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.NewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Service
public class NewsBoardServiceImpl implements NewsBoardService {
	@Autowired
	NewsBoardDAO newsboardDAO;
	
	//1게시글 목록
	@Override
	public List<NewsBoardDTO> getList() throws Exception {
		return newsboardDAO.selectAll();
	}
	
	//2게시글 읽기
	@Override
	public NewsBoardDTO read(Integer news_post_no) throws Exception{
		NewsBoardDTO newsboardDTO = newsboardDAO.select(news_post_no);
		
		//7게시글 조회수 증가
		newsboardDAO.increaseCnt(news_post_no);
		return  newsboardDTO;
	}
	
	//3게시글 쓰기
	@Override
	public int write(NewsBoardDTO newsboardDTO) throws Exception{
		return newsboardDAO.insert(newsboardDTO);
	}
	
	//4게시글 수정
	@Override
	public int modify(NewsBoardDTO newsboardDTO) throws Exception{
		return newsboardDAO.update(newsboardDTO);
	}
	
	//5게시글 삭제
	@Override
	public int remove(Integer news_post_no, String news_writer) throws Exception {
	    return newsboardDAO.delete(news_post_no, news_writer);
	}
	
	//6전체 게시글 개수
	@Override
	public int getCount() throws Exception {
        return newsboardDAO.count();
    }
	
	
	//8게시글 추천수 증가
	@Override
	public int increaseRecommend(Integer news_post_no) throws Exception {
        return newsboardDAO.increaseRecommend(news_post_no);
    }
	
	//9게시글 페이징
	@Override
	public List<NewsBoardDTO> getPage(Map map) throws Exception {
        return newsboardDAO.selectPage(map);
    }
	
	//10게시글 검색
	@Override
	public List<NewsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception{
		return newsboardDAO.searchSelectPage(sc);
	}
	
	//11게시글 검색 개수 확인
	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception{
		return newsboardDAO.searchResultCnt(sc);
	}
	
	//index화면
	//popularNews
	@Override
	public List<NewsBoardDTO> popularNews() throws Exception{
		return newsboardDAO.popularNews();
	}
	
	//newNews
	@Override
	public List<NewsBoardDTO> newNews() throws Exception{
		return newsboardDAO.newNews();
	}
}	
