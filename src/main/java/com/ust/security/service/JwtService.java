package com.ust.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public static final String secret = "aXdpbGxydWxldXN05rt8734yr84h38ufhurhfguirhfiguhfhuirfhuiwr";

    public String generateToken(String c) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, c);
    }

    private String createToken(Map<String, Object> claims, String c) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(c)
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)), SignatureAlgorithm.HS256)
                .compact();
    }

    public void validateToken(String token) {
        Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
