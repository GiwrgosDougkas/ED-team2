package com.eurodyn.team2.service.Impl;


import com.eurodyn.team2.domain.Episode;
import com.eurodyn.team2.repository.EpisodeRepository;
import com.eurodyn.team2.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
	private final EpisodeRepository episodeRepository;
	
	@Override
	public JpaRepository<Episode, Long> getRepository() {
		return episodeRepository;
	}
}
