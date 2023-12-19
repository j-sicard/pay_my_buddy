
package com.openclassrooms.paymybuddy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;

    @Autowired
    public JWTService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
    }

     public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .subject(authentication.getName())
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }

    public Map<String, Object> extractUserInfo(String token) {
        try {
          Jwt decodedJwt = this.jwtDecoder.decode(token);
            return decodedJwt.getClaims();
        } catch (JwtException e) {
            throw new RuntimeException("Erreur lors de l'extraction des informations du token", e);
        }
    }


}