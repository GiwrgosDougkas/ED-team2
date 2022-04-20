/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Series;
import com.eurodyn.team2.repository.SeriesRepository;
import com.eurodyn.team2.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"series"}, keyGenerator = "customCacheKeyGenerator")
public class SeriesServiceImpl extends BaseServiceImpl<Series> implements SeriesService {
	
	private final SeriesRepository seriesRepository;
	
	@Override
	public JpaRepository<Series, Long> getRepository() {
		return seriesRepository;
	}
	
	@Override
	public List<Series> search(String searchTerm) {
		return null;
	}
	
	@Override
	public List<Series> findByTitle(String title) {
		return seriesRepository.findByTitle(title);
	}
	
	@Override
	public List<Series> findByGenre(String genre) {
		return seriesRepository.findByGenre(genre);
	}
}
