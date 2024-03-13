package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventRequestDto toDto(Event event);

    EventResponseDto toRespenseDto(Event event);

    Event toEntity(EventRequestDto eventDto);
}
