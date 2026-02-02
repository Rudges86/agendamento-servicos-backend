package com.br.agendamentoServices.repository;

import com.br.agendamentoServices.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query(nativeQuery = true, value =
    "SELECT EXISTS ( SELECT 1 FROM agendamento a" +
            "WHERE" +
            "a.profissional_id = :profissionalId" +
            "AND " +
            "a.dataHoraInicio < :fim " +
            "AND " +
            "a.dataHoraFim > :inicio" +
            ")")
    boolean existsByProfissionalAndDataHoraInicioLessThanAndDataHoraFimGreaterThan(
            @Param("profissionalId") long profissional,
            @Param("fim")LocalDateTime fim,
            @Param("inicio")LocalDateTime inicio
    );
}
