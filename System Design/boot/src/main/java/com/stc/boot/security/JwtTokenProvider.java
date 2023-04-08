package com.stc.boot.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSectet;

    @Value("${app.jwt.expiration-milliseconds}")
    private String jwtExpirationDate;

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currDate = new Date();

        Date expireDate = new Date(currDate.getTime() + Long.parseLong(jwtExpirationDate));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currDate)
                .setExpiration(expireDate)
                .signWith(generateKey())
                .compact();

        return token;
    }

    private Key generateKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSectet)
        );
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(generateKey()).build().parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        return username;
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(generateKey()).build().parse(token);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }
}
