package com.example.team2.service;

import com.example.team2.domain.Language;
import com.example.team2.repository.LanguageRepository;

public class LanguageServiceImpl implements LanguageService{
    private LanguageRepository languageRepository;
    @Override
    public Language create(Language lang) {
        return languageRepository.save(lang);
    }
}
