package com.adria.keycloakManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class EmailProviderResponseDto {

    private UUID id;
    private String name;
    private String mailProtocol;
    private boolean smtpAuth;
    private boolean starttlsEnable;
    private String sslTrust;
    private String mailHost;
    private String mailPort;
    private String mailUsername;
    private String mailPassword;
    private String clientAppId;

}
