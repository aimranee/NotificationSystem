package com.adria.notification.dao.impl;

import com.adria.notification.dao.IEmailProviderDao;
import com.adria.notification.models.entities.EmailProvider;
import com.adria.notification.repositories.EmailProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IEmailProviderDaoImpl implements IEmailProviderDao {

    private final EmailProviderRepository emailProviderRepository;

    @Override
    public EmailProvider getEmailProviderByName(String name) {
        return emailProviderRepository.findByName(name);
    }

    @Override
    public EmailProvider updateEmailProvider(EmailProvider emailProvider) {
        return emailProviderRepository.save(emailProvider);
    }

    @Override
    public EmailProvider saveEmailProvider(EmailProvider emailProvider) {
        return emailProviderRepository.save(emailProvider);
    }

    @Override
    public List<EmailProvider> getAllEmailProvider() {
        return emailProviderRepository.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return emailProviderRepository.existsByName(name);
    }
}
