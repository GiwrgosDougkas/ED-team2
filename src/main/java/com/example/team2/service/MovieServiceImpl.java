package com.example.team2.service;
import com.example.team2.repository.MovieRepository;

import com.example.team2.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
	
	private final MovieRepository movieRepository;
	
	@Override
	public JpaRepository<Movie, Long> getRepository() {
		return movieRepository;
	}
	
	@Override
	public List<Movie> search(String searchTerm) {
		return null;
	}
	
}
