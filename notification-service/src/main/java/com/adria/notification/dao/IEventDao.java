package com.adria.notification.dao;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.models.entities.Event;

public interface IEventDao {
    
    EventResponseDto save (EventRequestDto eventRequestDto);
    EventResponseDto update (EventRequestDto event);
    void delete (EventRequestDto event);
    Event findByType (String type);

}
