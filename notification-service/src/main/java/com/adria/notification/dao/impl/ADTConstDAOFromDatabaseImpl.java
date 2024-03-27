package com.adria.notification.dao.impl;

import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.models.enums.ADTConstCode;
import com.adria.notification.models.enums.error.ErrorCode;
import com.adria.notification.exceptions.ResourceNotFoundException;
import com.adria.notification.repositories.ADTConstRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ADTConstDAOFromDatabaseImpl implements IADTConstDAO {

    private final ADTConstRepository adtConstRepository;

    @Override
    public boolean existsByCode(ADTConstCode code) {

        return adtConstRepository.existsByCode(code);

    }

    @Override
    public ADTConst save(ADTConst adtConst) {

        return adtConstRepository.save(adtConst);

    }

    @Override
    public ADTConst findById(UUID id) {

        return adtConstRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ADT_CONST_NOT_FOUND_ID));

    }

    @Override
    public ADTConst findADTConstByCode(ADTConstCode code) {

        return adtConstRepository.findADTConstByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ADT_CONST_NOT_FOUND_CODE));

    }

    @Override
    public List<ADTConst> findAll() {

        return new ArrayList<>(adtConstRepository.findAllByCodeIn(Arrays.asList(ADTConstCode.values())));

    }

    @Override
    public String getADTConstValueByCode(ADTConstCode code) {

        ADTConst adtConst = adtConstRepository.findADTConstByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ADT_CONST_NOT_FOUND_CODE));

        return adtConst.getValue();

    }

}
