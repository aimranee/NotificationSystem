package com.adria.notification.mappers;

import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.models.entities.Recipient;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface RecipientMapper {
    RecipientRequestDto toDto(Recipient recipient);
    Recipient toEntity(RecipientRequestDto recipientDto);
}
