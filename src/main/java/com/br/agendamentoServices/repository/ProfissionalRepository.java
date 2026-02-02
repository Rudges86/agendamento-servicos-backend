package com.br.agendamentoServices.repository;

import com.br.agendamentoServices.domain.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
