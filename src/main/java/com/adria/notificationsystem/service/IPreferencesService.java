package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.GetPreferencesResponseDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;

import java.util.List;

public interface IPreferencesService {

    List<SavePreferencesResponseDto> save(List<SavePreferencesRequestDto> preferences);
    List<GetPreferencesResponseDto> findAll();
}
