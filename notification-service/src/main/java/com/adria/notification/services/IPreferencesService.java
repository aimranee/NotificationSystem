package com.adria.notification.services;

import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.preferences.PreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;

import java.util.List;

public interface IPreferencesService {

    List<SavePreferencesResponseDto> saveAll(SavePreferencesRequestDto preferences);
    List<PreferencesResponseDto> findAll();
    List<PreferencesResponseDto> findByRecipientEmail(String recipientEmail);
}
