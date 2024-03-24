package com.adria.notification.dao;

import com.adria.notification.models.entities.Preferences;

import java.util.List;

public interface IPreferencesDao {

    Preferences save (Preferences preferences);
    Preferences update (Preferences preferences);
    boolean delete (Preferences preferences);
    boolean existsByEventType(String eventType);
    List<Preferences> saveAll(List<Preferences> preferences);
    List<Preferences> findAll();

}
