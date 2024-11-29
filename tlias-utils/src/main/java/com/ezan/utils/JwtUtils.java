package com.ezan.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "EzanEzanEzanEzanEzanEzanEzanEzanEzanEzanEzanEzan";
    private static Long expire = 43200000L;

    /**
     * 生成JWT
     * @param claims
     * @return
     */
    public static String generateJWT(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        return claims;
    }
}
