package com.adria.keycloakManagement.mapper;

import com.adria.keycloakManagement.dto.ClientDTO;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.model.Client;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientDTO clientDto);
    ClientResponseDTO toResponseDto(Client client);
}
