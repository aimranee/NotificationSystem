package com.adria.notification.dao;

import com.adria.notification.models.entities.Event;

import java.util.List;
import java.util.UUID;

public interface IEventDao {
    
    Event save (Event event);
    Event update (Event event);
    void delete (Event event);
    Event findByName (String name);
    Event findById (UUID id);
    List<Event> findByNotificationType (String notificationType);
    List<Event> findAll();
}
