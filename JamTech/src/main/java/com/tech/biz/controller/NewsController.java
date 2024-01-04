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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.biz.domain.CrewsCommentDTO;
import com.tech.biz.domain.JobsBoardDTO;
import com.tech.biz.domain.NewsBoardDTO;
import com.tech.biz.domain.PageHandler;
import com.tech.biz.domain.SearchCondition;
import com.tech.biz.service.NewsBoardService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	NewsBoardService newsboardService;
	
	//게시물 쓰기(관리자)
	//게시물 쓰기 화면이동
	@GetMapping("/write")
	public String write(Integer page, Integer pageSize, Model m) {
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);
		
		
		return "writePageNews";
	}
	
	//게시물 쓰기 저장
	@PostMapping("/write")
	public String write(NewsBoardDTO newsboardDTO, RedirectAttributes rattr, Model m, HttpSession session) {
		String news_writer = (String) session.getAttribute("user_id");
		
		newsboardDTO.setNews_writer(news_writer);
		
		try {
			//게시글 쓰기
			int insertCnt = newsboardService.write(newsboardDTO);
			
			if(insertCnt != 1) {
				throw new Exception("Write failed");
			}
			
			rattr.addFlashAttribute("msg", "WRT_OK");
			
			
			return "redirect:/news/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("newsboardDTO", newsboardDTO);
			m.addAttribute("msg", "WRT_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "writePageNews";
		}
	}
	
	//게시물수정(관리자)
	//게시물 수정 화면이동
	@PostMapping("/modifyy")
	public String modify(Integer page, Integer pageSize, Integer news_post_no, Model m) {
		
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			m.addAttribute("news_post_no", news_post_no);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifyPageNews";
	}
	
	//게시물 수정
	@PostMapping("/modify")
	public String modify(NewsBoardDTO newsboardDTO, Integer news_post_no, RedirectAttributes rattr, Model m, HttpSession session) {
		String news_writer = (String) session.getAttribute("user_id");

		newsboardDTO.setNews_writer(news_writer);
		newsboardDTO.setNews_post_no(news_post_no);
		
		try {
			//게시글 수정
			int modify = newsboardService.modify(newsboardDTO);
			
			if(modify != 1) {
				throw new Exception("modify failed");
			}
			
			rattr.addFlashAttribute("msg", "MOD_OK");
			m.addAttribute("news_post_no", news_post_no);
			
			return "redirect:/news/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("newsboardDTO", newsboardDTO);
			m.addAttribute("msg", "MOD_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "modifyPageNews";
		}
	}
	
	//게시물 삭제(관리자)
	@PostMapping("/remove")
	public String remove(Integer news_post_no, Integer page, RedirectAttributes rattr, Integer pageSize, Model m, HttpSession session) {
		String news_writer = (String) session.getAttribute("user_id");
		
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			int rowCnt = newsboardService.remove(news_post_no, news_writer);
		
			if(rowCnt != 1){
				throw new Exception("board remove error");
			} else {
				rattr.addFlashAttribute("msg", "DEL_OK");
				
				return "redirect:/news/list";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "DEL_ERROR");
			return "redirect:/news/list";
		}
	}
	
	//게시물 읽기	
	@GetMapping("/read")
	public String read(Integer news_post_no, Integer page, Integer pageSize, Model m) {
		//쿼리스트링으로 넘길 때 기본형 int를 넣으면 자동으로 null값이 들어가서 오류뜸. 그래서 객체타입으로 넘겨줌 객체타입으 null이 아닌 공백으로 넘겨줌.
		try {
			
			NewsBoardDTO newsboardDTO = newsboardService.read(news_post_no);
			m.addAttribute("newsboardDTO", newsboardDTO);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "postNews";
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
			int totalCnt = newsboardService.getCount();
			
			PageHandler pageHandler = new PageHandler(totalCnt, sc); 
			
			List<NewsBoardDTO> list = newsboardService.getSearchSelectPage(sc);

			
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
		return "news";
		
	}
	
	//poppularNews 읽어오기
	@GetMapping("/popular")
	public ResponseEntity<List<NewsBoardDTO>> popularNews() {
		try {
			List<NewsBoardDTO> popularNews = newsboardService.popularNews();
			
			return new ResponseEntity<List<NewsBoardDTO>>(popularNews, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			//에러발생시 반환, 에러발생했으니 list를 못보냄 에러만 보냄
			return new ResponseEntity<List<NewsBoardDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//index화면
	//newNews 읽어오기
	@GetMapping("/new")
	public ResponseEntity<List<NewsBoardDTO>> newNews() {
		try {
			List<NewsBoardDTO> newNews = newsboardService.newNews();
			
			return new ResponseEntity<List<NewsBoardDTO>>(newNews, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			//에러발생시 반환, 에러발생했으니 list를 못보냄 에러만 보냄
			return new ResponseEntity<List<NewsBoardDTO>>(HttpStatus.BAD_REQUEST);
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
