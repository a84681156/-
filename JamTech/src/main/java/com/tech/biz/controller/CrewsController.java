package com.tech.biz.controller;

import java.io.File;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.PageHandler;
import com.tech.biz.domain.SearchCondition;
import com.tech.biz.service.CrewsBoardService;

@Controller
@RequestMapping("/crews")
public class CrewsController {
	@Autowired
	CrewsBoardService crewsboardService;

	//게시물 쓰기
	//게시물 쓰기 화면이동
	@GetMapping("/write")
	public String write(Integer page, Integer pageSize, Model m) {
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);
		return "writePageCrews";
	}
	
	//게시물 쓰기 저장
	@PostMapping("/write")
	public String write(CrewsBoardDTO crewsboardDTO, MultipartHttpServletRequest mpRequest, RedirectAttributes rattr, Model m, HttpSession session) {
		String crew_writer = (String) session.getAttribute("user_id");
		crewsboardDTO.setCrew_writer(crew_writer);
		
		try {
			//게시글 쓰기
//			int insertCnt = crewsboardService.write(crewsboardDTO, mpRequest);
//			
//			if(insertCnt != 1) {
//				throw new Exception("Write failed");
//			}

			//게시글쓰기, 첨부파일저장
			crewsboardService.write(crewsboardDTO, mpRequest);
			
			rattr.addFlashAttribute("msg", "WRT_OK");
			
			return "redirect:/crews/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("crewsboardDTO", crewsboardDTO);
			m.addAttribute("msg", "WRT_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "writePageCrews";
		}
	}

	
	//게시물수정
	//게시물 수정 화면이동
	@PostMapping("/modifyy")
	public String modify(CrewsBoardDTO crewsboardDTO, Integer page, Integer pageSize, Integer crew_post_no, String user_id, Model m, HttpSession session) {
		
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			m.addAttribute("crew_post_no", crew_post_no);
			
			List<Map<String, Object>> fileList = crewsboardService.selectFileList(crewsboardDTO.getCrew_post_no());
			m.addAttribute("file", fileList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifyPageCrews";
	}
	
	//게시물 수정
	@PostMapping("/modify")
	public String modify(CrewsBoardDTO crewsboardDTO, Integer crew_post_no, MultipartHttpServletRequest mpRequest, @RequestParam(value="fileNoDel[]") String[] files, @RequestParam(value="fileNameDel[]") String[] fileNames, RedirectAttributes rattr, Model m, HttpSession session) {
		String crew_writer = (String) session.getAttribute("user_id");
		
		crewsboardDTO.setCrew_writer(crew_writer);
		crewsboardDTO.setCrew_post_no(crew_post_no);

		try {
//			int modify = crewsboardService.modify(crewsboardDTO, mpRequest);
//			
//			if(modify != 1) {
//				throw new Exception("modify failed");
//			}
			
			//게시글 수정
			crewsboardService.modify(crewsboardDTO, mpRequest, fileNames, files);
			
			rattr.addFlashAttribute("msg", "MOD_OK");
			m.addAttribute("crew_post_no", crew_post_no);
			
			return "redirect:/crews/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("crewsboardDTO", crewsboardDTO);
			m.addAttribute("msg", "MOD_ERROR");
			
			//redirect: : 주소를 통해서 연결하는것
			//그냥 return "board" 는 그냥 board.jsp 찾아가는것
			return "modifyPageCrews";
		}
	}
	
	//게시물 삭제
	@PostMapping("/remove")
	public String remove(Integer crew_post_no, Integer page, RedirectAttributes rattr, Integer pageSize, Model m, HttpSession session) {
		
		String crew_writer = (String) session.getAttribute("user_id");
		
		try {
			
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			int rowCnt = crewsboardService.remove(crew_post_no, crew_writer);
		
			
			if(rowCnt != 1){
				throw new Exception("board remove error");
			} else {
				rattr.addFlashAttribute("msg", "DEL_OK");
				
				return "redirect:/crews/list";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "DEL_ERROR");
			return "redirect:/crews/list";
		}

	}
	
	
	//게시물 읽기	
	@GetMapping("/read")
	public String read(Integer crew_post_no, Integer page, Integer pageSize, Model m) {
		//쿼리스트링으로 넘길 때 기본형 int를 넣으면 자동으로 null값이 들어가서 오류뜸. 그래서 객체타입으로 넘겨줌 객체타입으 null이 아닌 공백으로 넘겨줌.
		try {
			CrewsBoardDTO crewsboardDTO = crewsboardService.read(crew_post_no);
			m.addAttribute("crewsboardDTO", crewsboardDTO);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);

			//첨부파일목록
			List<Map<String, Object>> fileList = crewsboardService.selectFileList(crewsboardDTO.getCrew_post_no());
			m.addAttribute("file", fileList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "postCrews";
	}
	
	//첨부파일 다운로드
	@GetMapping("/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map, Integer crew_file_no, HttpServletResponse response) throws Exception{
		System.out.println(map);
		Map<String, Object> resultMap = crewsboardService.selectFileInfo(crew_file_no);
		System.out.println("map" + resultMap);
		String crew_srv_file_name = (String) resultMap.get("CREW_SRV_FILE_NAME");
		String crew_org_file_name = (String) resultMap.get("CREW_ORG_FILE_NAME");
		
		System.out.println("org" + crew_srv_file_name);
		System.out.println("srv" + crew_org_file_name);
		
		
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\file\\crew\\"+crew_srv_file_name));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(crew_org_file_name, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
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
			int totalCnt = crewsboardService.getCount();
			
			PageHandler pageHandler = new PageHandler(totalCnt, sc); 
			
			List<CrewsBoardDTO> list = crewsboardService.getSearchSelectPage(sc);

			
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
		return "crews";
		
	}
	
	//ajax
	//좋아요 개수읽기
	@GetMapping("/crewsrecommend")// /comments?bno=222;
	@ResponseBody
	public int recommendCnt(Integer crew_post_no){
		
		try {
			int recommendCnt = crewsboardService.recommendCnt(crew_post_no);
			
			return recommendCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crew_post_no;
		
	}
	
	
	//좋아요증가
	@PatchMapping("/crewsincreRecommend/{crew_post_no}")
	@ResponseBody
	public int increaseRecommend(@RequestBody CrewsBoardDTO crewsboardDTO, @PathVariable Integer crew_post_no, Model m, HttpSession session) {
		try {
			int increaseRecommend = crewsboardService.increaseRecommend(crew_post_no);
			crewsboardDTO.setCrew_recommend(increaseRecommend);
			
			int crew_recommend = crewsboardDTO.getCrew_recommend();
			
			return crew_recommend;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crew_post_no;
	}
	
	//좋아요 감소
	@PatchMapping("/crewsdecreRecommend/{crew_post_no}")
	@ResponseBody
	public int decreaseRecommend(@RequestBody CrewsBoardDTO crewsboardDTO, @PathVariable Integer crew_post_no, Model m, HttpSession session) {
		try {
			
			int decreaseRecommend = crewsboardService.decreaseRecommend(crew_post_no);
			crewsboardDTO.setCrew_recommend(decreaseRecommend);

			int crew_recommend = crewsboardDTO.getCrew_recommend();

			return crew_recommend;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return crew_post_no;
	}
	
	//login되었는지 안되었는지 확인하는 메서드
	private boolean loginCheck(HttpServletRequest request) {
		//1.세션을 얻어서
		HttpSession session = request.getSession();
		
		//2.세션에 id가 있는지 확인
		return session.getAttribute("user_id") != null;	
	}
	
	
	
}
