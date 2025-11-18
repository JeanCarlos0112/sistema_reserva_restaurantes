package com.sistema_reserva.service;

import org.springframework.stereotype.Service;

import com.sistema_reserva.dto.UsuarioCreateDto;
import com.sistema_reserva.dto.UsuarioLoginDto;
import com.sistema_reserva.model.Usuario;
import com.sistema_reserva.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sistema_reserva.exceptions.*;

import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, TokenService tokenService){
       this.usuarioRepository = usuarioRepository;
       this.passwordEncoder = passwordEncoder;
       this.tokenService = tokenService;
    }

    public Usuario registrarNovoUsuario(UsuarioCreateDto dto) throws Exception {
        if(usuarioRepository.findByEmail(dto.email()).isPresent()){
            throw new EmailAlreadyExists("O email " + dto.email() + " já está cadastrado.");
        }

        String senhaCodificada = passwordEncoder.encode(dto.senha());

        Usuario novoUsuario = new Usuario(
            dto.nome(),
            dto.email(),
            senhaCodificada
        );

        try {
            return usuarioRepository.save(novoUsuario);
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao salvar o usuario no banco de dados.", e);
        }
    }

    public String loginUsuario(UsuarioLoginDto dto){
        Optional<Usuario> userLogin = usuarioRepository.findByEmail(dto.email());
        if (!userLogin.isPresent()){
            throw new EmailNotExists("O email " + dto.email() + " não esta cadastrado");
        }
        
        Usuario user = userLogin.get();
        if (!passwordEncoder.matches(dto.senha(), user.getSenha())){
            throw new PasswordNotExists("A senha está incorreta.");
        }

        return tokenService.createToken(user);
    }
}
