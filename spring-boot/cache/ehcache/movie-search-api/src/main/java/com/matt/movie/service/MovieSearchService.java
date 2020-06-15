package com.matt.movie.service;

import java.util.List;

import com.matt.movie.model.Movie;
import org.springframework.cache.annotation.Cacheable;

public interface MovieSearchService {
	
	@Cacheable(value = "retrieveMovieResultsCache", key = "#title")
	public List<Movie> findMoviesByTitle(String title);

}
