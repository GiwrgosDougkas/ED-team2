package com.eurodyn.team2.repository;


import com.eurodyn.team2.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
	
	Season findBySeasonNumber(int seasonNumber);
	
}
