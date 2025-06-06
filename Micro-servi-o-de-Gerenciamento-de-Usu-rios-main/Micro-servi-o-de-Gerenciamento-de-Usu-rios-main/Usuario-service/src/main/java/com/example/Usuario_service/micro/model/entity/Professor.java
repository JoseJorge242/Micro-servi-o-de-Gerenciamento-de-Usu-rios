package com.example.Usuario_service.micro.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha_hash")
    private String password;

    @Column(name = "tipo")
    private TipoUsuario tipo;

    // Construtor
    public Professor(Long id, String email, String nome, String password, TipoUsuario tipo) {
        super();
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.tipo = tipo != null ? tipo : TipoUsuario.PROFESSOR; // Define o tipo padrão se null
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo() {
        return tipo; // Retorna o tipo como TipoUsuario
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo; // Aceita TipoUsuario como parâmetro
    }
}
