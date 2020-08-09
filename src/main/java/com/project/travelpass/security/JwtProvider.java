package com.project.travelpass.security;

import static io.jsonwebtoken.Jwts.parser;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.project.travelpass.exception.MyException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider {

	private KeyStore keyStore;
	
	@Value("${jwt.expiration.time}")
	private Long jwtExpirationInMillis;
	
	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceAsStream = getClass().getResourceAsStream("/key.jks");
			keyStore.load(resourceAsStream, "Kmit123$".toCharArray());
		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			throw new MyException("Exception occurred while loading keystore");
		}
	}

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }
    
    public String generateTokenForRefreshTokenWithUid(String uid) {
    	return Jwts.builder()
                .setSubject(uid)
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }
    
    private PrivateKey getPrivateKey() {
	    try {
	    	return (PrivateKey) keyStore.getKey("key", "Kmit123$".toCharArray());
	    } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
	    	throw new MyException("Exception occured while retrieving public key from keystore");
	    }
    }

    public boolean validateToken(String jws) {
        parser().setSigningKey(getPublicKey()).parseClaimsJws(jws);
        return true;
    }


    private PublicKey getPublicKey() {
    	 try {
 	    	return (PublicKey) keyStore.getCertificate("key").getPublicKey();
 	    } catch (KeyStoreException e) {
 	    	throw new MyException("Exception occured while retrieving public key from keystore");
 	    }
	}

	public String getUidFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublicKey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
	
	public Long getJwtExpirationInMillis() {
		return jwtExpirationInMillis;
		}
}
