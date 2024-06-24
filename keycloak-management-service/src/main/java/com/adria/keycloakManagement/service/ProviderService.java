package com.adria.keycloakManagement.service;

import com.adria.keycloakManagement.dto.SaveEmailProviderRequestDTO;
import com.adria.keycloakManagement.dto.response.EmailProviderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "urlshortening-service")
@Component
public interface ProviderService {
    @PostMapping(path = "/api/emailProvider/save")
    ResponseEntity<EmailProviderResponseDto> save(@RequestBody @Valid SaveEmailProviderRequestDTO saveEmailProviderRequestDTO);
}
