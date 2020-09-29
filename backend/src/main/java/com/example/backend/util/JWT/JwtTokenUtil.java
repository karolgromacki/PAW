package com.example.backend.util.JWT;

import com.example.backend.entity.dao.client.Client;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.security.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
    @author Karol Gromacki 
*/
@Component
public class JwtTokenUtil implements Serializable {

    public static final long JWT_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
    private static final String PRIVILEGES_TOKEN_KEY = "privileges";
    private static final String FIRST_NAME_TOKEN_KEY = "firstName";
    private static final String LAST_NAME_TOKEN_KEY = "lastName";
    private static final String LOGIN_TOKEN_KEY = "login";
    private static final String CLIENT_ID_TOKEN_KEY = "clientId";

    @Value("${jwt.secretKey}")
    private String secret;

    private UserDetailsServiceImpl userDetailsService;
    private ClientRepository clientRepository;
    private static final long serialVersionUID = -121624321856818565L;

    public JwtTokenUtil(UserDetailsServiceImpl userDetailsService, ClientRepository clientRepository) {
        this.userDetailsService = userDetailsService;
        this.clientRepository = clientRepository;
    }

    public String getUsernameFromToken(String token) {
        return this.getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails);
    }

    private String doGenerateToken(Map<String, Object> claims, UserDetails userDetails) {
        final long issuedAtInMilliseconds = System.currentTimeMillis();
        final long expirationDateInMilliseconds = issuedAtInMilliseconds + JWT_TOKEN_VALIDITY_SECONDS * 1000;
        final Client client = clientRepository.findByEmail(userDetails.getUsername());
        claims.put(PRIVILEGES_TOKEN_KEY, userDetails.getAuthorities());
        claims.put(FIRST_NAME_TOKEN_KEY, client.getFirstName());
        claims.put(LAST_NAME_TOKEN_KEY, client.getLastName());
        claims.put(LOGIN_TOKEN_KEY, client.getLogin());
        claims.put(CLIENT_ID_TOKEN_KEY, client.getId());

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(issuedAtInMilliseconds))
                .setExpiration(new Date(expirationDateInMilliseconds))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
