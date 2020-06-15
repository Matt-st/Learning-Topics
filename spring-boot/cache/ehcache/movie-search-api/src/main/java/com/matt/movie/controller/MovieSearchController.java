package com.matt.movie.controller;


import com.matt.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.matt.movie.service.MovieSearchService;

import java.util.List;

@RestController
public class MovieSearchController {
	
	@Autowired
	MovieSearchService service;
	
	@RequestMapping(value = "/api/movie/search", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getMovieTitles(@RequestParam String title) {
		List<Movie> list = service.findMoviesByTitle(title);
		if(list.isEmpty()){
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

}
