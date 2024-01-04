package com.tech.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.biz.dao.UserDAO;
import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.UserDTO;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	//<회원기능>
	//회원가입
	@Override
	public int joinUser(UserDTO userDTO) throws Exception{
		return userDAO.insertUser(userDTO);
	}
	
	//id중복확인
	@Override
	public int idChk(String user_id) throws Exception{
		return userDAO.idChk(user_id);
	}
	
	//nickname중복확인
	@Override
	public int nicknameChk(String nickname) throws Exception{
		return userDAO.nicknameChk(nickname);
	}
	
	//회원정보검색
	@Override
	public UserDTO searchUser(String user_id) throws Exception{
		return userDAO.searchUser(user_id);
	}
	
	//회원정보수정
	@Override
	public int modifiyUser(UserDTO userDTO) throws Exception{
		return userDAO.updateUser(userDTO);
	}
	
	//회원삭제
	@Override
	public int removeUser(UserDTO userDTO) throws Exception{
		return userDAO.deleteUser(userDTO);
	}
	
	//회원로그인
	@Override
	public int loginUser(UserDTO userDTO) throws Exception{
		return userDAO.loginUser(userDTO);
	}
	
	//id찾기
	@Override
	public String findId(UserDTO userDTO) throws Exception{
		return userDAO.findId(userDTO);
	}
	
	//pw찾기
	@Override
	public String findPw(UserDTO userDTO) throws Exception{
		return userDAO.findPw(userDTO);
	}
	
	//pw새로변경
	@Override
	public int changePw(UserDTO userDTO) throws Exception{
		return userDAO.changePw(userDTO);
	}
	
	
	
	//<관리자기능>
	//관리자 회원수검색
	@Override
	public List<CrewsBoardDTO> countUserAllForAdmin() throws Exception{
		return userDAO.countUserAll();
	}
	//관리자 회원검색
	@Override
	public UserDTO selectUserForAdmin(String user_id) throws Exception{
		return userDAO.selectUser(user_id);
	}
	
	//관리자 모든회원삭제
	@Override
	public void deleteUserAllForAdmin() throws Exception{
		userDAO.deleteUserAll();
	}
}