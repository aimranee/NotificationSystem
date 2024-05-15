package com.adria.keycloakManagement.repository;

import com.adria.keycloakManagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findByClientId(String clientId);
}
