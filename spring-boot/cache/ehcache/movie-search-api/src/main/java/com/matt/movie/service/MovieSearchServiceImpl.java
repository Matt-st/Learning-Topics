package com.matt.movie.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matt.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.matt.movie.model.HRMovieResponse;

@Component
public class MovieSearchServiceImpl implements MovieSearchService {
	
	@Autowired
    private RestTemplate restTemplate;
	//TODO add this to configuration file
	private static String url = "https://jsonmock.hackerrank.com/api/movies/search/";

	public List<Movie> findMoviesByTitle(String title){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("Title", title);
		HRMovieResponse response = httpGetByTitle(builder);
		List<Movie> titles = new ArrayList<>();
		for(int j = 1; j <= response.getTotalPages(); j++){
			 builder = UriComponentsBuilder.fromHttpUrl(url)
				        .queryParam("Title", title)
				        .queryParam("page", j);
			 HRMovieResponse resp = httpGetByTitle(builder);
			for (int i = 0; i < resp.getData().size(); i++){
				titles.add(resp.getData().get(i));
			}
		}
		Comparator<Movie> sortingByTitle =
				Comparator.comparing(Movie::getTitle);
		Collections.sort(titles, sortingByTitle);
		return titles;
		
	}

	private HRMovieResponse httpGetByTitle(UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<HRMovieResponse> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        HRMovieResponse.class);
		return response.getBody();
	}

}
