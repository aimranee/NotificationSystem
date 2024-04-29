package com.adria.notification.services.impl;

import com.adria.notification.dao.IEventDao;
import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.event.UpdateEventDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.mappers.EventMapper;
import com.adria.notification.models.entities.Event;
import com.adria.notification.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IEventServiceImpl implements IEventService {

    private final IEventDao eventDao;

    private final EventMapper eventMapper;

    @Override
    public EventRequestDto save(EventRequestDto event) {
        Event eventEntity = eventDao.save(eventMapper.toEntity(event));
        return eventMapper.toDto(eventEntity);
    }

    @Override
    public EventResponseDto update(UpdateEventDto event) {
        Event eventEntity = eventDao.update(eventMapper.toUpdateEntity(event));
        return eventMapper.toResponseDto(eventEntity);
    }

    @Override
    public void delete(UUID id) {
        Event event = eventDao.findById(id);
        eventDao.delete(event);
    }

    @Override
    public List<EventResponseDto> findAll() {
        List<Event> events = eventDao.findAll();
        return eventMapper.toDtoList(events);
    }

    @Override
    public EventResponseDto findByName(String name) {
        Event event = eventDao.findByName(name);
        return eventMapper.toResponseDto(event);
    }

    @Override
    public EventResponseDto findById(UUID id) {
        Event event = eventDao.findById(id);
        return eventMapper.toResponseDto(event);
    }
}
