package com.adria.keycloakManagement.service.impl;

import com.adria.keycloakManagement.model.Client;
import com.adria.keycloakManagement.repository.ClientRepository;
import com.adria.keycloakManagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return null;
    }

    @Override
    public Client getClient(String clientId) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client updateClient(String clientId, Client client) {
        return null;
    }

    @Override
    public void deleteClient(String clientId) {

    }
}
