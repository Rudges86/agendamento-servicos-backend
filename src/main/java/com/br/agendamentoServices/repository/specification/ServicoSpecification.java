package com.br.agendamentoServices.repository.specification;

import com.br.agendamentoServices.domain.Servico;
import com.br.agendamentoServices.domain.enums.StatusCadastro;
import org.springframework.data.jpa.domain.Specification;

public class ServicoSpecification {
    public static Specification<Servico> nomeLike(String nome) {
        return (root, query, cb) -> nome == null ? null : cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Servico> statusEquals(StatusCadastro status) {
        return (root, query, cb) ->
                status == null ? null :
                        cb.equal(root.get("status"), status);
    }
}
