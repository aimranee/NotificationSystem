package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.model.entities.Recipient;

public interface IRecipientService {

    Recipient save (RecipientRequestDto eventRequestDto);
    Recipient update (RecipientRequestDto recipient);
    void delete (RecipientRequestDto recipient);
    Recipient findByEmail (String email);

}
