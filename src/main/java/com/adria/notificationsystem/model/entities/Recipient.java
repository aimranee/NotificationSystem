package com.adria.notificationsystem.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipient extends AbstractEntity{

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String token;

}