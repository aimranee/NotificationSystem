package com.adria.notification.repository;

import com.adria.notification.model.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findByUuid(UUID uuid);
    Event findByType(String eventType);
    boolean existsByType(String eventType);
}
