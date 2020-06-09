package com.matt.movie.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class Movie {

	@JsonProperty("Title")
	private String Title;
	@JsonProperty("Year")
	private int Year;
	private String imdbID;
    	

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
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
		Title = title;
		Year = year;
		this.imdbID = imdbID;
	}
	@Override
	public String toString() {
		return "Movie [Title=" + Title + ", Year=" + Year + ", imdbID="
				+ imdbID + "]";
	}
}
