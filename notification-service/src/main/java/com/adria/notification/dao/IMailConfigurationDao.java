package com.adria.notification.dao;

import com.adria.notification.models.entities.MailConfiguration;

public interface IMailConfigurationDao {

    public MailConfiguration getMailConfiguration();

    public MailConfiguration updateMailConfiguration(MailConfiguration newConfig);
}
