package com.tech.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.biz.dao.QABoardDAO;
import com.tech.biz.dao.QACommentDAO;
import com.tech.biz.domain.QACommentDTO;

@Service
public class QACommentServiceImpl implements QACommentService {
	//의존성 주입
		//boardDao를 가져오는 이유 수업영상다시보기해서 정리
		@Autowired
		QABoardDAO qaboardDAO;
		
		@Autowired
		QACommentDAO qacommentDAO;
		
		//1.select 댓글번호에 해당하는 댓글 보여주기
		@Override
		public QACommentDTO read(Integer qa_comment_no) throws Exception {
		    return qacommentDAO.select(qa_comment_no);
		}
		
	    //2. select 전체 댓글 개수		
		@Override
		public int getCount(Integer qa_post_no) throws Exception {
			return qacommentDAO.count(qa_post_no);
		}
		
	    //3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
		@Override
		@Transactional(rollbackFor = Exception.class)
		public int write(QACommentDTO qacommentsDTO) throws Exception {
		    return qacommentDAO.insert(qacommentsDTO);
		}

		//4. update 번호에 해당하는 댓글의 내용변경
		@Override
		public int modify(QACommentDTO qacommentsDTO) throws Exception {
		    return qacommentDAO.update(qacommentsDTO);
		}
		
		//@Transactional : 트랜잭션작동되도록해주는것. cnt감소, 댓글 삭제를 모두 처리되었을 떄만 저장되도록 예외발생시 롤백이 되도록 처리
	    //5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
		@Override
		@Transactional(rollbackFor = Exception.class)
		public int remove(Integer qa_comment_no, String qa_comment_writer) throws Exception {
			return qacommentDAO.delete(qa_comment_no, qa_comment_writer); 
		}

		//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
		@Override
		public List<QACommentDTO> getList(Integer qa_post_no) throws Exception {
		    return qacommentDAO.selectAll(qa_post_no);
		}
		
		//7. 관리자 댓글 삭제
		@Override
		public int deleteForAdmin(Integer qa_comment_no) throws Exception {
			return qacommentDAO.deleteForAdmin(qa_comment_no);
		}
		
		//8. 댓글 전체 삭제 
		@Override
		public int deleteAll(Integer qa_post_no) throws Exception {
			return qacommentDAO.deleteAll(qa_post_no);
		}

}
