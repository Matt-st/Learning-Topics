package com.matt.movie.controller;


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
		SearchResponse s = new SearchResponse(service.findMoviesByTitle(title));
		if(s.getTitles().isEmpty()){
			return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	

}
