package com.tech.biz.domain;

import java.util.Date;

public class CrewsCommentDTO {
	private Integer crew_comment_no;//댓글번호
	private String crew_comment_content;//댓글
	private String crew_comment_writer;//작성자
	private Date crew_comment_reg_date;//작성일
	private Date crew_comment_up_date;//수정일	
	private Integer crew_comment_pcno;//부모댓글번호
	private Integer user_no;//부모댓글번호
	private Integer crew_post_no;//글번호
	
	public CrewsCommentDTO() {}
	
	public CrewsCommentDTO(Integer crew_comment_no, String crew_comment_content, String crew_comment_writer,
			Date crew_comment_reg_date, Date crew_comment_up_date, Integer crew_comment_pcno, Integer user_no,
			Integer crew_post_no) {
		super();
		this.crew_comment_no = crew_comment_no;
		this.crew_comment_content = crew_comment_content;
		this.crew_comment_writer = crew_comment_writer;
		this.crew_comment_reg_date = crew_comment_reg_date;
		this.crew_comment_up_date = crew_comment_up_date;
		this.crew_comment_pcno = crew_comment_pcno;
		this.user_no = user_no;
		this.crew_post_no = crew_post_no;
	}

	public Integer getCrew_comment_no() {
		return crew_comment_no;
	}

	public void setCrew_comment_no(Integer crew_comment_no) {
		this.crew_comment_no = crew_comment_no;
	}

	public String getCrew_comment_content() {
		return crew_comment_content;
	}

	public void setCrew_comment_content(String crew_comment_content) {
		this.crew_comment_content = crew_comment_content;
	}

	public String getCrew_comment_writer() {
		return crew_comment_writer;
	}

	public void setCrew_comment_writer(String crew_comment_writer) {
		this.crew_comment_writer = crew_comment_writer;
	}

	public Date getCrew_comment_reg_date() {
		return crew_comment_reg_date;
	}

	public void setCrew_comment_reg_date(Date crew_comment_reg_date) {
		this.crew_comment_reg_date = crew_comment_reg_date;
	}

	public Date getCrew_comment_up_date() {
		return crew_comment_up_date;
	}

	public void setCrew_comment_up_date(Date crew_comment_up_date) {
		this.crew_comment_up_date = crew_comment_up_date;
	}

	public Integer getCrew_comment_pcno() {
		return crew_comment_pcno;
	}

	public void setCrew_comment_pcno(Integer crew_comment_pcno) {
		this.crew_comment_pcno = crew_comment_pcno;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public Integer getCrew_post_no() {
		return crew_post_no;
	}

	public void setCrew_post_no(Integer crew_post_no) {
		this.crew_post_no = crew_post_no;
	}

	@Override
	public String toString() {
		return "CommentDTO [crew_comment_no=" + crew_comment_no + ", crew_comment_content=" + crew_comment_content
				+ ", crew_comment_writer=" + crew_comment_writer + ", crew_comment_reg_date=" + crew_comment_reg_date
				+ ", crew_comment_up_date=" + crew_comment_up_date + ", crew_comment_pcno=" + crew_comment_pcno
				+ ", user_no=" + user_no + ", crew_post_no=" + crew_post_no + "]";
	}
	
}
