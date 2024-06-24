package com.adria.keycloakManagement.dao.impl;

import com.adria.keycloakManagement.dao.ClientDao;
import com.adria.keycloakManagement.model.ClientApp;
import com.adria.keycloakManagement.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepository clientRepository;

    @Override
    public ClientApp createClient(ClientApp clientApp) {
        return clientRepository.save(clientApp);
    }

    @Override
    public ClientApp getClientByClientId(String clientId) {
        return clientRepository.findByClientId(clientId);
    }

    @Override
    public ClientApp getClientByKeycloakId(String appId) {
        return clientRepository.findByClientKeycloakId(appId);
    }

    @Override
    public ClientApp getClientById(UUID id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientApp getClientByClientKeycloakId(String clientKeycloakId) {
        return clientRepository.findByClientKeycloakId(clientKeycloakId);
    }

    @Override
    public List<ClientApp> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(ClientApp clientApp) {
        clientRepository.save(clientApp);
    }

    @Override
    public void deleteClient(ClientApp clientApp) {
        clientRepository.delete(clientApp);
    }
}
