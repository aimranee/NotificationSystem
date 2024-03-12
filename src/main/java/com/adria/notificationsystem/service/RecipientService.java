package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.dto.response.RecipientResponseDto;
import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.Recipient;

public interface RecipientService {

    Recipient save (RecipientRequestDto eventRequestDto);
    Recipient update (RecipientRequestDto recipient);
    void delete (RecipientRequestDto recipient);
    Recipient findByEmail (String email);

}
