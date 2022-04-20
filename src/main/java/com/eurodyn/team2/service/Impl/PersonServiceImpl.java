package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.repository.PersonRepository;
import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
	public List<Person> findAll() {
		return personRepository.findAll();
	}
}
