package com.adria.notification.services.impl;

import com.adria.notification.dao.IEmailProviderDao;
import com.adria.notification.dto.request.emailProvider.SaveEmailProviderRequestDTO;
import com.adria.notification.dto.request.emailProvider.UpdateEmailProviderRequestDTO;
import com.adria.notification.dto.response.EmailProviderResponseDto;
import com.adria.notification.mappers.EmailProviderMapper;
import com.adria.notification.services.IEmailProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IEmailProviderServiceImpl implements IEmailProviderService {

    private final IEmailProviderDao emailProviderDao;
    private final EmailProviderMapper emailProviderMapper;

    @Override
    public List<EmailProviderResponseDto> getAllEmailProvider() {
        return emailProviderMapper.toListDtos(emailProviderDao.getAllEmailProvider());
    }

    @Override
    public EmailProviderResponseDto saveEmailProvider(SaveEmailProviderRequestDTO saveEmailProviderRequestDTO) {
        return emailProviderMapper.toDto(emailProviderDao.saveEmailProvider(emailProviderMapper.toSaveEntity(saveEmailProviderRequestDTO)));
    }

    @Override
    public EmailProviderResponseDto updateEmailProvider(UpdateEmailProviderRequestDTO updateEmailProviderDTO) {
        return emailProviderMapper.toDto(emailProviderDao.updateEmailProvider(emailProviderMapper.toUpdateEntity(updateEmailProviderDTO)));
    }

    @Override
    public EmailProviderResponseDto getEmailProviderByName(String name) {
        return emailProviderMapper.toDto(emailProviderDao.getEmailProviderByName(name));
    }

    @Override
    public boolean existsByName(String name) {
        return emailProviderDao.existsByName(name);
    }
}
