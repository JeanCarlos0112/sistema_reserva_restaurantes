package com.sistema_reserva.exceptions;

public class EmailNotExists  extends RuntimeException {
    public EmailNotExists(String message){
        super(message);
    }
}
