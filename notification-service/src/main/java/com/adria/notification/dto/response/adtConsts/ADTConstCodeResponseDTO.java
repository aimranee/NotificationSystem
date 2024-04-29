package com.adria.notification.dto.response.adtConsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ADTConstCodeResponseDTO {
    private UUID id;
    private String name;
    private String code;
}
