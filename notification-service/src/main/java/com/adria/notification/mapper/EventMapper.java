package com.adria.notification.mapper;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.model.entities.Event;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EventMapper {

    EventRequestDto toDto(Event event);

    EventResponseDto toResponseDto(Event event);

    Event toEntity(EventRequestDto eventDto);

}
