package com.adria.notification.dao;

import com.adria.notification.model.entities.MailConfiguration;

public interface IMailConfigurationDao {

    public MailConfiguration getMailConfiguration();

    public MailConfiguration updateMailConfiguration(MailConfiguration newConfig);
}
