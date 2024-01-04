package com.tech.biz.domain;

import java.util.Date;

public class QACommentDTO {
	private Integer qa_comment_no;//댓글번호
	private String qa_comment_content;//댓글
	private String qa_comment_writer;//작성자
	private Date qa_comment_reg_date;//작성일
	private Date qa_comment_up_date;//수정일	
	private Integer qa_comment_pcno;//부모댓글번호
	private Integer user_no;//부모댓글번호
	private Integer qa_post_no;//글번호
	
	public QACommentDTO() {}

	public QACommentDTO(Integer qa_comment_no, String qa_comment_content, String qa_comment_writer,
			Date qa_comment_reg_date, Date qa_comment_up_date, Integer qa_comment_pcno, Integer user_no,
			Integer qa_post_no) {
		super();
		this.qa_comment_no = qa_comment_no;
		this.qa_comment_content = qa_comment_content;
		this.qa_comment_writer = qa_comment_writer;
		this.qa_comment_reg_date = qa_comment_reg_date;
		this.qa_comment_up_date = qa_comment_up_date;
		this.qa_comment_pcno = qa_comment_pcno;
		this.user_no = user_no;
		this.qa_post_no = qa_post_no;
	}

	public Integer getQa_comment_no() {
		return qa_comment_no;
	}

	public void setQa_comment_no(Integer qa_comment_no) {
		this.qa_comment_no = qa_comment_no;
	}

	public String getQa_comment_content() {
		return qa_comment_content;
	}

	public void setQa_comment_content(String qa_comment_content) {
		this.qa_comment_content = qa_comment_content;
	}

	public String getQa_comment_writer() {
		return qa_comment_writer;
	}

	public void setQa_comment_writer(String qa_comment_writer) {
		this.qa_comment_writer = qa_comment_writer;
	}

	public Date getQa_comment_reg_date() {
		return qa_comment_reg_date;
	}

	public void setQa_comment_reg_date(Date qa_comment_reg_date) {
		this.qa_comment_reg_date = qa_comment_reg_date;
	}

	public Date getQa_comment_up_date() {
		return qa_comment_up_date;
	}

	public void setQa_comment_up_date(Date qa_comment_up_date) {
		this.qa_comment_up_date = qa_comment_up_date;
	}

	public Integer getQa_comment_pcno() {
		return qa_comment_pcno;
	}

	public void setQa_comment_pcno(Integer qa_comment_pcno) {
		this.qa_comment_pcno = qa_comment_pcno;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public Integer getQa_post_no() {
		return qa_post_no;
	}

	public void setQa_post_no(Integer qa_post_no) {
		this.qa_post_no = qa_post_no;
	}

	@Override
	public String toString() {
		return "QACommentDTO [qa_comment_no=" + qa_comment_no + ", qa_comment_content=" + qa_comment_content
				+ ", qa_comment_writer=" + qa_comment_writer + ", qa_comment_reg_date=" + qa_comment_reg_date
				+ ", qa_comment_up_date=" + qa_comment_up_date + ", qa_comment_pcno=" + qa_comment_pcno + ", user_no="
				+ user_no + ", qa_post_no=" + qa_post_no + "]";
	}
}
