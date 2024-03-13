package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.RecipientResponseDto;
import com.adria.notificationsystem.model.Recipient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientRequestDto toDto(Recipient recipient);

    Recipient toEntity(RecipientRequestDto recipientDto);
}
