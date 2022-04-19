package com.example.team2.service;

import com.example.team2.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
	
	List<Movie> findAll();
	
	List<Movie> findByTitle(String title);
}
