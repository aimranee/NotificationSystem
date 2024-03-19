package com.adria.notificationsystem.dao.impl;

import com.adria.notificationsystem.dao.IMailConfigurationDao;
import com.adria.notificationsystem.model.entities.MailConfiguration;
import com.adria.notificationsystem.repository.MailConfigurationRepository;
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
