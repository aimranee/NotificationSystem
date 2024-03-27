package com.adria.notification.services.impl;

import com.adria.notification.dao.IMailConfigurationDao;
import com.adria.notification.dto.response.MailConfigResponseDto;
import com.adria.notification.mappers.MailConfigMapper;
import com.adria.notification.services.IMailConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IMailConfigurationServiceImpl implements IMailConfigurationService {

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
