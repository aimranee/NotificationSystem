package com.adria.notification.mappers;

import com.adria.notification.dto.request.notification.NotificationDetailDto;
import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.models.entities.NotificationSys;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "event.name", source = "eventName")
    @Mapping(target = "recipient.email", source = "emailRecipient")
    @Mapping(target = "recipient.phone", source = "phoneRecipient")
    NotificationSys toEntity(NotificationRequestDto requestDto);

    @Mapping(source = "event.name", target = "eventName")
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
