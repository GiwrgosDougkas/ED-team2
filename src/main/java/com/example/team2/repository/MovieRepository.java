package com.example.team2.repository;


import com.example.team2.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByTitle(String title);
}
