package com.sistema_reserva.model;

import com.sistema_reserva.model.enums.Role;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Deixar o banco de dados cuidar do auto-increment

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    protected Usuario(){

    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;

        this.role = Role.ROLE_CLIENTE;
    }


    /* GETTERS */
    
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public Role getRole() {
        return role;
    }

    /* SETTERS */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
