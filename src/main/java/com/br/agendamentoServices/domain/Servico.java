package com.br.agendamentoServices.domain;

import com.br.agendamentoServices.domain.enums.StatusCadastro;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private StatusCadastro status;


    public Servico() {
    }

    public Servico(String nome, BigDecimal preco, StatusCadastro status) {
        this.nome = nome;
        this.preco = preco;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusCadastro getStatus() {
        return status;
    }

    public void setStatus(StatusCadastro status) {
        this.status = status;
    }
}
