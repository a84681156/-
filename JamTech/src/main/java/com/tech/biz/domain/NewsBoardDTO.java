package com.tech.biz.domain;

import java.sql.Date;

public class NewsBoardDTO {
	private Integer news_post_no;
	private String news_title;
	private String news_writer;
	private String news_content;
	private Date news_reg_date;
	private Date news_up_date;
	private int news_cnt;
	private int news_recommend;
	private Integer user_no;
	private Integer board_no;
	
	public NewsBoardDTO() {}
	
	public NewsBoardDTO(Integer news_post_no, String news_title, String news_writer, String news_content,
			Date news_reg_date, Date news_up_date, int news_cnt, int news_recommend, Integer user_no,
			Integer board_no) {
		super();
		this.news_post_no = news_post_no;
		this.news_title = news_title;
		this.news_writer = news_writer;
		this.news_content = news_content;
		this.news_reg_date = news_reg_date;
		this.news_up_date = news_up_date;
		this.news_cnt = news_cnt;
		this.news_recommend = news_recommend;
		this.user_no = user_no;
		this.board_no = board_no;
	}

	public Integer getNews_post_no() {
		return news_post_no;
	}

	public void setNews_post_no(Integer news_post_no) {
		this.news_post_no = news_post_no;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_writer() {
		return news_writer;
	}

	public void setNews_writer(String news_writer) {
		this.news_writer = news_writer;
	}

	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	public Date getNews_reg_date() {
		return news_reg_date;
	}

	public void setNews_reg_date(Date news_reg_date) {
		this.news_reg_date = news_reg_date;
	}

	public Date getNews_up_date() {
		return news_up_date;
	}

	public void setNews_up_date(Date news_up_date) {
		this.news_up_date = news_up_date;
	}

	public int getNews_cnt() {
		return news_cnt;
	}

	public void setNews_cnt(int news_cnt) {
		this.news_cnt = news_cnt;
	}

	public int getNews_recommend() {
		return news_recommend;
	}

	public void setNews_recommend(int news_recommend) {
		this.news_recommend = news_recommend;
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
		return "NewsBoardDTO [news_post_no=" + news_post_no + ", news_title=" + news_title + ", news_writer="
				+ news_writer + ", news_content=" + news_content + ", news_reg_date=" + news_reg_date
				+ ", news_up_date=" + news_up_date + ", news_cnt=" + news_cnt + ", news_recommend=" + news_recommend
				+ ", user_no=" + user_no + ", board_no=" + board_no + "]";
	}
	
	
}
