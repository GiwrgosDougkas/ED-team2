package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Show;
import com.eurodyn.team2.repository.ShowRepository;
import com.eurodyn.team2.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
	public List<Show> findAll() {
		return showRepository.findAll();
	}
	
	@Override
	public List<Show> findByTitle(String title) {
		return showRepository.findByTitle(title);
	}
}
