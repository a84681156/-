package com.tech.biz.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tech.biz.domain.CrewsCommentDTO;

public interface CrewsCommentService {

	//1.select 댓글번호에 해당하는 댓글 보여주기
	CrewsCommentDTO read(Integer crew_comment_no) throws Exception;

	//2. select 전체 댓글 개수		
	int getCount(Integer crew_post_no) throws Exception;

	//3. insert 댓글 추가 (게시글 번호 제목 내용 작성자)
	int write(CrewsCommentDTO crewscommentsDTO) throws Exception;

	//4. update 번호에 해당하는 댓글의 내용변경
	int modify(CrewsCommentDTO crewscommentsDTO) throws Exception;

	//@Transactional : 트랜잭션작동되도록해주는것. cnt감소, 댓글 삭제를 모두 처리되었을 떄만 저장되도록 예외발생시 롤백이 되도록 처리
	//5. delete 댓글 번호와 작성자가 일치할 때 게시글 삭제
	int remove(Integer crew_comment_no, String crew_comment_writer) throws Exception;

	//6. 댓글 목록, 등록일 기준으로 내림차순. 번호를 기준으로 내림차순
	List<CrewsCommentDTO> getList(Integer crew_post_no) throws Exception;

	//7. 관리자 댓글 삭제
	int deleteForAdmin(Integer crew_comment_no) throws Exception;

	//8. 댓글 전체 삭제 
	int deleteAll(Integer crew_post_no) throws Exception;

}