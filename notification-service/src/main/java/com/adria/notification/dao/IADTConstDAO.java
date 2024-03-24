package com.adria.notification.dao;

import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;

import java.util.List;
import java.util.UUID;

public interface IADTConstDAO {
    boolean existsByCode(ADTConstCode code);

    ADTConst save(ADTConst adtConst);

    ADTConst findById(UUID id);

    ADTConst findADTConstByCode(ADTConstCode code);

    List<ADTConst> findAll();

    String getADTConstValueByCode(ADTConstCode code);
}
