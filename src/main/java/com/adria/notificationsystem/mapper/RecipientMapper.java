package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.model.entities.Recipient;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface RecipientMapper {

    RecipientRequestDto toDto(Recipient recipient);

    Recipient toEntity(RecipientRequestDto recipientDto);
}
