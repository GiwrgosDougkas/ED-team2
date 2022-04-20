package com.eurodyn.team2.repository;


import com.eurodyn.team2.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Show, Long> {
	
	List<Show> findByTitle(String title);
}
