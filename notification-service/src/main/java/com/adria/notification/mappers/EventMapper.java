package com.adria.notification.mappers;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.models.entities.Event;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EventMapper {

    EventRequestDto toDto(Event event);

    EventResponseDto toResponseDto(Event event);

    Event toEntity(EventRequestDto eventDto);

    List<EventResponseDto> toDtoList(List<Event> events);
}
