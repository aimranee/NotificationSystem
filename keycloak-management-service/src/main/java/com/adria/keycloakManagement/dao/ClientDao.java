package com.adria.keycloakManagement.dao;

import com.adria.keycloakManagement.model.Client;

import java.util.List;

public interface ClientDao {
    Client createClient(Client client);
    Client getClient(String clientId);
    List<Client> getAllClients();
    void updateClient(String clientId, Client client);
    void deleteClient(Client client);
}
