package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.NotificationSysRequestDto;
import com.adria.notificationsystem.models.NotificationSys;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificationSysMapper {

    NotificationSys toEntity(NotificationSysRequestDto notificationSysDto);

    NotificationSysRequestDto toDto(NotificationSys notificationSys);

}
