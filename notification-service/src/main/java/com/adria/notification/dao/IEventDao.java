package com.adria.notification.dao;

import com.adria.notification.models.entities.Event;

import java.util.List;

public interface IEventDao {
    
    Event save (Event event);
    Event update (Event event);
    void delete (Event event);
    Event findByName (String name);
    List<Event> findAll();
}
