package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipient extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String token;

}
