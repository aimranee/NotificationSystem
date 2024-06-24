package com.adria.notification.services;

import com.adria.notification.dto.request.emailProvider.SaveEmailProviderRequestDTO;
import com.adria.notification.dto.request.emailProvider.UpdateEmailProviderRequestDTO;
import com.adria.notification.dto.response.EmailProviderResponseDto;

import java.util.List;

public interface IEmailProviderService {
    List<EmailProviderResponseDto> getAllEmailProvider();
    EmailProviderResponseDto saveEmailProvider(SaveEmailProviderRequestDTO saveEmailProviderRequestDTO);
    EmailProviderResponseDto updateEmailProvider(UpdateEmailProviderRequestDTO updateEmailProviderDTO);
    EmailProviderResponseDto getEmailProviderByName(String name);
    boolean existsByName(String name);
}
