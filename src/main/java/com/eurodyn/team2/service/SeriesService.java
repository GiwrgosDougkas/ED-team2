package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Series;

import java.util.List;

public interface SeriesService extends BaseService<Series, Long> {
	
	List<Series> findAll();
	
	List<Series> findByTitle(String title);
	
	List<Series> findByGenre(String genre);
}
