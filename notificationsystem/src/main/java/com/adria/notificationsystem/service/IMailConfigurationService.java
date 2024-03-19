package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.response.MailConfigResponseDto;

public interface IMailConfigurationService {
    MailConfigResponseDto getMailConfigurationDto();
    MailConfigResponseDto updateMailConfiguration(MailConfigResponseDto newConfig);
}
