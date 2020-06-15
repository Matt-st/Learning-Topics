package com.matt.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Movie implements Serializable {

	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private int year;
	@JsonProperty("imdbID")
	private String imdbID;
    	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public Movie(){}
	
	public Movie(String title, int year, String imdbID) {
		super();
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
	}
	@Override
	public String toString() {
		return "Movie [Title=" + title + ", Year=" + year + ", imdbID="
				+ imdbID + "]";
	}
}
