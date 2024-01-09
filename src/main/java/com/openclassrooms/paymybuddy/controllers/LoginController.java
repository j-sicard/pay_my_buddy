
package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.configuration.JWTService;
import com.openclassrooms.paymybuddy.fo.AuthRequestFO;
import com.openclassrooms.paymybuddy.fo.RegisterUserFO;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    TransferBusinessService transferBusinessService;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private OAuth2AuthorizedClientService authorizedClientService;

    public LoginController(AuthenticationManager authenticationManager, JWTService jwtService, OAuth2AuthorizedClientService authorizedClientService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.authorizedClientService = authorizedClientService;
    }

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginController.class.getName());

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getToken(@RequestBody AuthRequestFO authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            return ResponseEntity.ok(jwtService.generateToken(authentication));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de l'authentification");
        }
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token) {
        try {
            // Retirez le préfixe "Bearer " si présent
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Map<String, Object> userInfo = jwtService.extractUserInfo(token);

            return new ResponseEntity<>(transferBusinessService.getuserIDbyEmail((String) userInfo.get("sub")), HttpStatus.OK);
        } catch (JwtException e) {
            return new ResponseEntity<>("Invalid or expired token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "An error occurred while processing the token", e);
            return new ResponseEntity<>("An error occurred while processing the token", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserFO registerUserFO) {
        String userId = transferBusinessService.registerUser(registerUserFO.getEmail(), registerUserFO.getPassword());
           return ResponseEntity.ok(userId);
    }
}


