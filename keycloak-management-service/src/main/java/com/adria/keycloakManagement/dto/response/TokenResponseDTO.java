package com.adria.keycloakManagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDTO {

    @JsonProperty("access_token")
    private String accessToken;
}
