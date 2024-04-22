package com.adria.notification.dto.response.adtConsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ADTConstResponseDTO {

    private UUID id;
    private String code;
    private String providerName;
    private String value;
    private boolean encrypted;
    private Date createdDate;
    private Date modifiedDate;
}
