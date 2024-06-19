package com.adria.notification.services;

import com.adria.notification.dto.response.PreferenceTokenDto;

public interface IPreferenceTokenService {
    PreferenceTokenDto findByToken(String token);
}
