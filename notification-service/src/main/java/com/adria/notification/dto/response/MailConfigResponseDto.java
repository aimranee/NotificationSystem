package com.adria.notification.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class MailConfigResponseDto {

    private UUID uuid;
    private String protocol;
    private boolean auth;
    private boolean starttlsEnable;
    private String sslTrust;
    private String host;
    private int port;
    private String username;
    private String password;

}
