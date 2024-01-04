package com.tech.biz.service;

import java.util.List;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.UserDTO;

public interface UserService {

	//<회원기능>
	//회원가입
	int joinUser(UserDTO userDTO) throws Exception;
	
	//id회원가입
	int idChk(String user_id) throws Exception;
	
	//nickname중복확인
	int nicknameChk(String nickname) throws Exception;
	
	//회워정보검색
	UserDTO searchUser(String user_id) throws Exception;

	//회원정보수정
	int modifiyUser(UserDTO userDTO) throws Exception;

	//회원삭제
	int removeUser(UserDTO userDTO) throws Exception;
	
	//회원로그인
	int loginUser(UserDTO userDTO) throws Exception;
	
	//id찾기
	String findId(UserDTO userDTO) throws Exception;
	
	//pw찾기
	String findPw(UserDTO userDTO) throws Exception;
	
	//pw새로변경
	int changePw(UserDTO userDTO) throws Exception;
	
	
	//<관리자기능>
	//관리자 회원수검색
	List<CrewsBoardDTO> countUserAllForAdmin() throws Exception;

	//관리자 회원검색
	UserDTO selectUserForAdmin(String user_id) throws Exception;

	//관리자 모든회원삭제
	void deleteUserAllForAdmin() throws Exception;








}