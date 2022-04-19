package com.example.team2.service;

import com.example.team2.domain.Movie;
import com.example.team2.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
	
	private final MovieRepository movieRepository;
	//TODO temporary till datagenerator gets impl
	List<Movie> movies = List.of(
			Movie.builder().id(1L).title("Die Hard").summary("classis").build(),
			Movie.builder().id(2L).title("Die Hard 2").title("better classic").build());
	
	@Override
	public JpaRepository<Movie, Long> getRepository() {
		return movieRepository;
	}
	
	@Override
	public List<Movie> search(String searchTerm) {
		return null;
	}
	
	@Override
	public List<Movie> findAll() {
		return movies;
		//return movieRepository.findAll();
	}
	
	@Override
	public List<Movie> findByTitle(String title) {
		return movies.stream().filter(m -> m.getTitle().equals(title)).collect(Collectors.toList());
		//return movieRepository.findByTitle(title);
	}
}
