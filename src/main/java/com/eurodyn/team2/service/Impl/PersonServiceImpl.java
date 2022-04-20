package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.repository.PersonRepository;
import com.eurodyn.team2.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"persons"}, keyGenerator = "customCacheKeyGenerator")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	
	private final PersonRepository personRepository;
	
	@Override
	public JpaRepository<Person, Long> getRepository() {
		return personRepository;
	}
	
	@Override
	public List<Person> search(String searchTerm) {
		return null;
	}
	
	@Override
	@Cacheable
	public List<Person> findAll() {
		logger.info("List does not exist in cache, fetching from repository.");
		return personRepository.findAll();
	}

	@CacheEvict(cacheNames = "persons", allEntries = true)
	@Scheduled(cron = "0 * * * * 1-5")
	public void evictCaches() {
		logger.debug("Evict persons caches");
	}
}
