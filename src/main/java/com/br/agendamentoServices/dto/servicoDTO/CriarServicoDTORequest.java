package com.br.agendamentoServices.dto.servicoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarServicoDTORequest(
        @NotBlank
        @NotNull
        String nome,
        @NotBlank
        @NotNull
        BigDecimal preco
        ) {
}
