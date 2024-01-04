package com.tech.biz.domain;

import java.util.Date;

public class NewsCommentDTO {
	private Integer news_comment_no;//댓글번호
	private String news_comment_content;//댓글
	private String news_comment_writer;//작성자
	private Date news_comment_reg_date;//작성일
	private Date news_comment_up_date;//수정일	
	private Integer news_comment_pcno;//부모댓글번호
	private Integer user_no;//부모댓글번호
	private Integer news_post_no;//글번호
	
	public NewsCommentDTO() {}

	public NewsCommentDTO(Integer news_comment_no, String news_comment_content, String news_comment_writer,
			Date news_comment_reg_date, Date news_comment_up_date, Integer news_comment_pcno, Integer user_no,
			Integer news_post_no) {
		super();
		this.news_comment_no = news_comment_no;
		this.news_comment_content = news_comment_content;
		this.news_comment_writer = news_comment_writer;
		this.news_comment_reg_date = news_comment_reg_date;
		this.news_comment_up_date = news_comment_up_date;
		this.news_comment_pcno = news_comment_pcno;
		this.user_no = user_no;
		this.news_post_no = news_post_no;
	}

	public Integer getNews_comment_no() {
		return news_comment_no;
	}

	public void setNews_comment_no(Integer news_comment_no) {
		this.news_comment_no = news_comment_no;
	}

	public String getNews_comment_content() {
		return news_comment_content;
	}

	public void setNews_comment_content(String news_comment_content) {
		this.news_comment_content = news_comment_content;
	}

	public String getNews_comment_writer() {
		return news_comment_writer;
	}

	public void setNews_comment_writer(String news_comment_writer) {
		this.news_comment_writer = news_comment_writer;
	}

	public Date getNews_comment_reg_date() {
		return news_comment_reg_date;
	}

	public void setNews_comment_reg_date(Date news_comment_reg_date) {
		this.news_comment_reg_date = news_comment_reg_date;
	}

	public Date getNews_comment_up_date() {
		return news_comment_up_date;
	}

	public void setNews_comment_up_date(Date news_comment_up_date) {
		this.news_comment_up_date = news_comment_up_date;
	}

	public Integer getNews_comment_pcno() {
		return news_comment_pcno;
	}

	public void setNews_comment_pcno(Integer news_comment_pcno) {
		this.news_comment_pcno = news_comment_pcno;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	public Integer getNews_post_no() {
		return news_post_no;
	}

	public void setNews_post_no(Integer news_post_no) {
		this.news_post_no = news_post_no;
	}

	@Override
	public String toString() {
		return "NewsCommentDTO [news_comment_no=" + news_comment_no + ", news_comment_content=" + news_comment_content
				+ ", news_comment_writer=" + news_comment_writer + ", news_comment_reg_date=" + news_comment_reg_date
				+ ", news_comment_up_date=" + news_comment_up_date + ", news_comment_pcno=" + news_comment_pcno
				+ ", user_no=" + user_no + ", news_post_no=" + news_post_no + "]";
	}


}