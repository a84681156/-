package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.QABoardDTO;
import com.tech.biz.domain.SearchCondition;

@Repository
public class QABoardDAOImpl implements QABoardDAO {

	@Autowired
	SqlSession session;
	
	String namespace="com.tech.biz.dao.QABoardDAO.";
	
	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	@Override
	public List<QABoardDTO> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
	
	//2.게시글 읽어오기
	@Override
	public QABoardDTO select(Integer qa_post_no) throws Exception{
		return session.selectOne(namespace + "select", qa_post_no);	
	}
	
	//3.게시글쓰기
	@Override
	public int insert(QABoardDTO qaboardDTO) throws Exception{
		return session.insert(namespace + "insert", qaboardDTO);
	}
	
	//4.게시글수정
	@Override
	public int update(QABoardDTO qaboardDTO) throws Exception{
		return session.update(namespace + "update", qaboardDTO);
	}
	
	//5.게시글삭제
	@Override
	public int delete(Integer qa_post_no, String qa_writer) throws Exception{
		Map map = new HashMap();
        map.put("qa_post_no", qa_post_no);
        map.put("qa_writer", qa_writer);
		return session.delete(namespace + "delete", map);
	}
	
	//6.전체 게시글 개수
	@Override
	public int count() throws Exception{
		return session.selectOne(namespace + "count");
	}
	
	//7.게시글조회수 증가
	@Override
	public int increaseCnt(Integer qa_post_no) throws Exception {
        return session.update(namespace + "increaseCnt", qa_post_no);
    }
	
	//8.게시글추천수 증가
	@Override
	public int increaseRecommend(Integer qa_post_no) throws Exception {
        return session.update(namespace + "increaseRecommend", qa_post_no);
    }
	
	//9.게시글페이징
	@Override
	public List<QABoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
	
	//10.게시글검색
	@Override
	public List<QABoardDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
	
	//11.게시글검색 개수 확인
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
	
	//12.newQA읽어오기
	@Override
	public List<QABoardDTO> newQA() throws Exception {
        return session.selectList(namespace + "newQA");
    }
}
