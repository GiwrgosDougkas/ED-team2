package com.example.team2.service;

import com.example.team2.domain.BaseModel;

import java.util.List;

public interface BaseService<T, ID> {
	
	List<T> search(String searchTerm);
	
}
