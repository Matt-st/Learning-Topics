package com.matt.movie.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

public interface MovieSearchService {
	
	@Cacheable(value = "retrieveMovieResultsCache", key = "#title")
	public List<String> findMoviesByTitle(String title);

}
