package com.adria.keycloakManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCredentialsDto {
    private String clientId;
    private String clientSecret;
}
