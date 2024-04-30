package com.adria.notification.repositories;

import com.adria.notification.models.entities.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences,Long> {
    boolean existsByEventEventName(String eventName);
    List<Preferences> findAll();

}
