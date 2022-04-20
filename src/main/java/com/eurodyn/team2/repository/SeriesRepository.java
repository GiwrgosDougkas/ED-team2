package com.eurodyn.team2.repository;

import com.eurodyn.team2.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	
	@Query("select distinct s from Series s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews")
	List<Series> findAll();
	
	@Query("select distinct s from Series s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews where s.title like ?1")
	List<Series> findByTitle(String title);
	
	@Query("select distinct s from Series s left join fetch s.cast left join fetch s.genre g left join fetch s.languages left join fetch s.reviews where g.name = ?1")
	List<Series> findByGenre(String title);
}
