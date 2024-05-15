package com.adria.keycloakManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.keycloak.representations.idm.ClientRepresentation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String clientId;
    private String name;
    private boolean enabled;
    private String clientSecret;

}