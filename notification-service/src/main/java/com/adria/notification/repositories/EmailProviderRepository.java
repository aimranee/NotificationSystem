package com.adria.notification.repositories;

import com.adria.notification.models.entities.EmailProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailProviderRepository extends JpaRepository<EmailProvider, Long> {
    EmailProvider findByName(String name);
    boolean existsByName(String name);

}
