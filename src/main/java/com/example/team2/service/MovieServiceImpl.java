package com.example.team2.service;

import com.example.team2.domain.Show;
import com.example.team2.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl extends BaseServiceImpl<Show> implements MovieService {
	
	private final MovieRepository movieRepository;

	@Override
	public JpaRepository<Show, Long> getRepository() {
		return movieRepository;
	}
	
	@Override
	public List<Show> search(String searchTerm) {
		return null;
	}
	
	@Override
	public List<Show> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Show> findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}
}
