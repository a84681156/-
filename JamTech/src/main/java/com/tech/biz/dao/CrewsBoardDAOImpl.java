package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.SearchCondition;

@Repository
public class CrewsBoardDAOImpl implements CrewsBoardDAO {
	
	@Autowired
	SqlSession session;
	
	String namespace="com.tech.biz.dao.CrewsBoardDAO.";
	
	//1.게시글 목록,등록일 기준 내림차순 번호기준 내림차순
	@Override
	public List<CrewsBoardDTO> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
	
	//2.게시글 읽어오기
	@Override
	public CrewsBoardDTO select(Integer crew_post_no) throws Exception{
		return session.selectOne(namespace + "select", crew_post_no);	
	}
	
	//3.게시글쓰기
	@Override
	public int insert(CrewsBoardDTO crewboardDTO) throws Exception{
		return session.insert(namespace + "insert", crewboardDTO);
	}
	
	//3-1.첨부파일 업로드
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		session.insert(namespace + "insertFile", map);
	}
	 
   	//3-2.첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(Integer crew_post_no) throws Exception {
		return session.selectList(namespace + "selectFileList", crew_post_no);
	}
	
	//3-3.첨부파일 다운
	@Override
	public Map<String, Object> selectFileInfo(Integer crew_file_no) throws Exception {
		return session.selectOne(namespace + "selectFileInfo", crew_file_no);
	}
	
	//3-4.첨부파일 수정
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		session.update(namespace + "updateFile", map);
	}
	
	//4.게시글수정
	@Override
	public int update(CrewsBoardDTO crewboardDTO) throws Exception{
		return session.update(namespace + "update", crewboardDTO);
	}
	
	//5.게시글삭제
	@Override
	public int delete(Integer crew_post_no, String crew_writer) throws Exception{
		Map map = new HashMap();
        map.put("crew_post_no", crew_post_no);
        map.put("crew_writer", crew_writer);
		return session.delete(namespace + "delete", map);
	}
	
	//6.전체 게시글 개수
	@Override
	public int count() throws Exception{
		return session.selectOne(namespace + "count");
	}
	
	//7.게시글조회수 증가
	@Override
	public int increaseCnt(Integer crew_post_no) throws Exception {
        return session.update(namespace + "increaseCnt", crew_post_no);
    }
	
	//8.게시글추천수 증가
	@Override
	public int increaseRecommend(Integer crew_post_no) throws Exception {
        return session.update(namespace + "increaseRecommend", crew_post_no);
    }
	
	//8-1.게시글추천수 취소
	@Override
	public int decreaseRecommend(Integer crew_post_no) throws Exception {
        return session.update(namespace + "decreaseRecommend", crew_post_no);
    }
	
	//8-2.게기글추천수 개수
	@Override
	public int recommendCnt(Integer crew_post_no) throws Exception {
        return session.selectOne(namespace + "recommendCnt", crew_post_no);
    }
	
	//9.게시글페이징
	@Override
	public List<CrewsBoardDTO> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
	//10.게시글검색
	@Override
	public List<CrewsBoardDTO> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
	
	//11.게시글검색 개수 확인
	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
	
}
