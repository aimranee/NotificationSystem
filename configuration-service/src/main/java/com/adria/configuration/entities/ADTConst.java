package com.adria.configuration.entities;

import com.adria.configuration.enums.ADTConstCode;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adt_consts")
@SuperBuilder(toBuilder = true)
public class ADTConst extends AbstractEntity {

    @Column(unique = true, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ADTConstCode code;

    @Column(nullable = false)
    private String value;

}
