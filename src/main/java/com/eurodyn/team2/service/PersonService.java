package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {
	
	List<Person> findAll();
}
