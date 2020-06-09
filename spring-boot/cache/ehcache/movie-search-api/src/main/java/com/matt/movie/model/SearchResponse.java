package com.matt.movie.model;

import java.util.List;

public class SearchResponse {

	List<String> titles;
	
	public SearchResponse(){}
	
	public SearchResponse(List<String> titles){
		this.titles = titles;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	
	
}
