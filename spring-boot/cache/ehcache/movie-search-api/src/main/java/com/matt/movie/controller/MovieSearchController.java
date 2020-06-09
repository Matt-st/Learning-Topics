package com.matt.movie.controller;


import com.matt.movie.model.SearchRequest;
import com.matt.movie.model.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.matt.movie.service.MovieSearchService;

@RestController
public class MovieSearchController {
	
	@Autowired
	MovieSearchService service;
	
	@RequestMapping(value = "/api/movie/search", method = RequestMethod.GET)
	public ResponseEntity<SearchResponse> getMovieTitles(@RequestParam String title) {
		SearchResponse s = new SearchResponse();
		s.setTitles( service.findMoviesByTitle(title));
		if(s.getTitles().isEmpty()){
			return new ResponseEntity<SearchResponse>(s, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SearchResponse>(s, HttpStatus.OK);
	}
	

}
