package com.tech.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.biz.domain.CrewsCommentDTO;
import com.tech.biz.service.CrewsCommentService;

@RestController 
public class CrewsCommentController {
	
	@Autowired
	CrewsCommentService crewscommentService;
	
	//json ajax 할떄
	//@RequestBody 요청할깨
	//@ResponseBody응답할때
	//HttpStatus.OK 결과물 ok일때
	//HttpStatus.BAD_REQUEST 결과가 에러일떄 400번떄 에러를 띄워줌
	
	//1.댓글작성
	//@ResponseBody             
	@PostMapping("/crewscomments") //      /comments?bno=760
	public ResponseEntity<String> write(@RequestBody CrewsCommentDTO cewscommentDTO, Integer crew_post_no, HttpSession session){
		//세션에서 아이디 받아옴 작성자 받아옴
		String crew_comment_writer = (String)session.getAttribute("user_id");
		cewscommentDTO.setCrew_comment_writer(crew_comment_writer);
		cewscommentDTO.setCrew_post_no(crew_post_no);
		
		try {
			if(crewscommentService.write(cewscommentDTO) != 1) {
				throw new Exception();
			}
			return new ResponseEntity<>("WRT_OK", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("WRT_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	
	//@PatchMapping : /comments/21?bno=760 - 760번게시글의 21번댓글 
	//@PathVariable : @DeleteMapping ajax로 uri에서 cno를 받아오니까 
	//매개번수 안에 @PathVariable 써줘야 받을수 있음. : uri에 포함되어 있는 값을 매개변수로 받는것


	
	//2.댓글수정
	//@ResponseBody
	@PatchMapping("/crewscomments/{crew_comment_no}") //     /comments/36
	public ResponseEntity<String> modify(@PathVariable Integer crew_comment_no, @RequestBody CrewsCommentDTO cewscommentDTO, HttpSession session){
		String crew_comment_writer = (String)session.getAttribute("user_id");
		cewscommentDTO.setCrew_comment_writer(crew_comment_writer);
		cewscommentDTO.setCrew_comment_no(crew_comment_no);
		
		try {
			if(crewscommentService.modify(cewscommentDTO) != 1) {
				throw new Exception();
			}
			return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("MOD_ERR", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	
	//@DeleteMapping : /comments/21?bno=760 - 760번게시글의 21번댓글 
	//@PathVariable : @DeleteMapping ajax로 uri에서 cno를 받아오니까 
	//매개번수 안에 @PathVariable 써줘야 받을수 있음. : uri에 포함되어 있는 값을 매개변수로 받는것
	//deleteMapping는 실제 회사엣는 데이터를 지울수 없으니 다른것들과 다르게 크롬 확장프로그램 Tabbed Postman을 사용해서 Test한다.
	//테스트할때는 로그아웃 상태라 하드코딩으로 commenter넣어준것
	
	//3.댓글삭제
	//@ResponseBody  
	@DeleteMapping("/crewscomments/{crew_comment_no}")
	public ResponseEntity<String> remove(@PathVariable Integer crew_comment_no, HttpSession session){
		String crew_comment_writer = (String)session.getAttribute("user_id");
		
		try {
			int rowCnt = crewscommentService.remove(crew_comment_no, crew_comment_writer);
			
			if(rowCnt !=1) {
				throw new Exception("Delete Failed");
			}
			
			return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>("DEL_OK", HttpStatus.BAD_REQUEST);
		}
	}
	

	//@ResponseBody // REST API, ajax
	//ResponseEntity :에러마다 각각 다른 에러번호를 만들어주는 것, 반환하는 타입은 ResponseEntity객체를 생성해 list타입을 담아서 전달함
	//list는 어느 한 매개변수를 특정해서 가져오는게 아니라 전부를 가져오기때문에 @RequestBody를 사용하지 않아도 된다
	
	//4.댓글List읽어오기
	@GetMapping("/crewscomments")// /comments?bno=222;
	public ResponseEntity<List<CrewsCommentDTO>> list(Integer crew_post_no){
		List<CrewsCommentDTO> list = null;
		
		try {
			list = crewscommentService.getList(crew_post_no);
			
			//정상작동시 반환
			return new ResponseEntity<List<CrewsCommentDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			//에러발생시 반환, 에러발생했으니 list를 못보냄 에러만 보냄
			return new ResponseEntity<List<CrewsCommentDTO>>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
