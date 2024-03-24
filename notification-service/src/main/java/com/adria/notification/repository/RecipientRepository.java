package com.adria.notification.repository;

import com.adria.notification.model.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Long> {
    Recipient findByUuid(UUID uuid);
    Recipient findByEmail(String email);
    Recipient findByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}