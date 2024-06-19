package com.adria.notification.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipient extends AbstractEntity{

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;

}

