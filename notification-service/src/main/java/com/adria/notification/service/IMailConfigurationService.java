package com.adria.notification.service;

import com.adria.notification.dto.response.MailConfigResponseDto;

public interface IMailConfigurationService {
    MailConfigResponseDto getMailConfigurationDto();
    MailConfigResponseDto updateMailConfiguration(MailConfigResponseDto newConfig);
}
