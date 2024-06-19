package com.adria.notification.dao.impl;

import com.adria.notification.dao.IPreferenceTokenDao;
import com.adria.notification.models.entities.PreferenceToken;
import com.adria.notification.repositories.PreferenceTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IPreferenceTokenDaoImpl implements IPreferenceTokenDao {

    private final PreferenceTokenRepository preferenceTokenRepository;
    @Override
    public PreferenceToken findByToken(String token) {
        return preferenceTokenRepository.findByToken(token);
    }
}
