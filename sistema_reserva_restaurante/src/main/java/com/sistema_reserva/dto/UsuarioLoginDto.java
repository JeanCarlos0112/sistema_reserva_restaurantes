package com.sistema_reserva.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDto(
    @NotBlank(message = "O e-mail não pode estar em branco")
    String email,

    @NotBlank(message = "A senha não pode estar em branco")
    String senha
) {
}
