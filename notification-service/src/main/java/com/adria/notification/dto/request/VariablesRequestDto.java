package com.adria.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariablesRequestDto {

    private String name;
    private String value;

}
