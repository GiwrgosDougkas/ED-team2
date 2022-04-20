package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Movie;
import com.eurodyn.team2.repository.MovieRepository;
import com.eurodyn.team2.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"shows"}, keyGenerator = "customCacheKeyGenerator")
public class MoviesServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final MovieRepository movieRepository;
	
	@Override
	public JpaRepository<Movie, Long> getRepository() {
		return movieRepository;
	}
	
	@Override
	public List<Movie> search(String searchTerm) {
		return null;
	}
	
	@Override
	@Cacheable
	public List<Movie> findAll() {
		logger.info("List does not exist in cache, fetching from repository.");
		return movieRepository.findAll();
	}
	
	@Override
	public List<Movie> findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}
	
	@Override
	public List<Movie> findByGenre(String genre) {
		return movieRepository.findByGenre(genre);
	}
	
	
	@CacheEvict(cacheNames = "shows", allEntries = true)
	@Scheduled(cron = "* 0/5 * * * 1-5")
	public void evictCaches() {
		logger.debug("Evict shows caches");
	}
	
	
	/*@Override
	public List<Show> searchShow(String searchText) {
		String searchStringUpper = searchText.toUpperCase();
		List<Show> showList = new ArrayList<>();
		final List<Predicate> predicatesList = new ArrayList<>();
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Show> criteriaQuery = criteriaBuilder.createQuery(Show.class);
		final Root<Show> root = criteriaQuery.from(Show.class);
		final Join<Show, Person> personJoin = root.join(Show_.cast, JoinType.INNER);
		
		predicatesList.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(Show_.title)), searchStringUpper));
		predicatesList.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(Show_.summary)), searchText));
		predicatesList.add(criteriaBuilder.like(criteriaBuilder.upper(personJoin.get(Person_.firstname)), searchText));
		predicatesList.add(criteriaBuilder.like(criteriaBuilder.upper(personJoin.get(Person_.lastname)), searchText));
		
		final TypedQuery<Show> query = entityManager.createQuery(criteriaQuery);
		
		showList = query.getResultList();
		return showList;
	}*/
}
