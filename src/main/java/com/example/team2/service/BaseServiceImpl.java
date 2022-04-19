package com.example.team2.service;

import com.example.team2.base.BaseComponent;
import com.example.team2.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@Transactional(
		propagation = Propagation.REQUIRED,
		isolation = Isolation.READ_COMMITTED,
		rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
	
	public abstract JpaRepository<T, Long> getRepository();
	
	public List<T> search(String searchItem) {
		//return getRepository().search(searchItem);
		return null;
	}
	
	public T create(T item) {
		return getRepository().save(item);
	}
	
	public List<T> createAll(List<T> items) {
		return getRepository().saveAll(items);
	}
	
	public void deleteById(Long id) {
		getRepository().deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public T get(Long id) {
		return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Transactional(readOnly = true)
	public boolean exists(T item) {
		return getRepository().existsById(item.getId());
	}
	
	public List<T> findAll() {
		return getRepository().findAll();
	}
	
}
