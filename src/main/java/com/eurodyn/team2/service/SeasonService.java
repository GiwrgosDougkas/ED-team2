package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Season;

public interface SeasonService extends BaseService<Season, Long>{
	
	Season findBySeasonNumberAndSeriesTitle(int seasonNumber, String seriesTitle);
	
}
