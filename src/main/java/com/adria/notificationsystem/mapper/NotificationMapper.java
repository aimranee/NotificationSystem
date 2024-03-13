package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.NotificationDetailDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.model.NotificationSys;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "event.eventType", source = "eventType")
    @Mapping(target = "recipient.email", source = "emailRecipient")
    @Mapping(target = "recipient.phone", source = "phoneRecipient")
    NotificationSys toEntity(NotificationRequestDto requestDto);

    @Mapping(source = "event.eventType", target = "eventType")
    @Mapping(source = "recipient.email", target = "emailRecipient")
    @Mapping(source = "recipient.phone", target = "phoneRecipient")
    NotificationRequestDto toDto(NotificationSys notificationSys);



    @Mapping(source = "event", target = "eventDto")
    @Mapping(source = "recipient", target = "recipientDto")
    NotificationDetailDto toNotificationDto(NotificationSys entity);

    @Mapping(source = "eventDto", target = "event")
    @Mapping(source = "recipientDto", target = "recipient")
    NotificationSys toEntity(NotificationDetailDto dto);
}
