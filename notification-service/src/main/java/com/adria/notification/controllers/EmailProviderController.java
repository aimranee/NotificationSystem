package com.adria.notification.controllers;

import com.adria.notification.dto.request.emailProvider.SaveEmailProviderRequestDTO;
import com.adria.notification.dto.request.emailProvider.UpdateEmailProviderRequestDTO;
import com.adria.notification.dto.response.EmailProviderResponseDto;
import com.adria.notification.services.IEmailProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/emailProvider")
public class EmailProviderController {

    private final IEmailProviderService emailProviderService;

    @PostMapping(value = "/save")
    public ResponseEntity<EmailProviderResponseDto> save(@RequestBody @Valid SaveEmailProviderRequestDTO saveEmailProviderRequestDTO) {
        return ResponseEntity.ok()
                .body(emailProviderService.saveEmailProvider(saveEmailProviderRequestDTO));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<EmailProviderResponseDto> update(@RequestBody @Valid UpdateEmailProviderRequestDTO updateEmailProviderRequestDTO) {
        return ResponseEntity.ok()
                .body(emailProviderService.updateEmailProvider(updateEmailProviderRequestDTO));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<EmailProviderResponseDto>> findAll() {
        return ResponseEntity.ok()
                .body(emailProviderService.getAllEmailProvider());
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<EmailProviderResponseDto> findByProviderName(@PathVariable String name) {
        return ResponseEntity.ok()
                .body(emailProviderService.getEmailProviderByName(name));
    }

}
