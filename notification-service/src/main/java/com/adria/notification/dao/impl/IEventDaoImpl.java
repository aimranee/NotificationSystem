package com.adria.notification.dao.impl;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.mappers.EventMapper;
import com.adria.notification.models.entities.Event;
import com.adria.notification.repositories.EventRepository;
import com.adria.notification.dao.IEventDao;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IEventDaoImpl implements IEventDao {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public EventResponseDto save(EventRequestDto eventRequestDto) {
        Event event = eventMapper.toEntity(eventRequestDto);
        if (eventRepository.existsByType(event.getType())) {
            throw new DataIntegrityViolationException("An event with the same eventType already exists.");
        }
        event = eventRepository.save(event);
        return eventMapper.toResponseDto(event);
    }

    @Override
    public EventResponseDto update(EventRequestDto event) {
        return null;
    }

    @Override
    public void delete(EventRequestDto event) {

    }

    @Override
    public Event findByType(String type) {
        Event event = eventRepository.findByType(type);
        return event;
    }
}
