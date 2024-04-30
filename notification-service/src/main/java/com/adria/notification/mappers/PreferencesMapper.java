package com.adria.notification.mappers;

import com.adria.notification.dto.request.preferences.PreferencesRequestDto;
import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.preferences.GetPreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notification.models.entities.Preferences;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PreferencesMapper {
    @Mapping(target = "recipientEmail", source = "recipient.email")
    PreferencesRequestDto toDto(Preferences preferences);

    @Mapping(source = "recipientEmail", target = "recipient.email")
    Preferences toEntity(PreferencesRequestDto preferencesRequestDto);

    @Mapping(target = "recipientEmail", source = "recipient.email")
    SavePreferencesResponseDto toSaveDto(Preferences preferences);

    @Mapping(source = "recipientEmail", target = "recipient.email")
    Preferences toSaveEntity(SavePreferencesRequestDto preferencesRequestDto);

    List<SavePreferencesResponseDto> toSaveListDto(List<Preferences> preferencesList);

    List<Preferences> toListEntity(List<SavePreferencesRequestDto> preferencesRequestDtoList);

    List<GetPreferencesResponseDto> toListDto(List<Preferences> preferencesList);

}
