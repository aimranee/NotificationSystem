package com.adria.keycloakManagement.service;

import com.adria.keycloakManagement.dto.ClientAppDTO;
import com.adria.keycloakManagement.dto.ClientCredentialsDto;
import com.adria.keycloakManagement.dto.CreateClientAppDto;
import com.adria.keycloakManagement.dto.UserCredentialsDto;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import org.keycloak.representations.idm.ClientRepresentation;

import java.util.List;
import java.util.UUID;

public interface KeycloakService {

    String getTokenClient(ClientCredentialsDto clientCredentials);

    String getTokenUser(UserCredentialsDto userCredentials);

    ClientResponseDTO createClientApp(CreateClientAppDto clientAppDTO);

    ClientResponseDTO getClientAppByClientId(String clientId);

    ClientResponseDTO getClientAppByKeycloakId(String appId);

    List<ClientResponseDTO> getClientsApp();

    ClientResponseDTO getClientAppById(UUID id);

//    String getByRefreshToken(String refreshToken);

    void logoutUser(String userId);

    void resetPassword(String newPassword, String userId);

    void deleteClient(String clientId);

    void updateClient(ClientAppDTO clientAppDTO);

}
