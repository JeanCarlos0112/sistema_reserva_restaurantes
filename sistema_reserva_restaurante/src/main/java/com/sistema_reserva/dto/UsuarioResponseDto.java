package com.sistema_reserva.dto;

import com.sistema_reserva.model.Usuario;

public record UsuarioResponseDto(Long id, String nome, String email) {
    public static UsuarioResponseDto fromEntity (Usuario usuario){
        return new UsuarioResponseDto(
            usuario.getId(),
            usuario.getNome(), 
            usuario.getEmail()
        );
    }
}
