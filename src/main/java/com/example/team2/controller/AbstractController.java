package com.example.team2.controller;

import com.example.team2.base.BaseComponent;
import com.example.team2.domain.BaseModel;
import com.example.team2.service.BaseService;
import com.example.team2.transfer.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T extends BaseModel> extends BaseComponent {
	
	protected abstract BaseService<T, Long> getBaseService();
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<T>>> search(@PathVariable String searchTerm) {
		//TODO implement
		return null;
		//return new ResponseEntity<>(ApiResponse.<List<T>>builder().data(getBaseService().search(searchTerm)).build(), HttpStatus.OK);
	}
	
	
}