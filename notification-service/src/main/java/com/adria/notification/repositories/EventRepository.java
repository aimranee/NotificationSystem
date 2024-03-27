package com.adria.notification.repositories;

import com.adria.notification.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findById(UUID id);
    Event findByType(String eventType);
    boolean existsByType(String eventType);
}
