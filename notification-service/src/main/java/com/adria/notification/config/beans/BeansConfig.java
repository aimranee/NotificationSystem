package com.adria.notification.config.beans;

import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfig {

    private final IADTConstDAO adtConstDao;

    @Bean("secretKey")
    public ADTConst getSecretKey() {

        if (!adtConstDao.existsByCode(ADTConstCode.SECRET_KEY)) {
            return adtConstDao.save(ADTConst
                    .builder()
                    .code(ADTConstCode.SECRET_KEY)
                    .value("anNrc2xqdWhkbmVoeWRoag==")
                    .build());
        }else{
            return adtConstDao.findADTConstByCode(ADTConstCode.SECRET_KEY);
        }
    }

}
