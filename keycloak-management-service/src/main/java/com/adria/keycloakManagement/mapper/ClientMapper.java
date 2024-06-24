package com.adria.keycloakManagement.mapper;

import com.adria.keycloakManagement.dto.ClientAppDTO;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.model.ClientApp;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ClientMapper {
    ClientApp toEntity(ClientAppDTO clientAppDto);
    ClientApp toResponseEntity(ClientResponseDTO clientResponseDto);
    ClientResponseDTO toResponseDto(ClientApp clientApp);
    List<ClientResponseDTO> toResponseDtoList(List<ClientApp> clientApps);
}
