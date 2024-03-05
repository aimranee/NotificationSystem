package com.adria.notificationsystem.repository;

import com.adria.notificationsystem.models.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Integer> {
    Recipient findById(int id);
}
