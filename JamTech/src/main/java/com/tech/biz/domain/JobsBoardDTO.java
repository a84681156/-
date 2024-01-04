package com.tech.biz.domain;

import java.sql.Date;

public class JobsBoardDTO {
	private Integer jobs_post_no;
	private String jobs_title;
	private String jobs_writer;
	private String jobs_content;
	private Date jobs_reg_date;
	private Date jobs_up_date;
	private int jobs_cnt;
	private int jobs_recommend;
	private String jobs_employ;
	private String jobs_type; 
	private String jobs_part; 
	private String jobs_local;
	private String jobs_career;
	private String jobs_progress; 
	private Integer user_no;
	private Integer board_no;
	
	public JobsBoardDTO() {}
	
	public JobsBoardDTO(Integer jobs_post_no, String jobs_title, String jobs_writer, String jobs_content,
			Date jobs_reg_date, Date jobs_up_date, int jobs_cnt, int jobs_recommend, String jobs_employ,
			String jobs_type, String jobs_part, String jobs_local, String jobs_career, String jobs_progress,
			Integer user_no, Integer board_no) {
		super();
		this.jobs_post_no = jobs_post_no;
		this.jobs_title = jobs_title;
		this.jobs_writer = jobs_writer;
		this.jobs_content = jobs_content;
		this.jobs_reg_date = jobs_reg_date;
		this.jobs_up_date = jobs_up_date;
		this.jobs_cnt = jobs_cnt;
		this.jobs_recommend = jobs_recommend;
		this.jobs_employ = jobs_employ;
		this.jobs_type = jobs_type;
		this.jobs_part = jobs_part;
		this.jobs_local = jobs_local;
		this.jobs_career = jobs_career;
		this.jobs_progress = jobs_progress;
		this.user_no = user_no;
		this.board_no = board_no;
	}

	public Integer getJobs_post_no() {
		return jobs_post_no;
	}

	public void setJobs_post_no(Integer jobs_post_no) {
		this.jobs_post_no = jobs_post_no;
	}

	public String getJobs_title() {
		return jobs_title;
	}

	public void setJobs_title(String jobs_title) {
		this.jobs_title = jobs_title;
	}

	public String getJobs_writer() {
		return jobs_writer;
	}

	public void setJobs_writer(String jobs_writer) {
		this.jobs_writer = jobs_writer;
	}

	public String getJobs_content() {
		return jobs_content;
	}

	public void setJobs_content(String jobs_content) {
		this.jobs_content = jobs_content;
	}

	public Date getJobs_reg_date() {
		return jobs_reg_date;
	}

	public void setJobs_reg_date(Date jobs_reg_date) {
		this.jobs_reg_date = jobs_reg_date;
	}

	public Date getJobs_up_date() {
		return jobs_up_date;
	}

	public void setJobs_up_date(Date jobs_up_date) {
		this.jobs_up_date = jobs_up_date;
	}

	public int getJobs_cnt() {
		return jobs_cnt;
	}

	public void setJobs_cnt(int jobs_cnt) {
		this.jobs_cnt = jobs_cnt;
	}

	public int getJobs_recommend() {
		return jobs_recommend;
	}

	public void setJobs_recommend(int jobs_recommend) {
		this.jobs_recommend = jobs_recommend;
	}

	public String getJobs_employ() {
		return jobs_employ;
	}

	public void setJobs_employ(String jobs_employ) {
		this.jobs_employ = jobs_employ;
	}

	public String getJobs_type() {
		return jobs_type;
	}

	public void setJobs_type(String jobs_type) {
		this.jobs_type = jobs_type;
	}

	public String getJobs_part() {
		return jobs_part;
	}

	public void setJobs_part(String jobs_part) {
		this.jobs_part = jobs_part;
	}

	public String getJobs_local() {
		return jobs_local;
	}

	public void setJobs_local(String jobs_local) {
		this.jobs_local = jobs_local;
	}

	public String getJobs_career() {
		return jobs_career;
	}

	public void setJobs_career(String jobs_career) {
		this.jobs_career = jobs_career;
	}

	public String getJobs_progress() {
		return jobs_progress;
	}

	public void setJobs_progress(String jobs_progress) {
		this.jobs_progress = jobs_progress;
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
		return "JobsBoardDTO [jobs_post_no=" + jobs_post_no + ", jobs_title=" + jobs_title + ", jobs_writer="
				+ jobs_writer + ", jobs_content=" + jobs_content + ", jobs_reg_date=" + jobs_reg_date
				+ ", jobs_up_date=" + jobs_up_date + ", jobs_cnt=" + jobs_cnt + ", jobs_recommend=" + jobs_recommend
				+ ", jobs_employ=" + jobs_employ + ", jobs_type=" + jobs_type + ", jobs_part=" + jobs_part
				+ ", jobs_local=" + jobs_local + ", jobs_career=" + jobs_career + ", jobs_progress=" + jobs_progress
				+ ", user_no=" + user_no + ", board_no=" + board_no + "]";
	}
	
	
	
}
