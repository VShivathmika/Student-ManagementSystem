package com.studentmanagement.security;


import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


import org.springframework.beans.factory.annotation.Value;


@Component
public class JwtUtil {


private final Key key;
private final long jwtExpirationMs;


public JwtUtil(@Value("${jwt.secret}") String secret,
@Value("${jwt.expiration:3600000}") long jwtExpirationMs) {
this.key = Keys.hmacShaKeyFor(secret.getBytes());
this.jwtExpirationMs = jwtExpirationMs;
}


public String generateToken(Authentication authentication) {
String username = authentication.getName();
String authorities = authentication.getAuthorities().stream()
.map(GrantedAuthority::getAuthority)
.collect(Collectors.joining(","));
Date now = new Date();
Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
return Jwts.builder()
.setSubject(username)
.claim("roles", authorities)
.setIssuedAt(now)
.setExpiration(expiryDate)
.signWith(key)
.compact();
}


public String getUsernameFromToken(String token) {
return Jwts.parserBuilder().setSigningKey(key).build()
.parseClaimsJws(token)
.getBody().getSubject();
}


public boolean validateToken(String token) {
try {
Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
return true;
} catch (Exception ex) {
return false;
}
}
}