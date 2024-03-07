package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.EventTypeRequestDto;
import com.adria.notificationsystem.models.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventTypeMapper {

    EventTypeRequestDto toDto(EventType eventType);

    EventType toEntity(EventTypeRequestDto eventTypeDto);
}
