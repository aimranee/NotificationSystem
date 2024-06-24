package com.adria.keycloakManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAppDTO {

    private String clientId;
    private String name;
    private boolean enabled;
    private String clientSecret;
    private String clientKeycloakId;

}