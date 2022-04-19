package com.example.team2.service;

import com.example.team2.domain.Show;

import java.util.List;

public interface MovieService extends BaseService<Show, Long> {
	
	List<Show> findAll();

	List<Show> findByTitle(String title);
}
