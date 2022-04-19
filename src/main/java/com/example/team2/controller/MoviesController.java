/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.example.team2.controller;

import com.example.team2.domain.Show;
import com.example.team2.service.BaseService;
import com.example.team2.service.MovieService;
import com.example.team2.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController extends AbstractController<Show> {
	
	private final MovieService movieService;
	
	
	@Override
	protected BaseService<Show, Long> getBaseService() {
		return this.movieService;
	}
	
	@GetMapping("getByTitle/{title}")
	public ResponseEntity<ApiResponse<List<Show>>> findByTitle(@PathVariable("title") String title) {
		return ResponseEntity.ok(ApiResponse.<List<Show>>builder().data(movieService.findByTitle(title)).build());
	}
}
