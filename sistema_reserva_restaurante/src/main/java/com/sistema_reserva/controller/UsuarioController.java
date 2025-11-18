package com.sistema_reserva.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema_reserva.dto.UsuarioCreateDto;
import com.sistema_reserva.dto.UsuarioLoginDto;
import com.sistema_reserva.dto.UsuarioResponseDto;
import com.sistema_reserva.model.Usuario;
import com.sistema_reserva.service.UsuarioService;

import jakarta.validation.Valid;
import com.sistema_reserva.exceptions.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> cadastrar(@RequestBody @Valid UsuarioCreateDto dto) throws Exception{
        Usuario novoUsuario = usuarioService.registrarNovoUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponseDto.fromEntity(novoUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UsuarioLoginDto dto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.loginUsuario(dto)); 
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<String> handleEmailExists(EmailAlreadyExists exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(EmailNotExists.class)
    public ResponseEntity<String> handleEmailNotExists(EmailNotExists exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PasswordNotExists.class)
    public ResponseEntity<String> handlePasswordNotExists(PasswordNotExists exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
