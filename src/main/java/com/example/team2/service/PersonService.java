package com.example.team2.service;

import com.example.team2.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {
	
	List<Person> findAll();
}
