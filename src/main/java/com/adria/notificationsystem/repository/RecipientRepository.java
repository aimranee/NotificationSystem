package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.models.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Long> {
    Recipient findByUuid(UUID uuid);
    Recipient findByEmail(String email);
    boolean existsByEmail(String email);
}
