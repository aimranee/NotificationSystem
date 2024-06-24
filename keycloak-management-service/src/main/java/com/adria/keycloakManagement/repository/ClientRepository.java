package com.adria.keycloakManagement.repository;

import com.adria.keycloakManagement.model.ClientApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientApp, UUID> {
    ClientApp findByClientId(String clientId);
    Optional<ClientApp> findById(UUID id);
    ClientApp findByClientKeycloakId(String clientKeycloakId);
}
