package com.sistema_reserva.exceptions;

public class PasswordNotExists extends RuntimeException {
    public PasswordNotExists(String message){
        super(message);
    }
}
