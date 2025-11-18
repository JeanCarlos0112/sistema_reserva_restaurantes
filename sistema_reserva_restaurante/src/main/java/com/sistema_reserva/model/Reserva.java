package com.sistema_reserva.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    @JoinColumn(name = "data_reserva")
    LocalDateTime dataReserva;

    private boolean status;

    protected Reserva(){
    }

    public Reserva(Usuario usuario, Mesa mesa, LocalDateTime dataReserva, boolean status){
        this.usuario = usuario;
        this.mesa = mesa;
        this.dataReserva = dataReserva;
        this.status = status;
    }

    /* GETTERS */

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public boolean isStatus() {
        return status;
    }

    /* SETTERS */

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void setMesa_id(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
