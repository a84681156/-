package com.tech.biz.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.biz.domain.UserDTO;
import com.tech.biz.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;
	
	//화면이동
	@GetMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}
	
	
	//로그인기능
	@GetMapping("/login")
	public String login(UserDTO userDTO, String user_id, String user_pw, boolean rememberId, 
			 HttpServletResponse response, HttpServletRequest request, String toURL) {

				try {
					int login = userService.loginUser(userDTO);
					
					if(login != 1) {
						throw new Exception("login failed");
					}
					
					//2.세션에다가 값을 저장(아이디 기억하기 기능을위해 저장해놈)
					HttpSession session = request.getSession();
					session.setAttribute("user_id", user_id);
					
					//3.일치하면 home으로 이동
					if(rememberId) {
						//3-1.아이디 기억하기 체크 되어있으면 쿠키생성
						//쿠키생성
						Cookie cookie = new Cookie("user_id", user_id);
						//응답에 저장
						response.addCookie(cookie);
					}else {
						//3-2.아이디 기억하기 체그 안되어 있으면 쿠키생성후 바로지움
						//쿠키생성
						Cookie cookie = new Cookie("user_id", user_id);
						//지속시간0초 저장(쿠키지우는법)
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					
					toURL = (toURL == null ||toURL.equals("")) ? "/" : toURL;
					return "redirect:" + toURL;
					
				} catch (Exception e) {
					e.printStackTrace();	
				}
				//일치하지않을때
				String msg = URLEncoder.encode("ID또는 PW가 일치하지 않습니다.");
				return "redirect:/login/loginPage?msg=" + msg;
				

	}
	
	//로그아웃기능
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1.세션종료
		session.invalidate();
		//2.로그아웃 후 홈이동
		return "redirect:/";
	}
	
//	private boolean loginCheck(int dto) {
//		if(dto != 1){
//			return true;
//		} else {
//			return false;
//		} 
//		
//		//userDTO.getUser_id().equals(user_id) && userDTO.getUser_pw().equals(user_pw)
//	}
		
}
