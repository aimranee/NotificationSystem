package com.adria.configuration.enums;

import lombok.Getter;

@Getter
public enum ADTConstCode {

    MAIL_HOST("mail-host"),
    MAIL_PORT("mail-port"),
    MAIL_PROTOCOL("mail-protocol"),
    MAIL_USERNAME("mail-username"),
    MAIL_PASSWORD("mail-password"),
    MAIL_PROPERTIES_MAIL_SMTP_AUTH("mail-properties-mail-smtp-auth"),
    MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE("mail-properties-mail-smtp-starttls-enable"),
    MAIL_PROPERTIES_MAIL_SMTP_SSL_TRUST("mail-properties-mail-smtp-ssl-trust");

    private final String propertyKey;

    ADTConstCode(String propertyKey) {
        this.propertyKey = propertyKey;
    }

}
