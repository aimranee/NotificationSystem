package com.adria.keycloakManagement.controller;

import com.adria.keycloakManagement.dto.ClientAppDTO;
import com.adria.keycloakManagement.dto.ClientCredentialsDto;
import com.adria.keycloakManagement.dto.CreateClientAppDto;
import com.adria.keycloakManagement.dto.UserCredentialsDto;
import com.adria.keycloakManagement.dto.response.ClientResponseDTO;
import com.adria.keycloakManagement.dto.response.TokenResponseDTO;
import com.adria.keycloakManagement.service.KeycloakService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/keycloak")
@RequiredArgsConstructor
public class KeycloakController {

    private final KeycloakService keyclockService;

    /*
     * Get token for the first time when user log in. We need to pass
     * credentials only once. Later communication will be done by sending token.
     */

    @RequestMapping(value = "/login/client", method = RequestMethod.POST)
    public ResponseEntity<?> getTokenUsingCredentials(@RequestBody ClientCredentialsDto clientCredentials) {

        String responseToken;
        try {
            responseToken = keyclockService.getTokenClient(clientCredentials);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseToken, HttpStatus.OK);
    }

    @PostMapping("/login/admin")
    public ResponseEntity<?> loginAdmin(@RequestBody UserCredentialsDto userCredentials) {

        String responseToken;
        try {
            responseToken = keyclockService.getTokenUser(userCredentials);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseToken, HttpStatus.OK);
    }

    /*
     * When access token get expired than send refresh token to get new access
     * token. We will receive new refresh token also in this response.Update
     * client cookie with updated refresh and access token
     */

//    @RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
//    public ResponseEntity<?> getTokenUsingRefreshToken(@RequestHeader(value = "Authorization") String refreshToken) {
//
//        String responseToken = null;
//        try {
//
//            responseToken = keyclockService.getByRefreshToken(refreshToken);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(responseToken, HttpStatus.OK);
//
//    }

    @GetMapping(value = "/findAll")
    public List<ClientResponseDTO> getClients() {
        return keyclockService.getClientsApp();
    }

    @GetMapping(value = "/find/{clientId}")
    public ClientResponseDTO getClientByClientId(@PathVariable String clientId) {
        return keyclockService.getClientAppByClientId(clientId);
    }

    @GetMapping(value = "/findById/{appId}")
    public ClientResponseDTO getClientByKeycloakId(@PathVariable String appId) {
        return keyclockService.getClientAppByKeycloakId(appId);
    }

    @PostMapping("/saveClientApp")
    public ResponseEntity<?> saveClient(@RequestBody CreateClientAppDto clientAppDTO) {
        try {
            keyclockService.createClientApp(clientAppDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {

            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ClientResponseDTO getClientById(@PathVariable UUID id) {
        return keyclockService.getClientAppById(id);
    }

    /*
     * Creating user in keycloak passing UserDTO contains username, emailid,
     * password, firtname, lastname
     */
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
//        try {
//
//            keyClockService.createUserInKeyCloak(userDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//
//        catch (Exception ex) {
//
//            ex.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//
//    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<String> deleteKeycloakClient(@PathVariable String clientId) {
        try {
            keyclockService.deleteClient(clientId);
            return ResponseEntity.ok("Client " + clientId + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete client " + clientId + ": " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateKeycloakClient(@RequestBody ClientAppDTO updatedClient) {
        try {
            keyclockService.updateClient(updatedClient);
            return ResponseEntity.ok("Client " + updatedClient.getClientId() + " updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update client " + updatedClient.getClientId() + ": " + e.getMessage());
        }
    }

}