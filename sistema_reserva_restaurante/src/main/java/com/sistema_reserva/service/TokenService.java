package com.sistema_reserva.service;

import java.time.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.sistema_reserva.model.Usuario;;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String createToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                           .withIssuer("auth-api")
                           .withSubject(usuario.getEmail())
                           .withClaim("id", usuario.getId())
                           .withClaim("role", usuario.getRole().toString()) // Adicionando a role
                           .withExpiresAt(gerarDataExpiracao())
                           .sign(algorithm);

            return token;
        } catch(JWTCreationException e){
            throw new RuntimeException("Erro a gerar token JWT.", e);
        }
        
    }

    public String getSubject(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }
}
