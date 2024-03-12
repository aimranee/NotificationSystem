package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.models.Event;

public interface EventService {
    EventResponseDto save (EventRequestDto eventRequestDto);
    EventResponseDto update (EventRequestDto event);
    void delete (EventRequestDto event);
    Event findByEventType (String eventType);

}
