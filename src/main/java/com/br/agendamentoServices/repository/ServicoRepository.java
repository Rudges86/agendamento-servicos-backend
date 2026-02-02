package com.br.agendamentoServices.repository;

import com.br.agendamentoServices.domain.Servico;
import com.br.agendamentoServices.domain.enums.StatusCadastro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicoRepository extends JpaRepository<Servico, Long>, JpaSpecificationExecutor<Servico> {

    @Query(
            nativeQuery = true,
            value = """
                    SELECT COUNT(s) > 0
                    FROM servico s
                    WHERE LOWER(s.nome) = LOWER(:nome) 
                    AND 
                    s.status = :status
                    """
    )
    boolean existsByNomeIgnoreCaseAndStatus(
            @Param("nome") String nome,
            @Param("status") StatusCadastro status);

    @Query(nativeQuery = true,
    value = """
            SELECT 
            s.id as id,
            s.nome as nome,
            s.preco as preco,
            s.status as status
            FROM
            servico s
            WHERE s.status = :status
            """,
    countQuery = """
            SELECT COUNT(*)
            FROM servico s
            WHERE s.status = :status
            """
    )
    Page<Servico> listarTodosPorStatus(@Param("status") StatusCadastro status, Pageable pageable);

    @Query(nativeQuery = true,
            value = """
            SELECT 
            s.id as id,
            s.nome as nome,
            s.preco as preco,
            s.status as status
            FROM
            servico s
            """,
            countQuery = """
            SELECT COUNT(*)
            FROM servico s
            """
    )
    Page<Servico> listarTodos(Pageable pageable);

    @Query(nativeQuery = true,
            value = """
             SELECT *
             FROM servico s
             WHERE s.nome = :nome        
            """,
    countQuery = """
            SELECT COUNT(*)
            FROM servico s
            """)
    Page<Servico> buscaPorNome(String nome);
}
