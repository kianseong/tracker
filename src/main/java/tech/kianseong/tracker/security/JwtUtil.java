package tech.kianseong.tracker.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

//    private static final String SECRET_KEY = "secret";
//    private static final long EXPIRATION_TIME = 86400000;
//
//    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                    .subject(username)
//                    .issuedAt(new Date())
//                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                    .signWith(key, SignatureAlgorithm.HS256)
//                    .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
}
