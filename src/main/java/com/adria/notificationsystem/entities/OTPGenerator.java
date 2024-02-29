package com.adria.notificationsystem.entities;


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
public class OTPGenerator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int otpLength;
    private int otpExpiration;
    private String otpAlgo;

    public String generator(String otpAlgo, int otpLength, int otpExpiration){
        return null;
    }

}
