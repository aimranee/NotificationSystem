package com.adria.notification.mappers;

import com.adria.notification.dto.response.PreferenceTokenDto;
import com.adria.notification.models.entities.PreferenceToken;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PreferenceTokenMapper {
    PreferenceTokenDto toDto(PreferenceToken preferenceToken);
    PreferenceToken toEntity(PreferenceTokenDto preferenceTokenDto);
}
