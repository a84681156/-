package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.NewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Repository
public class NewsBoardDAOImpl implements NewsBoardDAO {
	
	@Autowired
	SqlSession session;
	
	String namespace="com.tech.biz.dao.NewsBoardDAO.";
	
	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	@Override
	public List<NewsBoardDTO> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
	
	//2.게시글 읽어오기
	@Override
	public NewsBoardDTO select(Integer news_post_no) throws Exception{
		return session.selectOne(namespace + "select", news_post_no);	
	}
	
	//3.게시글쓰기
	@Override
	public int insert(NewsBoardDTO newsboardDTO) throws Exception{
		return session.insert(namespace + "insert", newsboardDTO);
	}
	
	//4.게시글수정
	@Override
	public int update(NewsBoardDTO newsboardDTO) throws Exception{
		return session.update(namespace + "update", newsboardDTO);
	}
	
	//5.게시글삭제
	@Override
	public int delete(Integer news_post_no, String news_writer) throws Exception{
		Map map = new HashMap();
        map.put("news_post_no", news_post_no);
        map.put("news_writer", news_writer);
		return session.delete(namespace + "delete", map);
	}
	
	//6.전체 게시글 개수
	@Override
	public int count() throws Exception{
		return session.selectOne(namespace + "count");
	}
	
	//7.게시글조회수 증가
	@Override
	public int increaseCnt(Integer news_post_no) throws Exception {
        return session.update(namespace + "increaseCnt", news_post_no);
    }
	
	//8.게시글추천수 증가
	@Override
	public int increaseRecommend(Integer news_post_no) throws Exception {
        return session.update(namespace + "increaseRecommend", news_post_no);
    }
	
	//9.게시글페이징
	@Override
	public List<NewsBoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
	//10.게시글검색
	@Override
	public List<NewsBoardDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
	
	//11.게시글검색 개수 확인
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
	
	//index화면
	//popularNews
	@Override
	public List<NewsBoardDTO> popularNews() throws Exception {
        return session.selectList(namespace + "popularNews");
    }
	
	//popularNews
	@Override
	public List<NewsBoardDTO> newNews() throws Exception {
        return session.selectList(namespace + "newNews");
    }
	
}
