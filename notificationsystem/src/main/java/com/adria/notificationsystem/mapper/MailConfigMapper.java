package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.MailConfigRequestDto;
import com.adria.notificationsystem.dto.response.MailConfigResponseDto;
import com.adria.notificationsystem.model.entities.MailConfiguration;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface MailConfigMapper {
    MailConfigResponseDto toDto (MailConfiguration mailConfiguration);

    MailConfiguration toEntity (MailConfigRequestDto mailConfigDto);

    MailConfiguration toSaveEntity (MailConfigResponseDto mailConfigDto);
}
