package com.tech.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.biz.domain.CrewsCommentDTO;
import com.tech.biz.domain.UserDTO;
import com.tech.biz.service.UserService;

@Controller
@RequestMapping("/register")
public class JoinController {
	@Autowired
	UserService userService;
	
	//화면이동
	@GetMapping("/agree")
	public String agree() {
		return "agree";
	}
	
	//화면이동
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	//회원가입정보 저장 후 결과화면 이동
	@PostMapping("/save")
	public String save(UserDTO userDTO, RedirectAttributes rattr, Model m, HttpSession session) {
		System.out.println("1");
		try {
			int insertUser = userService.joinUser(userDTO);
			
			if(insertUser != 1) {
				throw new Exception("Join failed");
			}
			rattr.addFlashAttribute("msg", "JOIN_OK");
			return "joinResult";
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "JOIN_ERROR");
			return "join";
		}
	}
	
	
	//중복확인
	//id중복확인
	@PostMapping("/idChk")
	@ResponseBody
	public String idChk(@RequestBody String user_id) {

		
		try {
			int idChk = userService.idChk(user_id);
			System.out.println(idChk);
			if(idChk == 1) {
				return "n";
			} else if(idChk == 0) {
				return "y";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user_id;
	}
	
	//닉네임중복확인
	@PostMapping("/nicknameChk")
	@ResponseBody
	public String nicknameChk(@RequestBody String nickname) {
		try {
			int nicknameChk = userService.nicknameChk(nickname);
			if(nicknameChk == 1) {
				return "n";
			} else if(nicknameChk == 0) {
				return "y";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nickname;
	}
}