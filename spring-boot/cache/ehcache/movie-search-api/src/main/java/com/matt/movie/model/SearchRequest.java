package com.matt.movie.model;

public class SearchRequest {

	public String title; 

	public SearchRequest(){}
	
	public SearchRequest(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
