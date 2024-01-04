package com.tech.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.biz.domain.UserDTO;
import com.tech.biz.service.UserService;

@Controller
@RequestMapping("/findIdPw")
public class findIdPwController {
	@Autowired
	UserService userService;
	
	//id찾기 화면이동
	@GetMapping("/findIdPw")
	public String findIdPw() {
		return "findIdPw";
	}
	
	//id찾기
	@PostMapping("/findId")
	public String findId(UserDTO userDTO, Model m) {
		try {
			String findId = userService.findId(userDTO);
			
			if(findId==null) {
				throw new Exception("Find failed");
			} else {
				m.addAttribute("findId", findId);
				m.addAttribute("msg", "FIND_OK");
				return "idResult";
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "FIND_ERR");
			return "findIdPw";
		}
	}
	
	//pw찾기
	@PostMapping("/findPw")
	public String findPw(UserDTO userDTO, Model m) {
		try {
			String findPw = userService.findPw(userDTO);
			
			if(findPw == null) {
				throw new Exception("Find failed");
			} else {
				m.addAttribute("findPw", findPw);
				m.addAttribute("userDTO", userDTO);
				return "pwChange";
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "FIND_ERR");
			return "findIdPw";
		}
	}
	
	//pw변경
	@PostMapping("/changePw")
	public String changePw(String user_pw, String user_id, String name, String tel, String email, UserDTO userDTO, Model m) {
		try {
			userDTO.setUser_pw(user_pw);
			userDTO.setUser_id(user_id);
			userDTO.setName(name);
			userDTO.setTel(tel);
			userDTO.setEmail(email);
			int changePw = userService.changePw(userDTO);

			if(changePw == 0) {
				throw new Exception("Find failed2");
			} else {
				m.addAttribute("msg", "CHANGE_OK");
				return "pwResult";
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "CHANGE_ERR");
			return "pwChange";
		}
	}
}
