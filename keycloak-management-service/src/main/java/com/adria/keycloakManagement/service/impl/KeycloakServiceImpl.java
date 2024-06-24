package com.adria.keycloakManagement.service.impl;

import com.adria.keycloakManagement.dao.ClientDao;
import com.adria.keycloakManagement.dto.*;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.mapper.ClientMapper;
import com.adria.keycloakManagement.service.KeycloakService;
import com.adria.keycloakManagement.service.ProviderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.ClientResource;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    @Value("${keycloak.serverUrl}")
    private String SERVER_URL;

    @Value("${keycloak.realm}")
    private String REALM;

    @Value("${keycloak.username}")
    private String USERNAME;

    @Value("${keycloak.password}")
    private String PASSWORD;

    @Value("${keycloak.clientId}")
    private String CLIENT_ID;

    @Value("${keycloak.clientSecret}")
    private String CLIENT_SECRET;

    private Keycloak getInstance() {
        return KeycloakBuilder.builder().serverUrl(SERVER_URL).realm("master").username(USERNAME).password(PASSWORD).clientId(CLIENT_ID).build();
    }

    public String getTokenClient(ClientCredentialsDto clientCredentials) {

        String responseToken = null;
        try {

            String clientId = clientCredentials.getClientId();
            String clientSecret = clientCredentials.getClientSecret();

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
            urlParameters.add(new BasicNameValuePair("client_id", clientId));
            urlParameters.add(new BasicNameValuePair("client_secret", clientSecret));

            responseToken = sendPostClient(urlParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseToken;

    }

    public String getTokenUser(UserCredentialsDto userCredentials) {

        String responseToken = null;
        try {

            String username = userCredentials.getUsername();
            String password = userCredentials.getPassword();

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "password"));
            urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));

            responseToken = sendPostUser(urlParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseToken;

    }

    @Override
    public ClientResponseDTO createClientApp(CreateClientAppDto clientAppDTO) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        ClientAppDTO clientRequestDTO = new ClientAppDTO();
        ProviderService providerService = null;

        try {

            Keycloak keycloak = getInstance();

            // Get the realm resource
            RealmResource realmResource = keycloak.realm(REALM);

            // Get the clients resource
            ClientsResource clientsResource = realmResource.clients();

            ClientRepresentation client = new ClientRepresentation();
            client.setClientId(clientAppDTO.getClientId());
            client.setName(clientAppDTO.getName());
            client.setEnabled(clientAppDTO.isEnabled());
            client.setServiceAccountsEnabled(true);
            // Create the client
            Response response = clientsResource.create(client);

            if (response.getStatus() == 201) {
                // Extract the ID of the created client from the Location header
                URI location = response.getLocation();
                String clientId = location.getPath().substring(location.getPath().lastIndexOf('/') + 1);
                ClientResource res = clientsResource.get(clientId);
                clientRequestDTO.setClientId(clientAppDTO.getClientId());
                clientRequestDTO.setName(clientAppDTO.getName());
                clientRequestDTO.setEnabled(clientAppDTO.isEnabled());
                clientRequestDTO.setClientKeycloakId(clientId);
                clientRequestDTO.setClientSecret(res.getSecret().getValue());
                clientResponseDTO = clientMapper.toResponseDto(clientDao.createClient(clientMapper.toEntity(clientRequestDTO)));
            } else {
                System.err.println("Failed to create client. Status code: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
        return clientResponseDTO;
    }

//    @Override
//    public String getByRefreshToken(String refreshToken) {
//
//        String responseToken = null;
//        try {
//
//            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//            urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));
//            urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
//            urlParameters.add(new BasicNameValuePair("refresh_token", refreshToken));
//
//            responseToken = sendPost(urlParameters);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return responseToken;
//    }

    public void logoutUser(String userId) {

        UsersResource userRessource = getKeycloakUserResource();
        userRessource.get(userId).logout();

    }

    // Reset passowrd
    public void resetPassword(String newPassword, String userId) {

        UsersResource userResource = getKeycloakUserResource();

        // Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(newPassword.toString().trim());

        // Set password credential
        userResource.get(userId).resetPassword(passwordCred);

    }

    private UsersResource getKeycloakUserResource() {

        Keycloak kc = KeycloakBuilder.builder().serverUrl(SERVER_URL).realm("master").username("admin").password("admin").clientId("admin-cli").resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
        RealmResource realmResource = kc.realm(REALM);
        UsersResource userRessource = realmResource.users();

        return userRessource;
    }

    private RealmResource getRealmResource() {

        Keycloak kc = KeycloakBuilder.builder().serverUrl(SERVER_URL).realm("master").username(USERNAME).password(PASSWORD).clientId("admin-cli").resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

        RealmResource realmResource = kc.realm(REALM);

        return realmResource;
    }

    public List<ClientResponseDTO> getClientsApp() {

//        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(SERVER_URL).grantType("password").realm("master").clientId(CLIENT_ID).username(USERNAME).password(PASSWORD).resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

//        keycloak.tokenManager().getAccessToken();
//        RealmResource realmResource = keycloak.realm("master");
//        return realmResource.clients().findAll();
        return clientMapper.toResponseDtoList(clientDao.getAllClients());
    }

    @Override
    public ClientResponseDTO getClientAppById(UUID id) {
        return clientMapper.toResponseDto(clientDao.getClientById(id));
    }

    public ClientResponseDTO getClientAppByClientId(String clientId) {
        return clientMapper.toResponseDto(clientDao.getClientByClientId(clientId));
    }

    public ClientResponseDTO getClientAppByKeycloakId(String appId) {
        return clientMapper.toResponseDto(clientDao.getClientByKeycloakId(appId));
    }

    private String sendPostUser(List<NameValuePair> urlParameters) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(SERVER_URL + "/realms/" + REALM + "/protocol/openid-connect/token");
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result.toString());

        String accessToken = rootNode.path("access_token").asText();
        String scope = rootNode.path("scope").asText();
        int expiresIn = rootNode.path("expires_in").asInt();
        String tokenType = rootNode.path("token_type").asText();

        JsonObject responseObject = new JsonObject();
        responseObject.addProperty("access_token", accessToken);
        responseObject.addProperty("scope", scope);
        responseObject.addProperty("expires_in", expiresIn);
        responseObject.addProperty("token_type", tokenType);
        responseObject.addProperty("role", "admin");
        return responseObject.toString();

    }

    private String sendPostClient(List<NameValuePair> urlParameters) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(SERVER_URL + "/realms/" + REALM + "/protocol/openid-connect/token");

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        String clientId = null;
        for (NameValuePair param : urlParameters) {
            if (param.getName().equals("client_id")) {
                clientId = param.getValue();
                break;
            }
        }
        String clientAppId = clientDao.getClientByClientId(clientId).getId().toString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result.toString());

        String accessToken = rootNode.path("access_token").asText();
        String scope = rootNode.path("scope").asText();
         int expiresIn = rootNode.path("expires_in").asInt();
         String tokenType = rootNode.path("token_type").asText();

        JsonObject responseObject = new JsonObject();
        responseObject.addProperty("access_token", accessToken);
        responseObject.addProperty("scope", scope);
        responseObject.addProperty("expires_in", expiresIn);
        responseObject.addProperty("token_type", tokenType);
        responseObject.addProperty("client_app_id", clientAppId);
        responseObject.addProperty("role", "clientApp");
        return responseObject.toString();

    }

    @Override
    public void deleteClient(String clientId) {
        Keycloak keycloak = getInstance();
        try {
            ClientResponseDTO clientResponseDTO = clientMapper.toResponseDto(clientDao.getClientByClientId(clientId));
            RealmResource realmResource = keycloak.realm(REALM);
            ClientResource clientResource = realmResource.clients().get(clientResponseDTO.getClientKeycloakId());
            if (clientResource != null) {
                clientResource.remove();
                clientDao.deleteClient(clientMapper.toResponseEntity(clientResponseDTO));
                System.out.println("Client " + clientId + " deleted successfully.");
            } else {
                System.out.println("Client " + clientId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Failed to delete client " + clientId + ": " + e.getMessage());
        }
    }

    @Override
    public void updateClient(ClientAppDTO clientAppDTO) {
        Keycloak keycloak = getInstance();
        try {
            ClientResponseDTO clientResponseDTO = clientMapper.toResponseDto(clientDao.getClientByClientKeycloakId(clientAppDTO.getClientKeycloakId()));
            RealmResource realmResource = keycloak.realm(REALM);
            ClientResource clientResource = realmResource.clients().get(clientAppDTO.getClientKeycloakId());
            ClientRepresentation client = new ClientRepresentation();
            client.setClientId(clientAppDTO.getClientId());
            client.setName(clientAppDTO.getName());
            client.setEnabled(clientAppDTO.isEnabled());
            client.setServiceAccountsEnabled(true);
            client.setId(clientResponseDTO.getClientKeycloakId());
            if (clientResource != null) {
                clientResource.update(client);
                clientDao.deleteClient(clientMapper.toResponseEntity(clientResponseDTO));
                System.out.println("Client " + clientAppDTO.getClientId() + " updated successfully.");
            } else {
                System.out.println("Client " + clientAppDTO.getClientId() + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Failed to update client " + clientAppDTO.getClientId() + ": " + e.getMessage());
        }
    }
}
