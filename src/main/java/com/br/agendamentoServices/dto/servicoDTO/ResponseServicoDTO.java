package com.br.agendamentoServices.dto.servicoDTO;

import com.br.agendamentoServices.domain.enums.StatusCadastro;

import java.math.BigDecimal;

public record ResponseServicoDTO(Long id, String nome, BigDecimal preco, StatusCadastro status) {
}
