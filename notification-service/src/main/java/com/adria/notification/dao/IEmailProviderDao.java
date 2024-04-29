package com.adria.notification.dao;

import com.adria.notification.models.entities.EmailProvider;

import java.util.List;

public interface IEmailProviderDao {

    EmailProvider getEmailProviderByName(String name);

    EmailProvider updateEmailProvider(EmailProvider emailProvider);

    EmailProvider saveEmailProvider(EmailProvider emailProvider);

    List<EmailProvider> getAllEmailProvider();
}
