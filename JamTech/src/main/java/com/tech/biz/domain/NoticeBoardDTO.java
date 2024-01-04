package com.tech.biz.domain;

import java.sql.Date;

public class NoticeBoardDTO {
	private Integer notice_post_no;
	private String notice_title;
	private String notice_writer;
	private String notice_content;
	private Date notice_reg_date;
	private Date notice_up_date;
	private int notice_cnt;
	private int notice_recommend;
	private Integer admns_no;
	private Integer board_no;
	
	public NoticeBoardDTO() {}
	
	public NoticeBoardDTO(Integer notice_post_no, String notice_title, String notice_writer, String notice_content,
			Date notice_reg_date, Date notice_up_date, int notice_cnt, int notice_recommend, Integer admns_no,
			Integer board_no) {
		super();
		this.notice_post_no = notice_post_no;
		this.notice_title = notice_title;
		this.notice_writer = notice_writer;
		this.notice_content = notice_content;
		this.notice_reg_date = notice_reg_date;
		this.notice_up_date = notice_up_date;
		this.notice_cnt = notice_cnt;
		this.notice_recommend = notice_recommend;
		this.admns_no = admns_no;
		this.board_no = board_no;
	}

	public Integer getNotice_post_no() {
		return notice_post_no;
	}

	public void setNotice_post_no(Integer notice_post_no) {
		this.notice_post_no = notice_post_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_reg_date() {
		return notice_reg_date;
	}

	public void setNotice_reg_date(Date notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}

	public Date getNotice_up_date() {
		return notice_up_date;
	}

	public void setNotice_up_date(Date notice_up_date) {
		this.notice_up_date = notice_up_date;
	}

	public int getNotice_cnt() {
		return notice_cnt;
	}

	public void setNotice_cnt(int notice_cnt) {
		this.notice_cnt = notice_cnt;
	}

	public int getNotice_recommend() {
		return notice_recommend;
	}

	public void setNotice_recommend(int notice_recommend) {
		this.notice_recommend = notice_recommend;
	}

	public Integer getAdmns_no() {
		return admns_no;
	}

	public void setAdmns_no(Integer admns_no) {
		this.admns_no = admns_no;
	}

	public Integer getBoard_no() {
		return board_no;
	}

	public void setBoard_no(Integer board_no) {
		this.board_no = board_no;
	}

	@Override
	public String toString() {
		return "NoticeBoardDTO [notice_post_no=" + notice_post_no + ", notice_title=" + notice_title
				+ ", notice_writer=" + notice_writer + ", notice_content=" + notice_content + ", notice_reg_date="
				+ notice_reg_date + ", notice_up_date=" + notice_up_date + ", notice_cnt=" + notice_cnt
				+ ", notice_recommend=" + notice_recommend + ", admns_no=" + admns_no + ", board_no=" + board_no + "]";
	}
	
}
