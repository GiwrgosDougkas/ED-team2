package com.eurodyn.team2.repository;


import com.eurodyn.team2.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews")
	List<Movie> findAll();
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews where s.title like ?1")
	List<Movie> findByTitle(String title);
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre g left join fetch s.languages left join fetch s.reviews where g.name = ?1")
	List<Movie> findByGenre(String genre);
	
	
}
