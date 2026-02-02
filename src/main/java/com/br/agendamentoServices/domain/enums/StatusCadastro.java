package com.br.agendamentoServices.domain.enums;

import java.util.Arrays;

public enum StatusCadastro {
    ATIVO("Ativo",1),
    INATIVO("Inativo",2),
    CANCELADO("Cancelado",3),
    CADASTRO_PENDENTE("Cadastro Pendente",4);
    private final String descricao;
    private final Integer codigo;
    StatusCadastro(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }


    public static StatusCadastro fromDescricao(String descricao) {
        return Arrays.stream(values())
                .filter(status -> status.getDescricao().equals(descricao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + descricao));
    }

    public static StatusCadastro fromCodigo(int codigo) {
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
