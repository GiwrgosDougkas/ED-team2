/*
 * Copyright (c) 2019 Federal Republic of Germany and the 16 federated states of
 * the Federal Republic of Germany All rights reserved. No warranty, explicit or
 * implicit, provided. Unauthorized copying of this file via any medium is
 * strictly prohibited. Authored by European Dynamics SA <info@eurodyn.com>
 */
package com.eurodyn.team2.controller;

import com.eurodyn.team2.domain.Series;
import com.eurodyn.team2.service.BaseService;
import com.eurodyn.team2.service.SeriesService;
import com.eurodyn.team2.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController extends AbstractController<Series> {
	
	private final SeriesService seriesService;
	
	
	@Override
	protected BaseService<Series, Long> getBaseService() {
		return this.seriesService;
	}
	
	@GetMapping("getByGenre/{genre}")
	public ResponseEntity<ApiResponse<List<Series>>> findSeriesByGenre(@PathVariable("genre") String genre) {
		return ResponseEntity.ok(ApiResponse.<List<Series>>builder().data(seriesService.findByGenre(genre)).build());
	}
	
	@GetMapping("getByTitle/{title}")
	public ResponseEntity<ApiResponse<List<Series>>> findSeriesByTitle(@PathVariable("title") String title) {
		return ResponseEntity.ok(ApiResponse.<List<Series>>builder().data(seriesService.findByTitle(title)).build());
	}
}
