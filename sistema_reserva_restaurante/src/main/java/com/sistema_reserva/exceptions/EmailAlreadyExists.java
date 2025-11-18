package com.sistema_reserva.exceptions;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists(String message){
        super(message);
    }
}
