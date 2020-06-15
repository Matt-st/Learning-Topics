package com.matt.movie.model;


import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class HRMovieResponse {

	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	private List<Movie> data;

	public HRMovieResponse(){}
	
	public HRMovieResponse(int page, int perPage, int total,
						   int totalPages, List<Movie> data) {
		super();
		this.page = page;
		this.perPage = perPage;
		this.total = total;
		this.totalPages = totalPages;
		this.data = data;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	@JsonSetter("per_page")
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	@JsonSetter("total_pages")
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<Movie> getData() {
		return data;
	}
	public void setData(List<Movie> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "HRMovieResponse [page=" + page + ", per_page=" + perPage
				+ ", total=" + total + ", total_pages=" + totalPages
				+ ", data=" + data + "]";
	}
}
