package com.tech.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.NewsCommentDTO;

@Repository
public class NewsCommentDAOImpl implements NewsCommentDAO  {
	 @Autowired
	    SqlSession session;

	    String namespace="com.tech.biz.dao.NewsCommentDAO.";
	    
	    //1. select 댓글번호에 해당하는 댓글 보여주기
		@Override
		public NewsCommentDTO select(Integer news_comment_no) throws Exception {
	        return session.selectOne(namespace + "select", news_comment_no);
	    }

	    //2. select 전체 댓글 개수
		@Override
		public int count(Integer news_post_no) throws Exception {
	        return session.selectOne(namespace + "count", news_post_no);
	    }

	    //3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
		@Override
		public int insert(NewsCommentDTO newscommentDTO) throws Exception {
	        return session.insert(namespace + "insert", newscommentDTO);
	    }

	    
	    //4. update 번호에 해당하는 댓글의 내용변경
		@Override
		public int update(NewsCommentDTO newscommentDTO) throws Exception {
	        return session.update(namespace + "update", newscommentDTO);
	    }
	    
	    //5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
		@Override
		public int delete(Integer news_comment_no, String news_comment_writer) throws Exception {
	        Map map = new HashMap();
	        map.put("news_comment_no", news_comment_no);
	        map.put("news_comment_writer", news_comment_writer);
	        return session.delete(namespace + "delete", map);
	    }
		
		//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
		@Override
		public List<NewsCommentDTO> selectAll(Integer news_post_no) throws Exception {
	        return session.selectList(namespace + "selectAll", news_post_no);
	    }

		//7. 관리자 댓글 삭제
		@Override
		public int deleteForAdmin(Integer news_comment_no) throws Exception {
	        Map map = new HashMap();
	        map.put("news_comment_no", news_comment_no);
	        return session.delete(namespace + "deleteForAdmin", map);
	    }
		
		//8. 댓글 전체 삭제 
		@Override
		public int deleteAll(Integer news_post_no) {
	        return session.delete(namespace + "deleteAll", news_post_no);
	    }


}
