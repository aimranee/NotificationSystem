package com.adria.notification.dto.request.adtConsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateADTConstRequestDTO {

    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String value;
    private Boolean encrypted;

}
