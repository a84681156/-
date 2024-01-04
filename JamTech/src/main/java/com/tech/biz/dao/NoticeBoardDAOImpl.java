package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.NoticeBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.tech.biz.dao.NoticeBoardDAO.";
	
	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	@Override
	public List<NoticeBoardDTO> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
	
	//2.게시글 읽어오기
	@Override
	public NoticeBoardDTO select(Integer notice_post_no) throws Exception{
		return session.selectOne(namespace + "select", notice_post_no);	
	}
	
	//3.게시글쓰기
	@Override
	public int insert(NoticeBoardDTO noticeBoardDTO) throws Exception{
		return session.insert(namespace + "insert", noticeBoardDTO);
	}
	
	//4.게시글수정
	@Override
	public int update(NoticeBoardDTO noticeBoardDTO) throws Exception{
		return session.update(namespace + "update", noticeBoardDTO);
	}
	
	//5.게시글삭제
	@Override
	public int delete(Integer notice_post_no, String notice_writer) throws Exception{
		Map map = new HashMap();
        map.put("notice_post_no", notice_post_no);
        map.put("notice_writer", notice_writer);
		return session.delete(namespace + "delete", map);
	}
	
	//6.전체 게시글 개수
	@Override
	public int count() throws Exception{
		return session.selectOne(namespace + "count");
	}

	//9.게시글페이징
	@Override
	public List<NoticeBoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
	
	//10.게시글검색
	@Override
	public List<NoticeBoardDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
	
	//11.게시글검색 개수 확인
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
}
