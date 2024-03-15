package com.adria.notificationsystem.dao.impl;

import com.adria.notificationsystem.dao.IPreferencesDao;
import com.adria.notificationsystem.model.entities.Preferences;
import com.adria.notificationsystem.repository.PreferencesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPreferencesDaoImpl implements IPreferencesDao {

    private final PreferencesRepository preferencesRepository;

    @Override
    public Preferences save(Preferences preferences) {
        return preferencesRepository.save(preferences);
    }

    @Override
    public Preferences update(Preferences preferencesRequestDto) {
        return null;
    }

    @Override
    public boolean delete(Preferences preferencesRequestDto) {
        return false;
    }

    @Override
    public boolean existsByEventType(String eventType) {
        return preferencesRepository.existsByEventType(eventType);
    }

    @Override
    public List<Preferences> saveAll(List<Preferences> preferences) {
        return preferencesRepository.saveAll(preferences);
    }

    @Override
    public List<Preferences> findAll() {
        return preferencesRepository.findAll();
    }

}