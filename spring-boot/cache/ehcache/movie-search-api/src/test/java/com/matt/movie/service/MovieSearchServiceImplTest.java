package com.matt.movie.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.matt.movie.model.HRMovieResponse;
import com.matt.movie.model.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieSearchServiceImplTest {
	
	@InjectMocks
	private MovieSearchServiceImpl service;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void findMoviesByTitleTestofSizeTwo(){
		List<Movie> data = new ArrayList<Movie>();
		data.add(new Movie("Matt's test", 2019, "a234sdg"));
		data.add(new Movie("apple test", 2019, "a234ddg"));
		HRMovieResponse resp = new HRMovieResponse(1, 10, 1, 1, data);
		
		ResponseEntity<HRMovieResponse> response = new ResponseEntity<HRMovieResponse>(resp, HttpStatus.OK);
	    when(restTemplate.
	    		exchange(anyString(), 
	    				ArgumentMatchers.any(HttpMethod.class), 
	    				ArgumentMatchers.any(HttpEntity.class), 
	    				ArgumentMatchers.<Class<HRMovieResponse>>any())).thenReturn(response);

	    List<Movie> titles = service.findMoviesByTitle("a");
	    System.out.println(titles.get(0));
	    System.out.println(titles.get(1));
	    Assertions.assertThat(titles).isNotNull();
	    Assertions.assertThat(titles.size()).isEqualTo(2);
	}
	
}
