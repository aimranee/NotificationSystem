package com.adria.notification.config.runner;

import com.adria.notification.config.security.EncryptionSecurity;
import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.transaction.Transactional;

@Transactional
@Configuration("adtConstEncryptionRunner")
@Order(2)
@RequiredArgsConstructor
public class ADTConstEncryptionCommandLineRunner implements CommandLineRunner {

    private final IADTConstDAO adtConstDAO;
    private final EncryptionSecurity encryptionSecurity;

    @Override
    public void run(String... args) {

        ADTConst mailPasswordConst = adtConstDAO.findADTConstByCode(ADTConstCode.MAIL_PASSWORD);
        ADTConst secretKey = adtConstDAO.findADTConstByCode(ADTConstCode.SECRET_KEY);
        if (mailPasswordConst == null || mailPasswordConst.isEncrypted()) {
            return;
        }

        String encryptedPassword = encryptionSecurity.encryptSecret(mailPasswordConst.getValue(), secretKey.getValue());

        mailPasswordConst.setValue(encryptedPassword);
        mailPasswordConst.setEncrypted(true);

        adtConstDAO.save(mailPasswordConst);

    }

}
