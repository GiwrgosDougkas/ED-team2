package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
	
	List<Movie> findAll();
	
	List<Movie> findByTitle(String title);
	
	List<Movie> findByGenre(String genre);
}
