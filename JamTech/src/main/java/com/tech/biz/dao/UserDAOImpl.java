package com.tech.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
    SqlSession session;
	
	String namespace = "com.tech.biz.dao.UserDAO.";
	//<회원기능>
	//회원가입하는 메서드 / 사용자 정보를 user_info테이블에 저장하는 메서드
	@Override
	public int insertUser(UserDTO userDTO) throws Exception{
		return session.insert(namespace + "insertUser", userDTO);
	}
	
	//id중복확인
	@Override
    public int idChk(String user_id) throws Exception {
        return session.selectOne(namespace + "idChk", user_id);
    }
	
	//nickname중복확인
	@Override
    public int nicknameChk(String nickname) throws Exception {
        return session.selectOne(namespace + "nicknameChk", nickname);
    }
	
	//회원정보검색
	@Override
    public UserDTO searchUser(String user_id) throws Exception {
		return session.selectOne(namespace + "searchUser", user_id);
    }
	
	//회원정보수정
	@Override
    public int updateUser(UserDTO userDTO) throws Exception {
		return session.update(namespace + "updateUser", userDTO);
    }
	
	//회원삭제
	@Override
    public int deleteUser(UserDTO userDTO) throws Exception {
        return session.delete(namespace + "deleteUser", userDTO);
    }
	
	//회원 로그인
	@Override
	public int loginUser(UserDTO userDTO) throws Exception {
		return session.selectOne(namespace + "loginUser", userDTO);
	}
	
	//id찾기
	@Override
	public String findId(UserDTO userDTO) throws Exception {
		return session.selectOne(namespace + "findId", userDTO);
	}
	
	//pw찾기
	@Override
	public String findPw(UserDTO userDTO) throws Exception {
		return session.selectOne(namespace + "findPw", userDTO);
	}
	
	//pw새로변경
	@Override
	public int changePw(UserDTO userDTO) throws Exception {
		return session.update(namespace + "changePw", userDTO);
	}
	
	//<관리자기능>
	//관리자 회원수검색 
	@Override
	public List<CrewsBoardDTO> countUserAll() throws Exception {
		return session.selectList(namespace+"countUserAll");
	}
	
	//관리자 회원검색
	@Override
	public UserDTO selectUser(String user_id) throws Exception{
		return session.selectOne(namespace + "selectUser", user_id);
	}
		
	//관리자 모든회원삭제
	@Override
    public void deleteUserAll() throws Exception {
		session.delete(namespace + "deleteUserAll");
    }
}