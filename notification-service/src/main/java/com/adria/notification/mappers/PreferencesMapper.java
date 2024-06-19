package com.adria.notification.mappers;

import com.adria.notification.dto.request.preferences.PreferencesRequestDto;
import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.preferences.PreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notification.models.entities.Preferences;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PreferencesMapper {
    @Mapping(target = "recipientEmail", source = "recipient.email")
    @Mapping(target = "eventName", source = "event.eventName")
    PreferencesRequestDto toDto(Preferences preferences);

    @Mapping(source = "recipientEmail", target = "recipient.email")
    @Mapping(source = "eventName", target = "event.eventName")
    Preferences toEntity(PreferencesRequestDto preferencesRequestDto);

    @Mapping(target = "recipientEmail", source = "recipient.email")
    @Mapping(target = "eventName", source = "event.eventName")
    SavePreferencesResponseDto toSaveDto(Preferences preferences);

//    @Mapping(source = "recipientEmail", target = "recipient.email")
//    @Mapping(source = "eventName", target = "event.eventName")
//    Preferences toSaveEntity(SavePreferencesRequestDto preferencesRequestDto);

    List<SavePreferencesResponseDto> toSaveListDto(List<Preferences> preferencesList);

    @Mapping(target = "recipientEmail", source = "recipient.email")
    @Mapping(target = "eventName", source = "event.eventName")
    PreferencesResponseDto preferencesToPreferencesResponseDto(Preferences preferences);

    List<PreferencesResponseDto> toListDto(List<Preferences> preferencesList);

}
