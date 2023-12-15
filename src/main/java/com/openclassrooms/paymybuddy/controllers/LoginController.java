
package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.configuration.JWTService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    public JWTService jwtService;

    public LoginController(JWTService jwtService){
        this.jwtService = jwtService;
    }

@GetMapping("/")
    public String gerResource(){
    return "a value... ";
}


@PostMapping("/login")
    public String getToken(Authentication authentication){
    String token = jwtService.generateToken(authentication);
    return token;
}
}
