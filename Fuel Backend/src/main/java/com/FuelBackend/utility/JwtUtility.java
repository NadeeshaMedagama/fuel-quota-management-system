package com.FuelBackend.utility;

import com.FuelBackend.exception.JwtValidationException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtUtility {

    private static final long EXPIRATION_TIME = 1000 * 60 * 10; // 10 minutes
    private String key="4D7A34B5d7863FF74D7A34B5d7863FF74D7A34B5d7863FF7";


    public String generateToken(String username, String password, String role) {
        String[] roles = {"admin", "fuel station"}; // Add roles to your token
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("password", password); // It's better to hash the password
        claims.put("extra", "x".repeat(200)); // Extra padding
        claims.put("roles", roles); // Assign roles

        return Jwts.builder()
                .setClaims(claims) // Set claims in the token
                .setIssuedAt(new Date()) // Set issue date
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, key)// Set expiration time

                .compact(); // Generate the compact JWT
    }




    public String extractUsername(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey( key)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("username").toString();
        } catch (MalformedJwtException e) {
            throw new JwtValidationException("Malformed JWT token");
        } catch (ExpiredJwtException e) {
            throw new JwtValidationException("JWT token has expired");
        } catch (UnsupportedJwtException e) {
            throw new JwtValidationException("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            throw new JwtValidationException("JWT claims string is empty");
        }
    }

    public boolean validateToken(String token, String username) {
        try {
            return username.equals(extractUsername(token)) && !isTokenExpired(token);
        } catch (JwtValidationException e) {
            throw e;
        }
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }



    public Collection<SimpleGrantedAuthority> extractAuthorities(String token) {
        Claims claims = extractAllClaims(token);
        List<String> roles = claims.get("roles", List.class); // Assumes roles are stored in a claim called "roles"

        // Map roles to GrantedAuthority
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    // Method to extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
