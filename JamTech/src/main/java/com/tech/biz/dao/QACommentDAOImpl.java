package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.QACommentDTO;

@Repository
public class QACommentDAOImpl implements QACommentDAO{
	 @Autowired
	    SqlSession session;

	    String namespace="com.tech.biz.dao.QACommentDAO.";
	    
	    //1. select 댓글번호에 해당하는 댓글 보여주기
		@Override
		public QACommentDTO select(Integer qa_comment_no) throws Exception {
	        return session.selectOne(namespace + "select", qa_comment_no);
	    }

	    //2. select 전체 댓글 개수
		@Override
		public int count(Integer qa_post_no) throws Exception {
	        return session.selectOne(namespace + "count", qa_post_no);
	    }

	    //3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
		@Override
		public int insert(QACommentDTO qacommentDTO) throws Exception {
	        return session.insert(namespace + "insert", qacommentDTO);
	    }

	    
	    //4. update 번호에 해당하는 댓글의 내용변경
		@Override
		public int update(QACommentDTO qacommentDTO) throws Exception {
	        return session.update(namespace + "update", qacommentDTO);
	    }
	    
	    //5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
		@Override
		public int delete(Integer qa_comment_no, String qa_comment_writer) throws Exception {
	        Map map = new HashMap();
	        map.put("qa_comment_no", qa_comment_no);
	        map.put("qa_comment_writer", qa_comment_writer);
	        return session.delete(namespace + "delete", map);
	    }
		
		//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
		@Override
		public List<QACommentDTO> selectAll(Integer qa_post_no) throws Exception {
	        return session.selectList(namespace + "selectAll", qa_post_no);
	    }

		//7. 관리자 댓글 삭제
		@Override
		public int deleteForAdmin(Integer qa_comment_no) throws Exception {
	        Map map = new HashMap();
	        map.put("qa_comment_no", qa_comment_no);
	        return session.delete(namespace + "deleteForAdmin", map);
	    }
		
		//8. 댓글 전체 삭제 
		@Override
		public int deleteAll(Integer qa_post_no) {
	        return session.delete(namespace + "deleteAll", qa_post_no);
	    }


}
