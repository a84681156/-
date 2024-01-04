package com.tech.biz.dao;

import java.util.List;

import com.tech.biz.domain.QACommentDTO;

public interface QACommentDAO {

	//1. select 댓글번호에 해당하는 댓글 보여주기
	QACommentDTO select(Integer qa_comment_no) throws Exception;

	//2. select 전체 댓글 개수
	int count(Integer qa_post_no) throws Exception;

	//3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
	int insert(QACommentDTO qacommentDTO) throws Exception;

	//4. update 번호에 해당하는 댓글의 내용변경
	int update(QACommentDTO qacommentDTO) throws Exception;

	//5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
	int delete(Integer qa_comment_no, String qa_comment_writer) throws Exception;

	//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
	List<QACommentDTO> selectAll(Integer qa_post_no) throws Exception;

	//7. 관리자 댓글 삭제
	int deleteForAdmin(Integer qa_comment_no) throws Exception;

	//8. 댓글 전체 삭제 
	int deleteAll(Integer qa_post_no);

}