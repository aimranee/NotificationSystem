package com.adria.notification.services;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;

import java.util.List;

public interface IEventService {

    EventRequestDto save(EventRequestDto event);
    List<EventResponseDto> findAll();
    EventResponseDto findByName(String name);
}
