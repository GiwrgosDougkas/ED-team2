package com.example.team2.service;

import java.util.List;

public interface BaseService<T, ID> {
	
	List<T> search(String searchTerm);
	
	List<T> findAll();
	
	T create(T item);
	
	List<T> createAll(List<T> items);
	
	void deleteById(ID id);
	
	T get(ID id);
	
	boolean exists(T item);
	
}
