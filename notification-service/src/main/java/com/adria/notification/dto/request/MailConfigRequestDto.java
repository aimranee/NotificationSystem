package com.adria.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class MailConfigRequestDto {

    private String protocol;
    private boolean auth;
    private boolean starttlsEnable;
    private String sslTrust;
    private String host;
    private int port;
    private String username;
    private String password;
    
}
