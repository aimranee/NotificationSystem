package com.adria.notification.services.impl;

import com.adria.notification.dao.IPreferencesDao;
import com.adria.notification.dao.IRecipientDao;
import com.adria.notification.dao.IEventDao;
import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.preferences.PreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notification.mappers.PreferencesMapper;
import com.adria.notification.models.entities.Preferences;
import com.adria.notification.models.entities.Recipient;
import com.adria.notification.services.IPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PreferencesServiceImpl implements IPreferencesService {

    private final IPreferencesDao preferencesDao;
    private final IEventDao templateDao;
    private final IRecipientDao recipientDao;
    private final PreferencesMapper preferencesMapper;

    @Override
    public List<SavePreferencesResponseDto> saveAll(SavePreferencesRequestDto preferencesDto) {
        List<Preferences> preferencesList = new ArrayList<>();
        Recipient recipient = recipientDao.findByEmail(preferencesDto.getRecipientEmail());
        preferencesDao.deleteByRecipientEmail(preferencesDto.getRecipientEmail());
        if (preferencesDto.getEventNames() != null) {
            for (String eventName : preferencesDto.getEventNames()) {
                Preferences preferences = new Preferences();
                preferences.setEvent(templateDao.findByEventName(eventName));
                preferences.setRecipient(recipient);
                preferencesList.add(preferences);
            }
        }
        preferencesList = preferencesDao.saveAll(preferencesList);
        return preferencesMapper.toSaveListDto(preferencesList);
    }

    @Override
    public List<PreferencesResponseDto> findAll() {
        return preferencesMapper.toListDto(preferencesDao.findAll());
    }

    @Override
    public List<PreferencesResponseDto> findByRecipientEmail(String recipientEmail) {
        return preferencesMapper.toListDto(preferencesDao.findByRecipientEmail(recipientEmail));
    }
}
