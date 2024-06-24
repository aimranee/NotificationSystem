package com.adria.keycloakManagement.dao;

import com.adria.keycloakManagement.model.ClientApp;

import java.util.List;
import java.util.UUID;

public interface ClientDao {
    ClientApp createClient(ClientApp clientApp);
    ClientApp getClientByClientId(String clientId);
    ClientApp getClientByKeycloakId(String appId);
    ClientApp getClientById(UUID id);
    ClientApp getClientByClientKeycloakId(String clientKeycloakId);
    List<ClientApp> getAllClients();
    void updateClient(ClientApp clientApp);
    void deleteClient(ClientApp clientApp);
}
