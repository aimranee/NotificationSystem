package com.adria.notification.mappers;

import com.adria.notification.dto.request.adtConsts.SaveADTConstRequestDTO;
import com.adria.notification.dto.request.adtConsts.UpdateADTConstRequestDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstCodeResponseDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstResponseDTO;
import com.adria.notification.models.entities.ADTConst;
import org.mapstruct.*;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ADTConstMapper {

    ADTConstResponseDTO toConstDTO(ADTConst adtConst);

    ADTConst toEntity(SaveADTConstRequestDTO saveAdtConstRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "code", ignore = true)
    void toEntity(@MappingTarget ADTConst adtConst, UpdateADTConstRequestDTO editADTConstRequestDTO);

    List<ADTConstResponseDTO> toListADTConstDTO(List<ADTConst> adtConstList);

    List<ADTConstCodeResponseDTO> toListADTConstCodeDTO(List<ADTConst> adtConstList);

    ADTConstCodeResponseDTO toConstCodeDTO(ADTConst adtConst);

}
