package com.adria.notification.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDto {

    private UUID id;
    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}
