package com.adria.notification.config;

import com.adria.notification.config.security.EncryptionSecurity;
import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.models.entities.ADTConst;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailSenderConfig {

    private final IADTConstDAO adtConstDAO;
    private final EncryptionSecurity encryptionSecurity;

    @Bean
    @RefreshScope
    public JavaMailSender emailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        List<ADTConst> adtConstList = adtConstDAO.findAll();
        Properties javaMailProperties = mailSender.getJavaMailProperties();
        String secretKey = "";

        for (ADTConst constant : adtConstList) {
            switch (constant.getCode().toString()) {
                case "SECRET_KEY":
                    secretKey = constant.getValue();
                    break;
                case "MAIL_HOST":
                    mailSender.setHost(constant.getValue());
                    break;
                case "MAIL_PORT":
                    mailSender.setPort(Integer.parseInt(constant.getValue()));
                    break;
                case "MAIL_USERNAME":
                    mailSender.setUsername(constant.getValue());
                    break;
                case "MAIL_PASSWORD":
                    mailSender.setPassword(encryptionSecurity.decryptSecret(constant.getValue(), secretKey));
                    break;
                case "MAIL_PROTOCOL":
                    mailSender.setProtocol(constant.getValue());
                    break;
                case "MAIL_PROPERTIES_MAIL_SMTP_AUTH":
                    javaMailProperties.put("mail.smtp.auth", Boolean.parseBoolean(constant.getValue()));
                    break;
                case "MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE":
                    javaMailProperties.put("mail.smtp.starttls.enable", Boolean.parseBoolean(constant.getValue()));
                    break;
                case "MAIL_PROPERTIES_MAIL_SMTP_SSL_TRUST":
                    javaMailProperties.put("mail.smtp.ssl.trust", constant.getValue());
                    break;
                default:
                    // Handle unknown constant codes
                    break;
            }
        }

        return mailSender;
    }

}
