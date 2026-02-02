package com.br.agendamentoServices.repository;

import com.br.agendamentoServices.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
