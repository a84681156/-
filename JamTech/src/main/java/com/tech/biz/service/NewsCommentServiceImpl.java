package com.tech.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.biz.dao.NewsBoardDAO;
import com.tech.biz.dao.NewsCommentDAO;
import com.tech.biz.domain.NewsCommentDTO;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
	//의존성 주입
		//boardDao를 가져오는 이유 수업영상다시보기해서 정리
		@Autowired
		NewsBoardDAO newsboardDAO;
		
		@Autowired
		NewsCommentDAO newscommentDAO;
		
		//1.select 댓글번호에 해당하는 댓글 보여주기
		@Override
		public NewsCommentDTO read(Integer news_comment_no) throws Exception {
		    return newscommentDAO.select(news_comment_no);
		}
		
	    //2. select 전체 댓글 개수		
		@Override
		public int getCount(Integer news_post_no) throws Exception {
			return newscommentDAO.count(news_post_no);
		}
		
	    //3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
		@Override
		@Transactional(rollbackFor = Exception.class)
		public int write(NewsCommentDTO newscommentsDTO) throws Exception {
		    return newscommentDAO.insert(newscommentsDTO);
		}

		//4. update 번호에 해당하는 댓글의 내용변경
		@Override
		public int modify(NewsCommentDTO newscommentsDTO) throws Exception {
		    return newscommentDAO.update(newscommentsDTO);
		}
		
		//@Transactional : 트랜잭션작동되도록해주는것. cnt감소, 댓글 삭제를 모두 처리되었을 떄만 저장되도록 예외발생시 롤백이 되도록 처리
	    //5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
		@Override
		@Transactional(rollbackFor = Exception.class)
		public int remove(Integer news_comment_no, String news_comment_writer) throws Exception {
			return newscommentDAO.delete(news_comment_no, news_comment_writer); 
		}

		//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
		@Override
		public List<NewsCommentDTO> getList(Integer news_post_no) throws Exception {
		    return newscommentDAO.selectAll(news_post_no);
		}
		
		//7. 관리자 댓글 삭제
		@Override
		public int deleteForAdmin(Integer news_comment_no) throws Exception {
			return newscommentDAO.deleteForAdmin(news_comment_no);
		}
		//8. 댓글 전체 삭제 
		@Override
		public int deleteAll(Integer news_post_no) throws Exception {
			return newscommentDAO.deleteAll(news_post_no);
		}

}
