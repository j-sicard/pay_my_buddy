
package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.configuration.JWTService;
import com.openclassrooms.paymybuddy.fo.AuthRequestFO;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.util.MultiValueMap;
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

    public LoginController(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginController.class.getName());

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getToken(@RequestBody AuthRequestFO authRequest) {
        try {
            String username = authRequest.getUsername();
            String password = authRequest.getPassword();

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = jwtService.generateToken(authentication);
            return ResponseEntity.ok(token);
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
}


