package com.adria.notification.dao.impl;

import com.adria.notification.dao.IMailConfigurationDao;
import com.adria.notification.model.entities.MailConfiguration;
import com.adria.notification.repository.MailConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IMailConfigurationDaoImpl implements IMailConfigurationDao {

    private final MailConfigurationRepository mailConfigurationRepository;

    @Override
    public MailConfiguration getMailConfiguration() {
        return mailConfigurationRepository.findAll().stream().findFirst().orElse(null);
    }

    @Override
    public MailConfiguration updateMailConfiguration(MailConfiguration newConfig) {
        return mailConfigurationRepository.save(newConfig);
    }
}
