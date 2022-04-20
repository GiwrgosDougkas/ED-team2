package com.eurodyn.team2.repository;


import com.eurodyn.team2.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews where s.title like ?1")
	List<Show> findByTitle(String title);
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre left join fetch s.languages left join fetch s.reviews")
	List<Show> findAll();
	
	@Query("select distinct s from Show s left join fetch s.cast left join fetch s.genre g left join fetch s.languages left join fetch s.reviews where g.name = ?1")
	List<Show> findByGenre(String genre);
}
