package com.tech.biz.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
	private Integer page=1;//현재페이지
	private Integer pageSize=10;//페이지크기
	private Integer offset=0;//??
	private String option="";//검색모드
	private String keyword="";//검색키워드
	
	
	//constructer
	public SearchCondition() {}
	
	public SearchCondition(Integer page, Integer pageSize) {
		this(page, pageSize, "", "");
	}
	
	public SearchCondition(String option, String keyword) {
		this.option=option;
		this.keyword=keyword;
	}
	
	public SearchCondition(Integer page, Integer pageSize, String option, String keyword) {
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
	}
	
	// queryString 한번에 만들어주는 메서드
	public String getQueryString() {
		return getQueryString(page);
	}
	
	public String getQueryString(Integer page) {
		return UriComponentsBuilder.newInstance()
					.queryParam("page", page)
					.queryParam("pageSize", pageSize)
					.queryParam("option", option)
					.queryParam("keyword", keyword)
					.build().toString();
	}
	
	
	
	
	//getter setter
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
