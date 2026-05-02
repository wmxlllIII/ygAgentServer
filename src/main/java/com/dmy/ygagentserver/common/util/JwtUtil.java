package com.dmy.ygagentserver.common.util;

import com.dmy.ygagentserver.module.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "vgagent-secret-vgagent-secret-vgagent-secret";
    private static final long EXPIRE = 86400000;

    public static String generateToken(User user) {

        return Jwts.builder()
                .setSubject(String.valueOf(user.getUserId()))
                .claim("username", user.getNickname())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET.getBytes()
                )
                .compact();
    }

    public static Long getUserIdFromToken(String token) {
        String userId = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return Long.parseLong(userId);
    }

}