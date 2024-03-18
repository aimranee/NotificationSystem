package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dao.IEventDao;
import com.adria.notificationsystem.dao.IPreferencesDao;
import com.adria.notificationsystem.dao.IRecipientDao;
import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.GetPreferencesResponseDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notificationsystem.mapper.PreferencesMapper;
import com.adria.notificationsystem.model.entities.Preferences;
import com.adria.notificationsystem.service.IPreferencesService;
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
    private final IEventDao eventDao;
    private final IRecipientDao recipientDao;
    private final PreferencesMapper preferencesMapper;

    @Override
    public List<SavePreferencesResponseDto> save(List<SavePreferencesRequestDto> preferencesDto) {
        List<Preferences> preferencesList = new ArrayList<>();
        for (SavePreferencesRequestDto preferenceDto : preferencesDto){
            if(preferencesDao.existsByEventType(preferenceDto.getEventType())){
                throw new RuntimeException("ErrorCode__EXISTS");
            }
            Preferences preferences = new Preferences();
            preferences.setEvent(eventDao.findByType(preferenceDto.getEventType()));
            preferences.setRecipient(recipientDao.findByEmail(preferenceDto.getRecipientEmail()));
            preferencesList.add(preferences);
        }
        preferencesList = preferencesDao.saveAll(preferencesList);
        return preferencesMapper.toSaveListDto(preferencesList);
    }

    @Override
    public List<GetPreferencesResponseDto> findAll() {
        return preferencesMapper.toListDto(preferencesDao.findAll());
    }
}
