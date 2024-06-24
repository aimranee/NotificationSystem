package com.adria.notification.dto.request.emailProvider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmailProviderRequestDTO {

    @NotEmpty
    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String mailHost;
    @NotEmpty
    private String mailPort;
    @NotEmpty
    private String mailUsername;
    @NotEmpty
    private String mailPassword;
    @NotEmpty
    private String mailProtocol;
    private boolean smtpAuth;
    private boolean starttlsEnable;
    private String sslTrust;
    private String clientAppId;

}
