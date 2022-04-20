/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.eurodyn.team2.controller;

import com.eurodyn.team2.domain.Movie;
import com.eurodyn.team2.service.BaseService;
import com.eurodyn.team2.service.MovieService;
import com.eurodyn.team2.transfer.ApiResponse;
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
public class MovieController extends AbstractController<Movie> {
	
	private final MovieService movieService;
	
	
	@Override
	protected BaseService<Movie, Long> getBaseService() {
		return this.movieService;
	}
	
	@GetMapping("getByTitle/{title}")
	public ResponseEntity<ApiResponse<List<Movie>>> findMovieByTitle(@PathVariable("title") String title) {
		return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findByTitle(title)).build());
	}
	
	@GetMapping("getByGenre/{genre}")
	public ResponseEntity<ApiResponse<List<Movie>>> findMovieByGenre(@PathVariable("genre") String genre) {
		return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findByGenre(genre)).build());
	}
}
