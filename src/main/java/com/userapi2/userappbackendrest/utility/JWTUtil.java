package com.userapi2.userappbackendrest.utility;

import com.userapi2.userappbackendrest.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JWTUtil {
    private  final String SECRET_KEY = "x6UIDuuijkBNmxcbhjkljsjdjbsjjdnjnsjwjhbfwbdkjbwfkjbw";
    public String createToken(String userName, Map<String,Object> claims){
       return Jwts.builder()
               .setClaims(claims)
               .setSubject(userName)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
               .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
               .compact();
    }
    public Token generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        claims.put("username",userName);
        String token= createToken(userName,claims);
        Token token1=new Token(token,"3600");
         return  token1;
    }
    public String extractUserName(Token token){
        Claims claims= Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token.getToken())
                .getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String token, UserDetails userDetails){
        Token t=new Token();
        t.setToken(token);
        String extractedUserName=extractUserName(t);
        return extractedUserName.equals(userDetails.getUsername());
    }

}
