package com.jobintech.elearningjobintech.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class JWTUtil {
//    private static  final String key= "jobintech_123456789";
//   public String issueToken(String subject){
//       return issueToken(subject, Map.of());
//   }
//   public  String issueToken(String subject, String ...scopes){
//       return issueToken(subject, Map.of("scopes", String.join("scopes", scopes)));
//   }
//
//    public String issueToken (String subjetc,
//                              Map<String, Object> claims){
//        return  Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subjetc)
//                .setIssuer("jobintech")
//                .setIssuedAt(Date.from(Instant.now()))
//                .setExpiration(Date.from(Instant.now().plus(15, DAYS)))
//                .signWith(getSifningKey(), SignatureAlgorithm.ES256)
//                .compact();
//
//
//    }
//    private Key getSifningKey(){
//        return Keys.hmacShaKeyFor(key.getBytes());
//    }
//

}
