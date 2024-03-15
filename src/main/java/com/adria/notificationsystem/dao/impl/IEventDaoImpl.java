package com.adria.notificationsystem.dao.impl;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.model.entities.Event;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.dao.IEventDao;
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
        return eventMapper.toRespenseDto(event);
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
