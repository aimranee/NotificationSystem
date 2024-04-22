package com.adria.notification.services;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.request.UpdateEventDto;
import com.adria.notification.dto.response.EventResponseDto;

import java.util.List;
import java.util.UUID;

public interface IEventService {

    EventRequestDto save(EventRequestDto event);
    EventResponseDto update(UpdateEventDto event);
    void delete(UUID id);
    List<EventResponseDto> findAll();
    EventResponseDto findByName(String name);
    EventResponseDto findById(UUID id);
}
