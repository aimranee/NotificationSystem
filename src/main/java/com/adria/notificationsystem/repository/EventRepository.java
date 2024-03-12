package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findByUuid(UUID uuid);
    Event findByEventType(String eventType);
}
