package com.adria.notificationsystem.config;

import com.adria.notificationsystem.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfig {

    private final MailProperties mailProperties;

    public MailSenderConfig(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }
    @Bean
    public JavaMailSender emailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());

        Properties javaMailProperties = mailSender.getJavaMailProperties();
        javaMailProperties.put("mail.smtp.auth", mailProperties.getSmtpAuth());
        javaMailProperties.put("mail.protocol", mailProperties.getTransportProtocol());
        javaMailProperties.put("mail.smtp.starttls.enable", mailProperties.getEnableSmtpStartTls());
        javaMailProperties.put("mail.smtp.ssl.trust", mailProperties.getSmtpSslTrust());

        return mailSender;
    }

}
