package com.adria.gateway.controller;

import com.adria.gateway.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {


    @Value("${keycloak.serverUrl}")
    private String keycloakServerUrl;

    @Value("${keycloak.clientId}")
    private String keycloakClientId;

    @Value("${keycloak.realm}")
    private String keycloakRealm;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredentialsDto userCredentials) {
        TokenResponseDTO tokenResponseDTO;
        try {
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "password"));
            urlParameters.add(new BasicNameValuePair("client_id", keycloakClientId));
            urlParameters.add(new BasicNameValuePair("username", userCredentials.getUsername()));
            urlParameters.add(new BasicNameValuePair("password", userCredentials.getPassword()));

            String responseToken = sendPost(urlParameters);
            tokenResponseDTO = new ObjectMapper().readValue(responseToken, TokenResponseDTO.class);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred during authentication."));
        }

        return ResponseEntity.ok(tokenResponseDTO);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshToken refreshToken) {
        String responseToken = null;
        try {
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));
            urlParameters.add(new BasicNameValuePair("client_id", keycloakClientId));
            urlParameters.add(new BasicNameValuePair("refresh_token", refreshToken.getRefreshToken()));

            responseToken = sendPost(urlParameters);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while refreshing token.");
        }

        return ResponseEntity.ok(responseToken);
    }

    private String sendPost(List<NameValuePair> urlParameters) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(keycloakServerUrl + "/realms/" + keycloakRealm + "/protocol/openid-connect/token");
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

        return result.toString();
    }
}

