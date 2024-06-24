package com.adria.notification.repositories;

import com.adria.notification.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID>{
    Optional<Event> findById(UUID id);
    boolean existsById(UUID id);
    List<Event> findAllByNotificationTypeAndClientAppId(String type, String clientAppId);

    Event findByEventNameAndClientAppId(String eventName, String clientAppId);
    Event findByEventName(String event);

    @Modifying
    @Transactional
    @Query("UPDATE Event e SET e.editable = :newFieldValue WHERE e.id = :entityId")
    int updateEditableById(@Param("entityId") UUID entityId, @Param("newFieldValue") boolean newFieldValue);
}
