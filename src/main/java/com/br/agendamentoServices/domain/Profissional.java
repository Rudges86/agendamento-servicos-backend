package com.br.agendamentoServices.domain;

import com.br.agendamentoServices.domain.enums.StatusCadastro;
import jakarta.persistence.*;

@Entity
@Table(name = "profissional")
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String especialidade;
    @Enumerated(EnumType.STRING)
    private StatusCadastro status;

    public Profissional() {
        status = StatusCadastro.CADASTRO_PENDENTE;
    }

    public Profissional(long id, String nome, String especialidade, StatusCadastro status) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public StatusCadastro getStatus() {
        return status;
    }

    public void setStatus(StatusCadastro status) {
        this.status = status;
    }
}
