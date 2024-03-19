package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.model.entities.Preferences;

import java.util.List;

public interface IPreferencesDao {

    Preferences save (Preferences preferences);
    Preferences update (Preferences preferences);
    boolean delete (Preferences preferences);
    boolean existsByEventType(String eventType);
    List<Preferences> saveAll(List<Preferences> preferences);
    List<Preferences> findAll();

}
