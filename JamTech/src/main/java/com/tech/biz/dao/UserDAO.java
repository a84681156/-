package com.tech.biz.dao;

import java.util.List;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.UserDTO;

public interface UserDAO {

	//회원가입하는 메서드 / 사용자 정보를 user_info테이블에 저장하는 메서드
	int insertUser(UserDTO userDTO) throws Exception;
	
	//id중복확인
	int idChk(String user_id) throws Exception;
	
	//nickname중복확인
	int nicknameChk(String nickname) throws Exception;

	//회원정보검색
	UserDTO searchUser(String user_id) throws Exception;
	
	//회원정보수정
	int updateUser(UserDTO userDTO) throws Exception;

	//회원삭제
	int deleteUser(UserDTO userDTO) throws Exception;

	//회원로그인
	int loginUser(UserDTO userDTO) throws Exception;
	
	//id찾기
	String findId(UserDTO userDTO) throws Exception;
	
	//pw찾기
	String findPw(UserDTO userDTO) throws Exception;
	
	//pw새로변경
	int changePw(UserDTO userDTO) throws Exception;
	
	//관리자 회원수검색 
	List<CrewsBoardDTO> countUserAll() throws Exception;

	//관리자 회원검색
	UserDTO selectUser(String user_id) throws Exception;

	//관리자 모든회원삭제
	void deleteUserAll() throws Exception;





	
}