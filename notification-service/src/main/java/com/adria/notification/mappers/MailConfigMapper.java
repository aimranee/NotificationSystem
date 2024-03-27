package com.adria.notification.mappers;

import com.adria.notification.dto.request.MailConfigRequestDto;
import com.adria.notification.dto.response.MailConfigResponseDto;
import com.adria.notification.models.entities.MailConfiguration;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface MailConfigMapper {
    MailConfigResponseDto toDto (MailConfiguration mailConfiguration);

    MailConfiguration toEntity (MailConfigRequestDto mailConfigDto);

    MailConfiguration toSaveEntity (MailConfigResponseDto mailConfigDto);
}
