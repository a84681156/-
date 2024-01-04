package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.biz.dao.NoticeBoardDAO;
import com.tech.biz.domain.NoticeBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired
	NoticeBoardDAO noticeboardDAO;
	
	//1게시글 목록
	@Override
	public List<NoticeBoardDTO> getList() throws Exception {
		return noticeboardDAO.selectAll();
	}
	
	//2게시글 읽기
	@Override
	public NoticeBoardDTO read(Integer notice_post_no) throws Exception{
		NoticeBoardDTO noticeboardDTO = noticeboardDAO.select(notice_post_no);
		return noticeboardDTO;
	}
	
	//3게시글 쓰기
	@Override
	public int write(NoticeBoardDTO noticeboardDTO) throws Exception{
		return noticeboardDAO.insert(noticeboardDTO);
	}
	
	//4게시글 수정
	@Override
	public int modify(NoticeBoardDTO noticeboardDTO) throws Exception{
		return noticeboardDAO.update(noticeboardDTO);
	}
	
	//5게시글 삭제
	@Override
	public int remove(Integer notice_post_no, String notice_writer) throws Exception {
	    return noticeboardDAO.delete(notice_post_no, notice_writer);
	}
	
	//6전체 게시글 개수
	@Override
	public int getCount() throws Exception {
        return noticeboardDAO.count();
    }
	
	//9게시글 페이징
	@Override
	public List<NoticeBoardDTO> getPage(Map map) throws Exception {
        return noticeboardDAO.selectPage(map);
    }
	
	//10게시글 검색
	@Override
	public List<NoticeBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception{
		return noticeboardDAO.searchSelectPage(sc);
	}
	
	//11게시글 검색 개수 확인
	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception{
		return noticeboardDAO.searchResultCnt(sc);
	}
}	
