package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.model.entities.MailConfiguration;

public interface IMailConfigurationDao {

    public MailConfiguration getMailConfiguration();

    public MailConfiguration updateMailConfiguration(MailConfiguration newConfig);
}
