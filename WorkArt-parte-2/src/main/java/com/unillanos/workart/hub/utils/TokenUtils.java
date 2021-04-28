package com.unillanos.workart.hub.utils;

import com.unillanos.workart.hub.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtils {
    public String getToken(User user)
    {
        String secret="thisissecret";
        String token=Jwts.builder()
                .setId("directory")
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60000))
                .claim("company", "unodos")
                .signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();

        return token;
    }
}
