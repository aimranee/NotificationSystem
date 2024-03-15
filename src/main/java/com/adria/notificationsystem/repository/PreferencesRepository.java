package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.model.entities.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences,Long> {
    boolean existsByEventType(String eventType);
    List<Preferences> findAll();

}
