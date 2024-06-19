package com.adria.notification.services.impl;

import com.adria.notification.dao.IPreferenceTokenDao;
import com.adria.notification.dto.response.PreferenceTokenDto;
import com.adria.notification.mappers.PreferenceTokenMapper;
import com.adria.notification.services.IPreferenceTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class IPreferenceTokenServiceImpl implements IPreferenceTokenService {

    private final IPreferenceTokenDao preferenceTokenDao;
    private final PreferenceTokenMapper preferenceTokenMapper;
    @Override
    public PreferenceTokenDto findByToken(String token) {
        return preferenceTokenMapper.toDto(preferenceTokenDao.findByToken(token));
    }
}
