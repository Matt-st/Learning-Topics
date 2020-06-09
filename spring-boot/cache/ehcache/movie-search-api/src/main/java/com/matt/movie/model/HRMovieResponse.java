package com.matt.movie.model;

import java.util.List;

public class HRMovieResponse {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<Movie> data;

	public HRMovieResponse(){}
	
	public HRMovieResponse(int page, int per_page, int total,
			int total_pages, List<Movie> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<Movie> getData() {
		return data;
	}
	public void setData(List<Movie> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "HRMovieResponse [page=" + page + ", per_page=" + per_page
				+ ", total=" + total + ", total_pages=" + total_pages
				+ ", data=" + data + "]";
	}
}
