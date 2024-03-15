package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;

public interface IPreferencesService {

    SavePreferencesResponseDto save(SavePreferencesRequestDto preference);
}
