package com.adria.notification.models.entities;

import com.adria.notification.models.enums.ADTConstCode;
import com.adria.notification.models.listeners.ADTConstEncryptionListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adt_consts")
@SuperBuilder(toBuilder = true)
@EntityListeners(ADTConstEncryptionListener.class)
public class ADTConst extends AbstractEntity {

    @Column(unique = true, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ADTConstCode code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    @ColumnDefault("'0'")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean encrypted;
}
