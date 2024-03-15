package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.model.entities.Event;

public interface IEventDao {
    
    EventResponseDto save (EventRequestDto eventRequestDto);
    EventResponseDto update (EventRequestDto event);
    void delete (EventRequestDto event);
    Event findByType (String type);

}
