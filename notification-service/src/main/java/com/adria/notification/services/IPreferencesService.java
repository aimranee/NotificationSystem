package com.adria.notification.services;

import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.preferences.GetPreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;

import java.util.List;

public interface IPreferencesService {

    List<SavePreferencesResponseDto> save(List<SavePreferencesRequestDto> preferences);
    List<GetPreferencesResponseDto> findAll();
}
