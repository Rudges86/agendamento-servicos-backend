package com.br.agendamentoServices.repository.projection;

import com.br.agendamentoServices.domain.enums.StatusCadastro;

import java.math.BigDecimal;

public interface ServicoProjection {
    Long getId();
    String getNome();
    BigDecimal getPreco();
    StatusCadastro getStatus();
}
