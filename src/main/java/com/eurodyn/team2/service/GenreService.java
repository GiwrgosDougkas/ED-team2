package com.eurodyn.team2.service;

import com.eurodyn.team2.domain.Genre;

public interface GenreService extends BaseService<Genre, Long> {
	
	Genre findByName(String name);

}
