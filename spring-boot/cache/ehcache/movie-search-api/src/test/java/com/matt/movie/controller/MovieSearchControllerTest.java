package com.matt.movie.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.matt.movie.model.Movie;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.matt.movie.service.MovieSearchService;



@RunWith(MockitoJUnitRunner.class)
public class MovieSearchControllerTest {

	@InjectMocks
	private MovieSearchController controller;
	
	@Mock
	private MovieSearchService service;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void getMovieTitlesTestofSizeOne(){
		List<Movie> titles = new ArrayList<Movie>();
		Movie m = new Movie();
		m.setImdbID("id");
		m.setTitle("matt");
		m.setYear(2020);
		titles.add(m);
	    when(service.findMoviesByTitle(anyString())).thenReturn(titles);
	    ResponseEntity<List<Movie>> resp = controller.getMovieTitles("s");
	    Assertions.assertThat(resp).isNotNull();
	    Assertions.assertThat(resp.getBody()).size().isEqualTo(1);
	}
	
	@Test
	public void getMovieTitlesTestIsEmpty(){
		List<Movie> titles = new ArrayList<Movie>();
	    when(service.findMoviesByTitle(anyString())).thenReturn(titles);

	    ResponseEntity<List<Movie>> resp = controller.getMovieTitles("s");
	    Assertions.assertThat(resp).isNotNull();
	    Assertions.assertThat(resp.getBody().isEmpty());
	}
}
