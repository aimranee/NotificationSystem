package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.models.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventResponseDto toDto(Event event);

    Event toEntity(EventRequestDto eventDto);
}