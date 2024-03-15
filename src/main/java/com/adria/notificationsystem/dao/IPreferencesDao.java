package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.model.entities.Preferences;

public interface IPreferencesDao {

    Preferences save (Preferences preferences);
    Preferences update (Preferences preferences);
    boolean delete (Preferences preferences);
    boolean existsByEventType(String eventType);

}
