package com.adria.keycloakManagement.controller;

import com.adria.keycloakManagement.dto.ClientDTO;
import com.adria.keycloakManagement.model.UserCredentials;
import com.adria.keycloakManagement.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/keycloak")
@RequiredArgsConstructor
public class KeycloakController {

    private final KeycloakService keyClockService;

    /*
     * Get token for the first time when user log in. We need to pass
     * credentials only once. Later communication will be done by sending token.
     */

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> getTokenUsingCredentials(@RequestBody UserCredentials userCredentials) {

        String responseToken = null;
        try {

            responseToken = keyClockService.getToken(userCredentials);

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

    @RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
    public ResponseEntity<?> getTokenUsingRefreshToken(@RequestHeader(value = "Authorization") String refreshToken) {

        String responseToken = null;
        try {

            responseToken = keyClockService.getByRefreshToken(refreshToken);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(responseToken, HttpStatus.OK);

    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ClientRepresentation> getClients() {
        return keyClockService.getClients();
    }

    @PostMapping("/saveClient")
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO clientDTO) {
        try {
            keyClockService.createClient(clientDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {

            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/clientsave")
    public ResponseEntity<String> createClient(@RequestBody ClientDTO clientDTO) {
        // Replace "your_token_value" with the actual token
        keyClockService.createClient(clientDTO);
        return ResponseEntity.ok("Client created successfully");
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

}