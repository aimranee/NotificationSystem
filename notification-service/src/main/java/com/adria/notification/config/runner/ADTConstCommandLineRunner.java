package com.adria.notification.config.runner;

import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

import javax.transaction.Transactional;

@Transactional
@Order(1)
@Data
@Lazy
@Configuration("adtConstRunner")
public class ADTConstCommandLineRunner implements CommandLineRunner {

    private final IADTConstDAO adtConstDAO;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private Integer port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.protocol}")
    private String transportProtocol;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private Boolean smtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private Boolean enableSmtpStartTls;

    @Value("${spring.mail.properties.mail.smtp.ssl.trust}")
    private String smtpSslTrust;

    public ADTConstCommandLineRunner(IADTConstDAO adtConstDAO) {
        this.adtConstDAO = adtConstDAO;
    }

    @Override
    public void run(String... args) {

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_HOST)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_HOST).value(host).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PORT)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PORT).value(port.toString()).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_USERNAME)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_USERNAME).value(username).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PASSWORD)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PASSWORD).value(password).build());

        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PROTOCOL)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PROTOCOL).value(transportProtocol).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_AUTH)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_AUTH).value(smtpAuth.toString()).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE).value(enableSmtpStartTls.toString()).build());
        }

        if (!adtConstDAO.existsByCode(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_SSL_TRUST)) {
            adtConstDAO.save(ADTConst.builder().code(ADTConstCode.MAIL_PROPERTIES_MAIL_SMTP_SSL_TRUST).value(smtpSslTrust).build());
        }

    }
}
