package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Show;

import java.util.List;

public interface ShowService extends BaseService<Show, Long> {
	
	List<Show> findAll();

	List<Show> findByTitle(String title);
}
