package com.adria.notification.controllers;

import com.adria.notification.dto.response.MailConfigResponseDto;
import com.adria.notification.service.IMailConfigurationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mail")
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
