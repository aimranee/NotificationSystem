package com.adria.notificationsystem.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notifiaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sender;
    @ManyToOne
    private Event event;
    @ManyToOne
    private Recipient recipient;

}
