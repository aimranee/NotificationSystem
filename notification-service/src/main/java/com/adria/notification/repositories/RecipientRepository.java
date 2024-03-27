package com.adria.notification.repositories;

import com.adria.notification.models.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Long> {
    Recipient findById(UUID id);
    Recipient findByEmail(String email);
    Recipient findByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
