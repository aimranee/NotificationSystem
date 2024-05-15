package com.adria.keycloakManagement.service;

import com.adria.keycloakManagement.dto.ClientDTO;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.model.UserCredentials;
import org.keycloak.representations.idm.ClientRepresentation;

import java.util.List;

public interface KeycloakService {

    String getToken(UserCredentials userCredentials);

    ClientResponseDTO createClient(ClientDTO clientDTO);

    List<ClientRepresentation> getClients();

    String getByRefreshToken(String refreshToken);

    void logoutUser(String userId);

    void resetPassword(String newPassword, String userId);

}
