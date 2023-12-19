
package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.configuration.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    private final JWTService jwtService;
    private final JwtDecoder jwtDecoder;

    public LoginController(JWTService jwtService, JwtDecoder jwtDecoder) {
        this.jwtService = jwtService;
        this.jwtDecoder = jwtDecoder;
    }

    @GetMapping("/")
    public String getResource() {
        return "a value... ";
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


