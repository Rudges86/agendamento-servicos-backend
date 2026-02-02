package com.br.agendamentoServices.domain;

import com.br.agendamentoServices.domain.enums.StatusAgendamento;
import com.br.agendamentoServices.domain.enums.StatusCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Profissional profissional;

    @ManyToOne
    private Servico servico;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    public Agendamento() {
    }

    public Agendamento(Cliente cliente, Profissional profissional, Servico servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, StatusAgendamento statusAgendamento) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusAgendamento = statusAgendamento;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }
}