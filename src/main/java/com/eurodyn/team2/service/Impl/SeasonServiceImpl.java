package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Season;
import com.eurodyn.team2.repository.SeasonRepository;
import com.eurodyn.team2.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeasonServiceImpl  extends BaseServiceImpl<Season> implements SeasonService {
	private final SeasonRepository seasonRepository;
	
	@Override
	public JpaRepository<Season, Long> getRepository() {
		return seasonRepository;
	}
	
	@Override
	public Season findBySeasonNumberAndSeriesTitle(int seasonNumber, String seriesTitle) {
		return seasonRepository.findBySeasonNumberAndSeriesTitle(seasonNumber, seriesTitle);
	}
}
