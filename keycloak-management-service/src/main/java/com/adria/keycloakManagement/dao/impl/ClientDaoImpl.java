package com.adria.keycloakManagement.dao.impl;

import com.adria.keycloakManagement.dao.ClientDao;
import com.adria.keycloakManagement.model.Client;
import com.adria.keycloakManagement.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(String clientId) {
        return clientRepository.findByClientId(clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(String clientId, Client client) {

    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
