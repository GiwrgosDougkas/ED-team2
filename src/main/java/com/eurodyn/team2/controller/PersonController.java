/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.eurodyn.team2.controller;

import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.service.BaseService;
import com.eurodyn.team2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController extends AbstractController<Person> {
	
	private final PersonService personService;
	
	@Override
	protected BaseService<Person, Long> getBaseService() {
		return this.personService;
	}
}
