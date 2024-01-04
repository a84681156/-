package com.tech.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.biz.domain.UserDTO;
import com.tech.biz.service.UserService;

@Controller
@RequestMapping("/myPage")
public class MypageController {
	@Autowired
	UserService userService;
	
	//마이페이지화면이동
	@GetMapping("/myPage")
	public String myPage(Model m, HttpSession session) {
		try {
			String user_id = (String) session.getAttribute("user_id");
			
			UserDTO userDTO = userService.searchUser(user_id);
			m.addAttribute("userDTO", userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "myPage";
	}
	
	//회원수정화면이동
	@GetMapping("/modifyy")
	public String modifyInfo(String user_id, Model m) {
		try {
			UserDTO userDTO = userService.searchUser(user_id);
			m.addAttribute("userDTO", userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "myPageModify";
	}
	
	//회원정보수정
	@PostMapping("/modify")
	public String modify(UserDTO userDTO, Model m, HttpSession session) {
		try {
			String user_id = (String) session.getAttribute("user_id");
			userDTO.setUser_id(user_id);
			
			userService.modifiyUser(userDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/myPage/myPage";
	}
}
