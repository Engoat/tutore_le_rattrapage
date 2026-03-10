package cm.institutsaintjean.suiviacademique.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;

@Service
public class ServiceJwt {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Key obtenirCle() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String genererToken(String numeroTelephone) {
        Date maintenant = new Date();
        Date dateExpiration = new Date(maintenant.getTime() + expiration);

        return Jwts.builder()
                .setSubject(numeroTelephone)
                .setIssuedAt(maintenant)
                .setExpiration(dateExpiration)
                .signWith(obtenirCle(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validerToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(obtenirCle())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extraireNumeroTelephone(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(obtenirCle())
                .build()
                .parseClaimsJws(token)
                .getBody();
        
        return claims.getSubject();
    }
}
