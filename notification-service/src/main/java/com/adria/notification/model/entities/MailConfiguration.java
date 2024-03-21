package com.adria.notification.model.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class MailConfiguration extends AbstractEntity{

    private String protocol;
    private boolean auth;
    private boolean starttlsEnable;
    private String sslTrust;
    private String host;
    private int port;
    private String username;
    private String password;

}
