package com.adria.notification.repositories;

import com.adria.notification.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findById(UUID id);
    Event findByName(String eventName);
    boolean existsByName(String eventName);
    List<Event> findAll();
}
