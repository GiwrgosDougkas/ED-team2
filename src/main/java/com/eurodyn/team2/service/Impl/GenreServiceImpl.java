package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.domain.Genre;
import com.eurodyn.team2.repository.GenreRepository;
import com.eurodyn.team2.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenreServiceImpl extends BaseServiceImpl<Genre> implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public JpaRepository<Genre, Long> getRepository() {
        return genreRepository;
    }
    
    
    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
}
