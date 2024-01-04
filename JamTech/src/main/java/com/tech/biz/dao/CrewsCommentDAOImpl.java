package com.tech.biz.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.CrewsCommentDTO;

@Repository
public class CrewsCommentDAOImpl implements CrewsCommentDAO {
	 @Autowired
	    SqlSession session;

	    String namespace="com.tech.biz.dao.CrewsCommentDAO.";
	    
	    //1. select 댓글번호에 해당하는 댓글 보여주기
		@Override
		public CrewsCommentDTO select(Integer crew_comment_no) throws Exception {
	        return session.selectOne(namespace + "select", crew_comment_no);
	    }

	    //2. select 전체 댓글 개수
		@Override
		public int count(Integer crew_post_no) throws Exception {
	        return session.selectOne(namespace + "count", crew_post_no);
	    }

	    //3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
		@Override
		public int insert(CrewsCommentDTO crewscommentDTO) throws Exception {
	        return session.insert(namespace + "insert", crewscommentDTO);
	    }

	    
	    //4. update 번호에 해당하는 댓글의 내용변경
		@Override
		public int update(CrewsCommentDTO crewscommentDTO) throws Exception {
	        return session.update(namespace + "update", crewscommentDTO);
	    }
	    
	    //5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
		@Override
		public int delete(Integer crew_comment_no, String crew_comment_writer) throws Exception {
	        Map map = new HashMap();
	        map.put("crew_comment_no", crew_comment_no);
	        map.put("crew_comment_writer", crew_comment_writer);
	        return session.delete(namespace + "delete", map);
	    }
		
		//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
		@Override
		public List<CrewsCommentDTO> selectAll(Integer crew_post_no) throws Exception {
	        return session.selectList(namespace + "selectAll", crew_post_no);
	    }

		//7. 관리자 댓글 삭제
		@Override
		public int deleteForAdmin(Integer crew_comment_no) throws Exception {
	        Map map = new HashMap();
	        map.put("crew_comment_no", crew_comment_no);
	        return session.delete(namespace + "deleteForAdmin", map);
	    }
		
		//7. 댓글 전체 삭제 
		@Override
		public int deleteAll(Integer crew_post_no) {
	        return session.delete(namespace + "deleteAll", crew_post_no);
	    }


}
