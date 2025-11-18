package com.sistema_reserva.event;

import com.sistema_reserva.model.Usuario;

/**
 * Evento publicado quando um novo usuário se registra com sucesso,
 * mas ainda está com status PENDENTE.
 * * Serve para gatilhar processos assíncronos, como o envio de e-mail de verificação.
 */
public record UsuarioRegistradoEvent(Usuario usuario) {}
