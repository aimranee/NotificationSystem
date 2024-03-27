package com.adria.notification.services.impl;

import com.adria.notification.dao.IADTConstDAO;
import com.adria.notification.dto.request.adtConsts.SaveADTConstRequestDTO;
import com.adria.notification.dto.request.adtConsts.UpdateADTConstRequestDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstCodeResponseDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstResponseDTO;
import com.adria.notification.models.entities.ADTConst;
import com.adria.notification.mappers.ADTConstMapper;
import com.adria.notification.services.IADTConstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IADTConstServiceImpl implements IADTConstService {

    private final IADTConstDAO adtConstDAO;

    private final ADTConstMapper adtConstMapper;

    @Override
    public ADTConstResponseDTO getADTConstById(String id) {
        ADTConst adtConst = adtConstDAO.findById(UUID.fromString(id));
        return adtConstMapper.toConstDTO(adtConst);
    }

    @Override
    public List<ADTConstResponseDTO> getAllADTConst() {
        List<ADTConst> adtConstList = adtConstDAO.findAll();
        return adtConstMapper.toListADTConstDTO(adtConstList);
    }

    @Override
    public ADTConstResponseDTO saveADTConst(SaveADTConstRequestDTO createAdtConstRequestDTO) {
        ADTConst adtConst = adtConstMapper.toEntity(createAdtConstRequestDTO);
        return adtConstMapper.toConstDTO(adtConstDAO.save(adtConst));
    }

    @Override
    public ADTConstResponseDTO updateADTConst(UpdateADTConstRequestDTO updateADTConstRequestDTO) {
        ADTConst adtConst = adtConstDAO.findById(UUID.fromString(updateADTConstRequestDTO.getId()));
        adtConstMapper.toEntity(adtConst, updateADTConstRequestDTO);
        adtConst = adtConstDAO.save(adtConst);
        return adtConstMapper.toConstDTO(adtConst);
    }

    @Override
    public List<ADTConstCodeResponseDTO> getAllADTConstCodes() {
        List<ADTConst> adtConstList = adtConstDAO.findAll();
        return adtConstMapper.toListADTConstCodeDTO(adtConstList);
    }

}
