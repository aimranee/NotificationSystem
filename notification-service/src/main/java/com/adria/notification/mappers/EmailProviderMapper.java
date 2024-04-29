package com.adria.notification.mappers;

import com.adria.notification.dto.request.emailProvider.SaveEmailProviderRequestDTO;
import com.adria.notification.dto.request.emailProvider.UpdateEmailProviderRequestDTO;
import com.adria.notification.dto.response.EmailProviderResponseDto;
import com.adria.notification.models.entities.EmailProvider;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EmailProviderMapper {
    EmailProviderResponseDto toDto (EmailProvider emailProvider);

    EmailProvider toSaveEntity (SaveEmailProviderRequestDTO emailProviderDto);

    EmailProvider toUpdateEntity (UpdateEmailProviderRequestDTO emailProviderDto);

    List<EmailProviderResponseDto> toListDtos (List<EmailProvider> emailProviders);
}
