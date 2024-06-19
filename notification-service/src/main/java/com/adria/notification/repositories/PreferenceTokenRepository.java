package com.adria.notification.repositories;

import com.adria.notification.models.entities.PreferenceToken;
import com.adria.notification.models.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PreferenceTokenRepository extends JpaRepository<PreferenceToken, UUID> {
    PreferenceToken findByToken(String token);
    PreferenceToken findByRecipient(Recipient recipient);
}
