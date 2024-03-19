package com.adria.notificationsystem.controllers;

import com.adria.notificationsystem.dto.response.MailConfigResponseDto;
import com.adria.notificationsystem.service.IMailConfigurationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailConfigController {

    private IMailConfigurationService mailConfigurationService;

    @GetMapping("/config")
    public MailConfigResponseDto getMailConfiguration() {
        return mailConfigurationService.getMailConfigurationDto();
    }

    @PutMapping("/config")
    public MailConfigResponseDto updateMailConfig(@RequestBody MailConfigResponseDto newConfigDTO) {
        return mailConfigurationService.updateMailConfiguration(newConfigDTO);
    }

}
