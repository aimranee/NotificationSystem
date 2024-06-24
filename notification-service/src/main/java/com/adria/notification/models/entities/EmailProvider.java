package com.adria.notification.models.entities;

import com.adria.notification.dto.response.ClientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailProvider extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String mailHost;
    @Column(nullable = false)
    private String mailPort;
    @Column(nullable = false)
    private String mailUsername;
    @Column(nullable = false)
    private String mailPassword;
    @Column(nullable = false)
    private String mailProtocol;
    @Column(nullable = false)
    @ColumnDefault("'0'")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean smtpAuth;
    @Column(nullable = false)
    @ColumnDefault("'0'")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean starttlsEnable;
    @Column(nullable = false)
    private String sslTrust;
    private String clientAppId;
    @Transient
    @ManyToOne
    private ClientResponseDTO clientApp;

}
