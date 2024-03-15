package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
