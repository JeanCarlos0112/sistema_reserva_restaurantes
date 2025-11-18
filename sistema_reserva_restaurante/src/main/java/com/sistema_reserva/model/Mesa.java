package com.sistema_reserva.model;

import jakarta.persistence.*;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Deixar o banco de dados cuidar do auto-increment

    private int numero;
    private int capacidade;
    private String status;

    //Construtor para o JPA
    protected Mesa(){

    }

    //Construtor da classe para ser usado na camada service
    public Mesa(int numero, int capacidade, String status){
        this.numero = numero;
        this.capacidade = capacidade;
        this.status = status;
    }

    /* GETTERS */

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getStatus() {
        return status;
    }

    /* SETTERS */

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    
}
