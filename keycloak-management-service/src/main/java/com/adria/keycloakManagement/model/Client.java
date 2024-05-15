package com.adria.keycloakManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractEntity{

    @Column(unique = true)
    private String clientId;
    private String name;
    private String clientSecret;
    private boolean enabled;
}
