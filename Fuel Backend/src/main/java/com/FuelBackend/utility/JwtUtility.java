package com.FuelBackend.utility;

import com.FuelBackend.exception.JwtValidationException;
import io.jsonwebtoken.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtility {
    private final String SECRET_KEY = "adaefaefaefaeaefa79239r2fknahsidufhapidfhOIHFPQOIhefOIHFPqfasofnaoif";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
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
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    private String secretKey = "your-secret-key"; // Replace with your actual secret key

    // Method to extract roles/authorities from the token
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
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
