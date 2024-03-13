package com.adria.notificationsystem.model;

import lombok.*;

import javax.persistence.Entity;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String serial;
    private String password;
    private String email;
}
