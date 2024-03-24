package com.adria.notification.services;

import com.adria.notification.dto.response.MailConfigResponseDto;

public interface IMailConfigurationService {
    MailConfigResponseDto getMailConfigurationDto();
    MailConfigResponseDto updateMailConfiguration(MailConfigResponseDto newConfig);
}
