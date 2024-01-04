package com.tech.biz.domain;

import java.sql.Date;

public class QABoardDTO {
	private Integer qa_post_no;
	private String qa_title;
	private String qa_writer;
	private String qa_content;
	private Date qa_reg_date;
	private Date qa_up_date;
	private int qa_cnt;
	private int qa_recommend;
	private String qa_big_sep;
	private String qa_small_sep;
	private String qa_language; 
	private String qa_ide; 
	private String qa_progress; 
	private Integer user_no;
	private Integer board_no;
	
	public QABoardDTO() {}
	

	public QABoardDTO(Integer qa_post_no, String qa_title, String qa_writer, String qa_content, Date qa_reg_date,
			Date qa_up_date, int qa_cnt, int qa_recommend, String qa_big_sep, String qa_small_sep, String qa_language,
			String qa_ide, String qa_progress, Integer user_no, Integer board_no) {
		super();
		this.qa_post_no = qa_post_no;
		this.qa_title = qa_title;
		this.qa_writer = qa_writer;
		this.qa_content = qa_content;
		this.qa_reg_date = qa_reg_date;
		this.qa_up_date = qa_up_date;
		this.qa_cnt = qa_cnt;
		this.qa_recommend = qa_recommend;
		this.qa_big_sep = qa_big_sep;
		this.qa_small_sep = qa_small_sep;
		this.qa_language = qa_language;
		this.qa_ide = qa_ide;
		this.qa_progress = qa_progress;
		this.user_no = user_no;
		this.board_no = board_no;
	}
	
	public Integer getQa_post_no() {
		return qa_post_no;
	}

	public void setQa_post_no(Integer qa_post_no) {
		this.qa_post_no = qa_post_no;
	}

	public String getQa_title() {
		return qa_title;
	}

	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}

	public String getQa_writer() {
		return qa_writer;
	}

	public void setQa_writer(String qa_writer) {
		this.qa_writer = qa_writer;
	}

	public String getQa_content() {
		return qa_content;
	}

	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}

	public Date getQa_reg_date() {
		return qa_reg_date;
	}

	public void setQa_reg_date(Date qa_reg_date) {
		this.qa_reg_date = qa_reg_date;
	}

	public Date getQa_up_date() {
		return qa_up_date;
	}

	public void setQa_up_date(Date qa_up_date) {
		this.qa_up_date = qa_up_date;
	}

	public int getQa_cnt() {
		return qa_cnt;
	}

	public void setQa_cnt(int qa_cnt) {
		this.qa_cnt = qa_cnt;
	}

	public int getQa_recommend() {
		return qa_recommend;
	}

	public void setQa_recommend(int qa_recommend) {
		this.qa_recommend = qa_recommend;
	}

	public String getQa_big_sep() {
		return qa_big_sep;
	}

	public void setQa_big_sep(String qa_big_sep) {
		this.qa_big_sep = qa_big_sep;
	}

	public String getQa_small_sep() {
		return qa_small_sep;
	}

	public void setQa_small_sep(String qa_small_sep) {
		this.qa_small_sep = qa_small_sep;
	}

	public String getQa_language() {
		return qa_language;
	}

	public void setQa_language(String qa_language) {
		this.qa_language = qa_language;
	}

	public String getQa_ide() {
		return qa_ide;
	}

	public void setQa_ide(String qa_ide) {
		this.qa_ide = qa_ide;
	}

	public String getQa_progress() {
		return qa_progress;
	}

	public void setQa_progress(String qa_progress) {
		this.qa_progress = qa_progress;
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
		return "QABoardDTO [qa_post_no=" + qa_post_no + ", qa_title=" + qa_title + ", qa_writer=" + qa_writer
				+ ", qa_content=" + qa_content + ", qa_reg_date=" + qa_reg_date + ", qa_up_date=" + qa_up_date
				+ ", qa_cnt=" + qa_cnt + ", qa_recommend=" + qa_recommend + ", qa_big_sep=" + qa_big_sep
				+ ", qa_small_sep=" + qa_small_sep + ", qa_language=" + qa_language + ", qa_ide=" + qa_ide
				+ ", qa_progress=" + qa_progress + ", user_no=" + user_no + ", board_no=" + board_no + "]";
	}
	
}
