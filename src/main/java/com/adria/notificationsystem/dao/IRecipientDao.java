package com.adria.notificationsystem.dao;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.model.entities.Recipient;

public interface IRecipientDao {

    Recipient save (RecipientRequestDto eventRequestDto);
    Recipient update (RecipientRequestDto recipient);
    void delete (RecipientRequestDto recipient);
    Recipient findByEmail (String email);

    Recipient findByPhone (String email);

}
