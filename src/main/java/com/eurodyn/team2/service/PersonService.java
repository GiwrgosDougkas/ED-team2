package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.domain.PersonRole;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {
	
	List<Person> findAll();

	List<Person> findPersonByRole(PersonRole role);

	List<String> findActorsByShow(String show);
}
