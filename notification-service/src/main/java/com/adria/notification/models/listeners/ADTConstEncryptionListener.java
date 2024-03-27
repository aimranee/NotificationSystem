package com.adria.notification.models.listeners;

import com.adria.notification.config.security.EncryptionSecurity;
import com.adria.notification.models.entities.ADTConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component
public class ADTConstEncryptionListener {

    private EncryptionSecurity encryptionSecurity;

    private ADTConst secretKey;

    @Autowired
    public void setPinKey(@Qualifier("secretKey") @Lazy ADTConst secretKey) {
        this.secretKey = secretKey;
    }


    @Autowired
    public void setEncryptionSecurity(EncryptionSecurity encryptionSecurity) {
        this.encryptionSecurity = encryptionSecurity;
    }

    @PrePersist
    @PreUpdate
    public void encryptSecret(Object pc) {

        if (!(pc instanceof ADTConst))
            return;

        ADTConst adtConst = (ADTConst) pc;

        if (adtConst.isEncrypted()) {

            String adtConstValue = adtConst.getValue();

            if (!StringUtils.isBlank(adtConstValue)) {

                adtConst.setValue(encryptionSecurity.encryptSecret(adtConstValue, secretKey.getValue()));

            }

        }

    }

    @PostPersist
    @PostLoad
    @PostUpdate
    public void decryptSecret(Object pc) {

        if (!(pc instanceof ADTConst))
            return;

        ADTConst adtConst = (ADTConst) pc;

        if (adtConst.isEncrypted()) {

            String adtConstValue = adtConst.getValue();

            if (!StringUtils.isBlank(adtConstValue)) {

                adtConst.setValue(encryptionSecurity.decryptSecret(adtConstValue, secretKey.getValue()));

            }

        }

    }

}
