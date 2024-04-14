package com.adria.notification.dao.impl;

import com.adria.notification.models.entities.Event;
import com.adria.notification.repositories.EventRepository;
import com.adria.notification.dao.IEventDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IEventDaoImpl implements IEventDao {

    private final EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public Event findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public List<Event> findAll() {
        return  eventRepository.findAll();
    }
}
