package com.adria.notification.dao;

import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.models.entities.Recipient;

public interface IRecipientDao {

    Recipient save (RecipientRequestDto eventRequestDto);
    Recipient update (RecipientRequestDto recipient);
    void delete (RecipientRequestDto recipient);
    Recipient findByEmail (String email);

    Recipient findByPhone (String email);

}
