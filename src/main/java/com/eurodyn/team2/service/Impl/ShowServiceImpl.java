package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Show;
import com.eurodyn.team2.repository.ShowRepository;
import com.eurodyn.team2.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"shows"}, keyGenerator = "customCacheKeyGenerator")
public class ShowServiceImpl extends BaseServiceImpl<Show> implements ShowService {
	
	private final ShowRepository showRepository;
	
	@Override
	public JpaRepository<Show, Long> getRepository() {
		return showRepository;
	}
	
	@Override
	public List<Show> search(String searchTerm) {
		return null;
	}
	
	@Override
	@Cacheable
	public List<Show> findAll() {
		logger.info("List does not exist in cache, fetching from repository.");
		return showRepository.findAll();
	}
	
	@Override
	public List<Show> findByTitle(String title) {
		return showRepository.findByTitle(title);
	}

	@CacheEvict(cacheNames = "shows", allEntries = true)
	@Scheduled(cron = "0 * * * * 1-5")
	public void evictCaches() {
		logger.debug("Evict shows caches");
	}
}
