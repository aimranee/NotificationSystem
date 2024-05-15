package com.adria.keycloakManagement.service;

import com.adria.keycloakManagement.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client getClient(String clientId);
    List<Client> getAllClients();
    Client updateClient(String clientId, Client client);
    void deleteClient(String clientId);
}
