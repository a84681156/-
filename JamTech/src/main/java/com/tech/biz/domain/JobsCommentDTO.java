package com.tech.biz.domain;

import java.util.Date;

public class JobsCommentDTO {
	private Integer jobs_comment_no;//댓글번호
	private String jobs_comment_content;//댓글
	private String jobs_comment_writer;//작성자
	private Date jobs_comment_reg_date;//작성일
	private Date jobs_comment_up_date;//수정일	
	private Integer jobs_comment_pcno;//부모댓글번호
	private Integer user_no;//부모댓글번호
	private Integer jobs_post_no;//글번호
	
	public JobsCommentDTO() {}

	public JobsCommentDTO(Integer jobs_comment_no, String jobs_comment_content, String jobs_comment_writer,
			Date jobs_comment_reg_date, Date jobs_comment_up_date, Integer jobs_comment_pcno, Integer user_no,
			Integer crew_post_no) {
		super();
		this.jobs_comment_no = jobs_comment_no;
		this.jobs_comment_content = jobs_comment_content;
		this.jobs_comment_writer = jobs_comment_writer;
		this.jobs_comment_reg_date = jobs_comment_reg_date;
		this.jobs_comment_up_date = jobs_comment_up_date;
		this.jobs_comment_pcno = jobs_comment_pcno;
		this.user_no = user_no;
		this.jobs_post_no = jobs_post_no;
	}

	public Integer getJobs_comment_no() {
		return jobs_comment_no;
	}

	public void setJobs_comment_no(Integer jobs_comment_no) {
		this.jobs_comment_no = jobs_comment_no;
	}

	public String getJobs_comment_content() {
		return jobs_comment_content;
	}

	public void setJobs_comment_content(String jobs_comment_content) {
		this.jobs_comment_content = jobs_comment_content;
	}

	public String getJobs_comment_writer() {
		return jobs_comment_writer;
	}

	public void setJobs_comment_writer(String jobs_comment_writer) {
		this.jobs_comment_writer = jobs_comment_writer;
	}

	public Date getJobs_comment_reg_date() {
		return jobs_comment_reg_date;
	}

	public void setJobs_comment_reg_date(Date jobs_comment_reg_date) {
		this.jobs_comment_reg_date = jobs_comment_reg_date;
	}

	public Date getJobs_comment_up_date() {
		return jobs_comment_up_date;
	}

	public void setJobs_comment_up_date(Date jobs_comment_up_date) {
		this.jobs_comment_up_date = jobs_comment_up_date;
	}

	public Integer getJobs_comment_pcno() {
		return jobs_comment_pcno;
	}

	public void setJobs_comment_pcno(Integer jobs_comment_pcno) {
		this.jobs_comment_pcno = jobs_comment_pcno;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public Integer getJobs_post_no() {
		return jobs_post_no;
	}

	public void setJobs_post_no(Integer jobs_post_no) {
		this.jobs_post_no = jobs_post_no;
	}

	@Override
	public String toString() {
		return "JobsCommentDTO [jobs_comment_no=" + jobs_comment_no + ", jobs_comment_content=" + jobs_comment_content
				+ ", jobs_comment_writer=" + jobs_comment_writer + ", jobs_comment_reg_date=" + jobs_comment_reg_date
				+ ", jobs_comment_up_date=" + jobs_comment_up_date + ", jobs_comment_pcno=" + jobs_comment_pcno
				+ ", user_no=" + user_no + ", jobs_post_no=" + jobs_post_no + "]";
	}
	
}