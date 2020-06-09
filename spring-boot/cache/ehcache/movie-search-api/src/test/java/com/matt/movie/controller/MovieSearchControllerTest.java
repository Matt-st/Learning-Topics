package com.matt.movie.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.matt.movie.model.SearchRequest;
import com.matt.movie.model.SearchResponse;
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
		List<String> titles = new ArrayList<String>();
		titles.add("matt");
	    when(service.findMoviesByTitle(anyString())).thenReturn(titles);
	    ResponseEntity<SearchResponse> resp = controller.getMovieTitles("s");
	    Assertions.assertThat(resp).isNotNull();
	    Assertions.assertThat(resp.getBody().getTitles()).size().isEqualTo(1);
	}
	
	@Test
	public void getMovieTitlesTestIsEmpty(){
		List<String> titles = new ArrayList<String>();
	    when(service.findMoviesByTitle(anyString())).thenReturn(titles);

	    ResponseEntity<SearchResponse> resp = controller.getMovieTitles("s");
	    Assertions.assertThat(resp).isNotNull();
	    Assertions.assertThat(resp.getBody().getTitles()).isEmpty();
	}
}
