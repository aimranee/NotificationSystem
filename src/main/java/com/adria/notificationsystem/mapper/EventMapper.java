package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventRequestDto toDto(Event event);

    Event toEntity(EventRequestDto eventDto);
}
