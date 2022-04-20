package com.eurodyn.team2.service.Impl;

import com.eurodyn.team2.repository.LanguageRepository;
import com.eurodyn.team2.domain.Language;
import com.eurodyn.team2.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LanguageServiceImpl extends BaseServiceImpl<Language> implements LanguageService {
    private LanguageRepository languageRepository;

    @Override
    public JpaRepository<Language, Long> getRepository() {
        return languageRepository;
    }
}
