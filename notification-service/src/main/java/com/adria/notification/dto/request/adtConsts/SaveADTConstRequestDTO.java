package com.adria.notification.dto.request.adtConsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveADTConstRequestDTO {

    private String code;

    private String value;

    private Boolean encrypted;

}
