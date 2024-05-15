package com.adria.keycloakManagement.service.impl;

import com.adria.keycloakManagement.dao.ClientDao;
import com.adria.keycloakManagement.dto.ClientDTO;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.mapper.ClientMapper;
import com.adria.keycloakManagement.model.UserCredentials;
import com.adria.keycloakManagement.service.KeycloakService;
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

    public String getToken(UserCredentials userCredentials) {

        String responseToken = null;
        try {

            String username = userCredentials.getUsername();
            String password = userCredentials.getPassword();

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "password"));
            urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));

            responseToken = sendPost(urlParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseToken;

    }

    @Override
    public ClientResponseDTO createClient(ClientDTO clientDTO) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        try {

            Keycloak keycloak = getInstance();

            // Get the realm resource
            RealmResource realmResource = keycloak.realm(REALM);

            // Get the clients resource
            ClientsResource clientsResource = realmResource.clients();

            ClientRepresentation client = new ClientRepresentation();
            client.setClientId(clientDTO.getClientId());
            client.setName(clientDTO.getName());
            client.setEnabled(clientDTO.isEnabled());
            client.setServiceAccountsEnabled(true);
            // Create the client
            Response response = clientsResource.create(client);

            if (response.getStatus() == 201) {
                // Extract the ID of the created client from the Location header
                URI location = response.getLocation();
                String clientId = location.getPath().substring(location.getPath().lastIndexOf('/') + 1);
                ClientResource res = clientsResource.get(clientId);
                clientDTO.setClientSecret(res.getSecret().getValue());

                clientResponseDTO = clientMapper.toResponseDto(clientDao.createClient(clientMapper.toEntity(clientDTO)));

            } else {
                System.err.println("Failed to create client. Status code: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
        return clientResponseDTO;
    }

    @Override
    public String getByRefreshToken(String refreshToken) {

        String responseToken = null;
        try {

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));
            urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
            urlParameters.add(new BasicNameValuePair("refresh_token", refreshToken));

            responseToken = sendPost(urlParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseToken;
    }

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

    public List<ClientRepresentation> getClients() {
//        Keycloak keycloak = KeycloakBuilder.builder()
//                .serverUrl(SERVER_URL)
//                .realm("master")
//                .clientId(CLIENT_ID)
//                .clientSecret(CLIENT_SECRET)
//                .authorization("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJObERpbzJDQk9CTWc2YVZJVjVxZFVPWUw3Y2p0VDNCWHg2NDlNQnVmM2RjIn0.eyJleHAiOjE3MTU3NjY3NDcsImlhdCI6MTcxNTc2NjY4NywianRpIjoiMjQ1Y2QwNzktYTlmOC00YTg4LTg4NWYtNTkwNmY0ZjI2M2IxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDkwL3JlYWxtcy9tYXN0ZXIiLCJzdWIiOiJhMzA2MWIzZi00YTA0LTQ3MjAtOTg1MC04MmU3MjJjZjJkNmEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhZG1pbi1jbGkiLCJzZXNzaW9uX3N0YXRlIjoiZDY2YWRiMjgtZDJmZi00NDk2LWEyYjctYjU3YzU0NmE1MTA3IiwiYWNyIjoiMSIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwiLCJzaWQiOiJkNjZhZGIyOC1kMmZmLTQ0OTYtYTJiNy1iNTdjNTQ2YTUxMDciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJhaW1yYW5lIGVzc2FraGkiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJhaW1yYW5lIiwiZmFtaWx5X25hbWUiOiJlc3Nha2hpIiwiZW1haWwiOiJhaW1yYW5lMjAwMkBnbWFpbC5jb20ifQ.AU-gSXha_xrjUIGakXviOIlVvkVkSsRpb15T1lzkFwADGsG-NTXBLvtzbwvysl7AhqkVJ2lsvYVXqc-do2CaaqaE3qYjpZsmjWGA9l7QPIM_-iy0YKgt0O_pp1Lxcs2OMeXp1OOsXlCTGCKvUKvE2z04LxJPP2efgzdjbQnaUGO5qtxVRhUbxxDV2NXbnYft4x_eHtMHzOnEY0bHEpTcnPLHQdZ-O9fN92EM6d_WF1aRmjCWEStOOO6P9-ywt-fmPs0GnzC832e5noFmupCyQjYlqJh-KbPYZys-sYBdYC18QYc0uQtU0HMwVOK6MpJe4lenXJ2wWIA-bhWQIywxww")
//                .build();
//
//        RealmResource realmResource = keycloak.realm("master");
//        ClientsResource clientsResource = realmResource.clients();
//
//        // Retrieve the list of clients
//        return clientsResource.findAll();

        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(SERVER_URL).grantType("password").realm("master").clientId(CLIENT_ID).username(USERNAME).password(PASSWORD).resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

        keycloak.tokenManager().getAccessToken();
        RealmResource realmResource = keycloak.realm("master");
        return realmResource.clients().findAll();
    }

    private String sendPost(List<NameValuePair> urlParameters) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(SERVER_URL + "/realms/" + REALM + "/protocol/openid-connect/token");

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();

    }
}
