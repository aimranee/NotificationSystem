package com.adria.notificationsystem.mapper;

import com.adria.notificationsystem.dto.request.preferences.PreferencesRequestDto;
import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notificationsystem.model.entities.Preferences;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PreferencesMapper {
    @Mapping(target = "recipientEmail", source = "recipient.email")
    @Mapping(target = "eventType", source = "event.type")
    PreferencesRequestDto toDto(Preferences preferences);

    @Mapping(source = "recipientEmail", target = "recipient.email")
    @Mapping(source = "eventType", target = "event.type")
    Preferences toEntity(PreferencesRequestDto preferencesRequestDto);

    @Mapping(target = "recipientEmail", source = "recipient.email")
    @Mapping(target = "eventType", source = "event.type")
    SavePreferencesResponseDto toSaveDto(Preferences preferences);

    @Mapping(source = "recipientEmail", target = "recipient.email")
    @Mapping(source = "eventType", target = "event.type")
    Preferences toSaveEntity(SavePreferencesRequestDto preferencesRequestDto);
}
