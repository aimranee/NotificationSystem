package com.adria.notification.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceToken extends AbstractEntity{
    private String token;
    @OneToOne
    private Recipient recipient;
    private LocalDateTime expirationDate;
}
