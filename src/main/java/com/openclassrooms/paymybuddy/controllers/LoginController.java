
package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.configuration.JWTService;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    private final JWTService jwtService;

    public LoginController(JWTService jwtService) {
        this.jwtService = jwtService;
    }


    @PostMapping("/login")
    public String getToken(Authentication authentication) {
        String token = jwtService.generateToken(authentication);
        return token;
    }

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginController.class.getName());

    @GetMapping("/getUserInfo")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token) {
        try {
            // Retirez le préfixe "Bearer " si présent
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Map<String, Object> userInfo = jwtService.extractUserInfo(token);
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } catch (JwtException e) {
            return new ResponseEntity<>("Invalid or expired token", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "An error occurred while processing the token", e);
            return new ResponseEntity<>("An error occurred while processing the token", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


