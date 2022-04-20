package com.eurodyn.team2.repository;


import com.eurodyn.team2.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
	
	@Query("select distinct se from Season se left join fetch se.series where se.seasonNumber = ?1 AND  se.series.title =  ?2")
	Season findBySeasonNumberAndSeriesTitle(int seasonNumber, String seriesTitle);
	
}
