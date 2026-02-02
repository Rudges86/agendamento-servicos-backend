package com.br.agendamentoServices.domain;

import com.br.agendamentoServices.domain.enums.StatusCadastro;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Enumerated(EnumType.STRING)
    private StatusCadastro status;

    public Cliente() {
        status = StatusCadastro.CADASTRO_PENDENTE;
    }

    public Cliente(long id, String nome, String email, String telefone, StatusCadastro status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusCadastro getStatus() {
        return status;
    }

    public void setStatus(StatusCadastro status) {
        this.status = status;
    }
}
