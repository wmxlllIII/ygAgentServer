package com.dmy.ygagentserver.common.util;

import com.dmy.ygagentserver.module.user.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "vgagent-secret-vgagent-secret-vgagent-secret";
    private static final long EXPIRE = 86400000;

    public static String generateToken(User user) {

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .claim("username", user.getNickname())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET.getBytes()
                )
                .compact();
    }
}


