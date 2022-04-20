package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Season;
import com.eurodyn.team2.repository.SeasonRepository;
import com.eurodyn.team2.repository.ShowRepository;
import com.eurodyn.team2.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public Season findBySeasonNumber(int seasonNumber) {
		return seasonRepository.findBySeasonNumber(seasonNumber);
	}
}
