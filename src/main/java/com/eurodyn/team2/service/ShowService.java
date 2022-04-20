package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Show;

import java.util.List;

public interface ShowService extends BaseService<Show, Long> {
	
	List<Show> findAll();
	
	List<Show> findMovieByTitle(String title);
	
	List<Show> findMovieByGenre(String genre);
	
	List<Show> findSeriesByTitle(String title);
	
	List<Show> findSeriesByGenre(String genre);
}
