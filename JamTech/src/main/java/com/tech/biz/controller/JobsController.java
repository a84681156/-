package com.tech.biz.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.biz.domain.JobsBoardDTO;
import com.tech.biz.domain.PageHandler;
import com.tech.biz.domain.SearchCondition;
import com.tech.biz.service.JobsBoardService;

@Controller
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	JobsBoardService jobsboardService;
	

	
	//게시물 쓰기
	//게시물 쓰기 화면이동
	@GetMapping("/write")
	public String write(Integer page, Integer pageSize, Model m) {
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);
		
		
		return "writePageJobs";
	}
	
	//게시물 쓰기 저장
	@PostMapping("/write")
	public String write(JobsBoardDTO jobsboardDTO, RedirectAttributes rattr, Model m, HttpSession session) {
		String jobs_writer = (String) session.getAttribute("user_id");
		
		jobsboardDTO.setJobs_writer(jobs_writer);
		
		try {
			//게시글 쓰기
			int insertCnt = jobsboardService.write(jobsboardDTO);
			
			if(insertCnt != 1) {
				throw new Exception("Write failed");
			}
			
			rattr.addFlashAttribute("msg", "WRT_OK");
			
			
			return "redirect:/jobs/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("jobsboardDTO", jobsboardDTO);
			m.addAttribute("msg", "WRT_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "writePageJobs";
		}
	}
	
	//게시물수정
	//게시물 수정 화면이동
	@PostMapping("/modifyy")
	public String modify(Integer page, Integer pageSize, Integer jobs_post_no, Model m) {
		
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			m.addAttribute("jobs_post_no", jobs_post_no);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifyPageJobs";
	}
	
	//게시물 수정
	@PostMapping("/modify")
	public String modify(JobsBoardDTO jobsboardDTO, Integer jobs_post_no, RedirectAttributes rattr, Model m, HttpSession session) {
		String jobs_writer = (String) session.getAttribute("user_id");

		jobsboardDTO.setJobs_writer(jobs_writer);
		jobsboardDTO.setJobs_post_no(jobs_post_no);
		
		try {
			//게시글 수정
			int modify = jobsboardService.modify(jobsboardDTO);
			
			if(modify != 1) {
				throw new Exception("modify failed");
			}
			
			rattr.addFlashAttribute("msg", "MOD_OK");
			m.addAttribute("jobs_post_no", jobs_post_no);
			
			return "redirect:/jobs/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("jobsboardDTO", jobsboardDTO);
			m.addAttribute("msg", "MOD_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "modifyPageJobs";
		}
	}
	
	//게시물 삭제
	@PostMapping("/remove")
	public String remove(Integer jobs_post_no, Integer page, RedirectAttributes rattr, Integer pageSize, Model m, HttpSession session) {
		String jobs_writer = (String) session.getAttribute("user_id");
		
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			int rowCnt = jobsboardService.remove(jobs_post_no, jobs_writer);
		
			if(rowCnt != 1){
				throw new Exception("board remove error");
			} else {
				rattr.addFlashAttribute("msg", "DEL_OK");
				
				return "redirect:/jobs/list";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "DEL_ERROR");
			return "redirect:/jobs/list";
		}
	}
	
	
	//게시물 읽기	
	@GetMapping("/read")
	public String read(Integer jobs_post_no, Integer page, Integer pageSize, Model m) {
		//쿼리스트링으로 넘길 때 기본형 int를 넣으면 자동으로 null값이 들어가서 오류뜸. 그래서 객체타입으로 넘겨줌 객체타입으 null이 아닌 공백으로 넘겨줌.
		try {
			
			
			JobsBoardDTO jobsboardDTO = jobsboardService.read(jobs_post_no);
			m.addAttribute("jobsboardDTO", jobsboardDTO);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "postJobs";
	}
		
	
	//게시물List 읽기
	@GetMapping("/list")
	public String list(SearchCondition sc, Model m, HttpServletRequest request) {
		//로그인확인절차
		if(!loginCheck(request)) {
			return "redirect:/login/loginPage?toURL=" + request.getRequestURL();
		}
		
		//총게시물수 
		try {
			int totalCnt = jobsboardService.getCount();
			
			PageHandler pageHandler = new PageHandler(totalCnt, sc); 
			
			List<JobsBoardDTO> list = jobsboardService.getSearchSelectPage(sc);

			
			m.addAttribute("list", list);
			m.addAttribute("ph", pageHandler);
			
			// 현재 날짜+시간을 객체타입으로 가져옴.
			Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
			m.addAttribute("startOfToday",startOfToday.toEpochMilli());
				
			
		} catch (Exception e) {
			e.printStackTrace();
			
			m.addAttribute("msg", "LIST_ERR");
			m.addAttribute("totalCnt", 0);
		}
		return "jobs";
		
	}
	
	
	
	//ajax
	//좋아요 개수읽기
	@GetMapping("/jobsrecommend")// /comments?bno=222;
	@ResponseBody
	public int recommendCnt(Integer jobs_post_no){
		
		try {
			int recommendCnt = jobsboardService.recommendCnt(jobs_post_no);

			return recommendCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs_post_no;
		
	}
	
	
	//좋아요증가
	@PatchMapping("/jobsincreRecommend/{jobs_post_no}")
	@ResponseBody
	public int increaseRecommend(@RequestBody JobsBoardDTO jobsboardDTO, @PathVariable Integer jobs_post_no, Model m, HttpSession session) {
		try {
			int increaseRecommend = jobsboardService.increaseRecommend(jobs_post_no);
			jobsboardDTO.setJobs_recommend(increaseRecommend);
			
			int jobs_recommend = jobsboardDTO.getJobs_recommend();
			
			return jobs_recommend;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs_post_no;
	}
	
	//좋아요 감소
	@PatchMapping("/jobsdecreRecommend/{jobs_post_no}")
	@ResponseBody
	public int decreaseRecommend(@RequestBody JobsBoardDTO jobsboardDTO, @PathVariable Integer jobs_post_no, Model m, HttpSession session) {
		try {
			
			int decreaseRecommend = jobsboardService.decreaseRecommend(jobs_post_no);
			jobsboardDTO.setJobs_recommend(decreaseRecommend);
			
			int jobs_recommend = jobsboardDTO.getJobs_recommend();

			return jobs_recommend;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs_post_no;
	}
	
	
	//index화면
	//newNews읽어오기
	@GetMapping("/new")
	public ResponseEntity<List<JobsBoardDTO>> newNews() {
		try {
			List<JobsBoardDTO> newJobs = jobsboardService.newJobs();
			
			return new ResponseEntity<List<JobsBoardDTO>>(newJobs, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			//에러발생시 반환, 에러발생했으니 list를 못보냄 에러만 보냄
			return new ResponseEntity<List<JobsBoardDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	//login되었는지 안되었는지 확인하는 메서드
	private boolean loginCheck(HttpServletRequest request) {
		//1.세션을 얻어서
		HttpSession session = request.getSession();
		
		//2.세션에 id가 있는지 확인
		return session.getAttribute("user_id") != null;	
	}
}
