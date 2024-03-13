package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import com.adria.notificationsystem.model.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    Email toEntity(EmailRequestDto requestDTO);

    EmailResponseDto toDTO(Email email);

}
