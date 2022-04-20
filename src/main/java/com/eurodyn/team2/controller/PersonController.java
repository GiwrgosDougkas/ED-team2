/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.eurodyn.team2.controller;

import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.domain.PersonRole;
import com.eurodyn.team2.service.BaseService;
import com.eurodyn.team2.service.PersonService;
import com.eurodyn.team2.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController extends AbstractController<Person> {

    private final PersonService personService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return this.personService;
    }

    @GetMapping(params = {"role"})
    public ResponseEntity<ApiResponse<List<Person>>> personByRole(@RequestParam PersonRole role) {
        return new ResponseEntity<>(ApiResponse.<List<Person>>builder().data(personService.findPersonByRole(role)).build(),
                HttpStatus.OK);
    }

    @GetMapping(params = {"show"})
    public ResponseEntity<ApiResponse<List<Person>>> personByShow(@RequestParam String show) {
        return new ResponseEntity(ApiResponse.<List<String>>builder().data(personService.findActorsByShow(show)).build(),
                HttpStatus.OK);
    }
}
