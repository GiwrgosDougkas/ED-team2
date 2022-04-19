package com.example.team2.controller;

import com.example.team2.base.BaseComponent;
import com.example.team2.domain.BaseModel;
import com.example.team2.service.BaseService;
import com.example.team2.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractController<T extends BaseModel> extends BaseComponent {
	
	protected abstract BaseService<T, Long> getBaseService();
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<T>>> findAll() {
		return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).build(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<T>> get(@PathVariable Long id) {
		return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().get(id)).build());
	}
	
	
	@PostMapping
	public ResponseEntity<ApiResponse<T>> create(@RequestBody T entity) {
		return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(entity)).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{searchterm}")
	public ResponseEntity<ApiResponse<List<T>>> search(@PathVariable("searchterm") String searchTerm) {
		//TODO implement
		return null;
	}
	
	
}
