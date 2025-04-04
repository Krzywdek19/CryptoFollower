package com.krzywdek19.cryptoFollower.auth;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractUsername(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(UserDetails userDetails);
    String generateToken(UserDetails userDetails, Map<String, Object> claims);
    long getExpirationTime();
    boolean isTokenValid(String token, UserDetails userDetails);
}
