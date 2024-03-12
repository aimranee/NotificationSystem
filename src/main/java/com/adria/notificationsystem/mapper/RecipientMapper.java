package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.RecipientResponseDto;
import com.adria.notificationsystem.models.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientResponseDto toDto(Recipient recipient);

    Recipient toEntity(RecipientRequestDto recipientDto);
}
