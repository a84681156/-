package com.tech.biz.domain;

import java.sql.Date;

public class CrewsBoardDTO {
	private Integer crew_post_no;
	private String crew_title;
	private String crew_writer;
	private String crew_content;
	private Date crew_reg_date;
	private Date crew_up_date;
	private int crew_cnt;
	private Integer crew_recommend;
	private String crew_local;
	private String crew_career;
	private String crew_time; 
	private String crew_progress; 
	private Integer user_no;
	private Integer board_no;
	
	public CrewsBoardDTO() {}
	
	public CrewsBoardDTO(Integer crew_post_no, String crew_title, String crew_writer, String crew_content,
			Date crew_reg_date, Date crew_up_date, int crew_cnt, Integer crew_recommend, String crew_local,
			String crew_career, String crew_time, String crew_progress, Integer user_no, Integer board_no) {
		this.crew_post_no = crew_post_no;
		this.crew_title = crew_title;
		this.crew_writer = crew_writer;
		this.crew_content = crew_content;
		this.crew_reg_date = crew_reg_date;
		this.crew_up_date = crew_up_date;
		this.crew_cnt = crew_cnt;
		this.crew_recommend = crew_recommend;
		this.crew_local = crew_local;
		this.crew_career = crew_career;
		this.crew_time = crew_time;
		this.crew_progress = crew_progress;
		this.user_no = user_no;
		this.board_no = board_no;
	}

	public Integer getCrew_post_no() {
		return crew_post_no;
	}

	public void setCrew_post_no(Integer crew_post_no) {
		this.crew_post_no = crew_post_no;
	}

	public String getCrew_title() {
		return crew_title;
	}

	public void setCrew_title(String crew_title) {
		this.crew_title = crew_title;
	}

	public String getCrew_writer() {
		return crew_writer;
	}

	public void setCrew_writer(String crew_writer) {
		this.crew_writer = crew_writer;
	}

	public String getCrew_content() {
		return crew_content;
	}

	public void setCrew_content(String crew_content) {
		this.crew_content = crew_content;
	}

	public Date getCrew_reg_date() {
		return crew_reg_date;
	}

	public void setCrew_reg_date(Date crew_reg_date) {
		this.crew_reg_date = crew_reg_date;
	}

	public Date getCrew_up_date() {
		return crew_up_date;
	}

	public void setCrew_up_date(Date crew_up_date) {
		this.crew_up_date = crew_up_date;
	}

	public int getCrew_cnt() {
		return crew_cnt;
	}

	public void setCrew_cnt(int crew_cnt) {
		this.crew_cnt = crew_cnt;
	}

	public Integer getCrew_recommend() {
		return crew_recommend;
	}

	public void setCrew_recommend(Integer crew_recommend) {
		this.crew_recommend = crew_recommend;
	}

	public String getCrew_local() {
		return crew_local;
	}

	public void setCrew_local(String crew_local) {
		this.crew_local = crew_local;
	}

	public String getCrew_career() {
		return crew_career;
	}

	public void setCrew_career(String crew_career) {
		this.crew_career = crew_career;
	}

	public String getCrew_time() {
		return crew_time;
	}

	public void setCrew_time(String crew_time) {
		this.crew_time = crew_time;
	}

	public String getCrew_progress() {
		return crew_progress;
	}

	public void setCrew_progress(String crew_progress) {
		this.crew_progress = crew_progress;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public Integer getBoard_no() {
		return board_no;
	}

	public void setBoard_no(Integer board_no) {
		this.board_no = board_no;
	}

	@Override
	public String toString() {
		return "CrewsBoardDTO [crew_post_no=" + crew_post_no + ", crew_title=" + crew_title + ", crew_writer="
				+ crew_writer + ", crew_content=" + crew_content + ", crew_reg_date=" + crew_reg_date
				+ ", crew_up_date=" + crew_up_date + ", crew_cnt=" + crew_cnt + ", crew_recommend=" + crew_recommend
				+ ", crew_local=" + crew_local + ", crew_career=" + crew_career + ", crew_time=" + crew_time
				+ ", crew_progress=" + crew_progress + ", user_no=" + user_no + ", board_no=" + board_no + "]";
	}
	
}
