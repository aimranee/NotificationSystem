package com.adria.notification.services;

import com.adria.notification.dto.request.adtConsts.SaveADTConstRequestDTO;
import com.adria.notification.dto.request.adtConsts.UpdateADTConstRequestDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstCodeResponseDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstResponseDTO;

import java.util.List;

public interface IADTConstService {

    ADTConstResponseDTO getADTConstById(String id);

    List<ADTConstResponseDTO> getAllADTConst();

    ADTConstResponseDTO saveADTConst(SaveADTConstRequestDTO saveAdtConstRequestDTO);

    ADTConstResponseDTO updateADTConst(UpdateADTConstRequestDTO updateADTConstRequestDTO);

    List<ADTConstCodeResponseDTO> getAllADTConstCodes();

}
