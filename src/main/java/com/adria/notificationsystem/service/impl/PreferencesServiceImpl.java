package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dao.IEventDao;
import com.adria.notificationsystem.dao.IPreferencesDao;
import com.adria.notificationsystem.dao.IRecipientDao;
import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notificationsystem.mapper.PreferencesMapper;
import com.adria.notificationsystem.model.entities.Preferences;
import com.adria.notificationsystem.service.IPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferencesServiceImpl implements IPreferencesService {

    private final IPreferencesDao preferencesDao;
    private final IEventDao eventDao;
    private final IRecipientDao recipientDao;
    private final PreferencesMapper preferencesMapper;

    @Override
    public SavePreferencesResponseDto save(SavePreferencesRequestDto preferenceDto) {
        if(preferencesDao.existsByEventType(preferenceDto.getEventType())){
            throw new RuntimeException("ErrorCode.CLIENT_COMPANY_NAME_EXISTS");
        }
        Preferences preferences = new Preferences();
        preferences.setEvent(eventDao.findByType(preferenceDto.getEventType()));
        preferences.setRecipient(recipientDao.findByEmail(preferenceDto.getRecipientEmail()));
        preferences = preferencesDao.save(preferences);
        return preferencesMapper.toSaveDto(preferences);
    }
}
