package com.br.agendamentoServices.domain.enums;

import java.util.Arrays;

public enum StatusAgendamento {
    EM_PROCESSAMENTO("Em processamento",1),
    CONFIRMADO("Confirmado",2),
    CANCELADO("Cancelado",3),
    PENDENTE_PAGAMENTO("Pendente de pagamento", 4);

    private final String descricao;
    private final Integer codigo;

    StatusAgendamento(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }


    public static StatusAgendamento fromDescricao(String descricao) {
        return Arrays.stream(values())
                .filter(status -> status.getDescricao().equals(descricao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + descricao));
    }

    public static StatusAgendamento fromCodigo(int codigo) {
        return Arrays.stream(values())
                .filter(status -> status.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código de status inválido: " + codigo));
    }
    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
