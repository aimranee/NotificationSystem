package com.adria.notification.services;

import com.adria.notification.dto.request.UrlRequestDto;
import com.adria.notification.dto.response.UrlResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "urlshortening-service")
@Component
public interface IUrlService {
    @PostMapping(path = "/generate")
    ResponseEntity<UrlResponseDto> generateShortLink(@RequestBody UrlRequestDto urlRequestDto);
}
