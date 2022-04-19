package com.example.team2.service;

import com.example.team2.base.BaseComponent;
import com.example.team2.domain.BaseModel;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(
		propagation = Propagation.REQUIRED,
		isolation = Isolation.READ_COMMITTED,
		rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long>  {
	
	public abstract JpaRepository<T, Long> getRepository();
	
	public List<T> search(String searchItem){
		//return getRepository().search(searchItem);
		return null;
	}
	
}
