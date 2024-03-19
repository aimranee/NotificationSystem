package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dao.IMailConfigurationDao;
import com.adria.notificationsystem.dto.request.MailConfigRequestDto;
import com.adria.notificationsystem.dto.response.MailConfigResponseDto;
import com.adria.notificationsystem.mapper.MailConfigMapper;
import com.adria.notificationsystem.service.IMailConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IMailConfigrationServiceImpl implements IMailConfigurationService {

    private final IMailConfigurationDao mailConfigurationDao;
    private final MailConfigMapper mailConfigMapper;

    @Override
    public MailConfigResponseDto getMailConfigurationDto() {
        MailConfigResponseDto configurationDto = mailConfigMapper.toDto(mailConfigurationDao.getMailConfiguration());
        return configurationDto;
    }

    @Override
    public MailConfigResponseDto updateMailConfiguration(MailConfigResponseDto newConfigDto) {

        MailConfigResponseDto mailConfigResponseDto = mailConfigMapper.toDto(mailConfigurationDao.updateMailConfiguration(mailConfigMapper.toSaveEntity(newConfigDto)));

        return mailConfigResponseDto;
    }
}
