package com.tech.biz.domain;

import java.sql.Date;

public class UserDTO {
	private int user_no;
	private String user_id;
	private String nickname;
	private String user_pw;
	private String user_pw2;
	private String name;
	private String tel; //번호
	private String email;
	private String membertype; //회원타입
	private String reception; //수신여부
	private Date reg_date; //가입날짜
	private int company_no; 
	
	public UserDTO() {}

	public UserDTO(int user_no, String user_id, String user_pw, String name, String email, String nickname, String tel,
			Date reg_date, String membertype, String reception, int company_no) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.tel = tel;
		this.reg_date = reg_date;
		this.membertype = membertype;
		this.reception = reception;
		this.company_no = company_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String reception) {
		this.reception = reception;
	}

	public int getCompany_no() {
		return company_no;
	}

	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}

	@Override
	public String toString() {
		return "UserDTO [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", name=" + name
				+ ", email=" + email + ", nickname=" + nickname + ", tel=" + tel + ", reg_date=" + reg_date
				+ ", membertype=" + membertype + ", reception=" + reception + ", company_no=" + company_no + "]";
	}

}
