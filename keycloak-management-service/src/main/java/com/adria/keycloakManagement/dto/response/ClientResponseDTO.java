package com.adria.keycloakManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
    private UUID id;
    private String clientId;
    private String name;
    private String clientSecret;
    private String clientKeycloakId;
    private Date createdDate;
    private Date modifiedDate;
    private boolean enabled;
}
