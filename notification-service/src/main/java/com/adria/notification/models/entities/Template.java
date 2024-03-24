package com.adria.notification.models.entities;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Template extends AbstractEntity{

    private String subject;
    private String body;
//    private enum ;

}
