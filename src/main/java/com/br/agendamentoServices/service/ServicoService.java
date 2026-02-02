package com.br.agendamentoServices.service;

import com.br.agendamentoServices.domain.Servico;
import com.br.agendamentoServices.domain.enums.StatusCadastro;
import com.br.agendamentoServices.dto.servicoDTO.CriarServicoDTORequest;
import com.br.agendamentoServices.dto.servicoDTO.ResponseServicoDTO;
import com.br.agendamentoServices.repository.ServicoRepository;
import com.br.agendamentoServices.repository.specification.ServicoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public void cadastrarServico(CriarServicoDTORequest servicoDTO) {
        if(servicoRepository.existsByNomeIgnoreCaseAndStatus(servicoDTO.nome(), StatusCadastro.ATIVO)) {
            throw new IllegalArgumentException("Serviço já cadastrado e ativo");
        }

        Servico servico = criarServico(servicoDTO);
        servicoRepository.save(servico);
    }

    public Page<ResponseServicoDTO> getAllServices(StatusCadastro statusCadastro, Pageable pageable) {
        Page<Servico> servicoPage = statusCadastro != null ?
          servicoRepository.listarTodosPorStatus(statusCadastro, pageable)
                :
          servicoRepository.listarTodos(pageable);
        return servicoPage.map( this::toResponseServicoDTO);
    }


    public Page<ResponseServicoDTO> buscaPorNome(String nome, StatusCadastro status,Pageable pageable) {
        Specification<Servico> spec = ServicoSpecification.nomeLike(nome)
                .and(ServicoSpecification.statusEquals(status));
        Page<Servico> servicoPage = servicoRepository.findAll(spec, pageable);
        return servicoPage.map(this::toResponseServicoDTO);
    }

    //Jeito diferente de salvar sem dar um .save diretamente
    @Transactional
    public void atualizarStatusService(Long id,StatusCadastro statusCadastro) {
        Servico servico = servicoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        servico.setStatus(statusCadastro);
    }



    private ResponseServicoDTO toResponseServicoDTO(Servico servico) {
        return new ResponseServicoDTO(
                servico.getId(),
                servico.getNome(),
                servico.getPreco(),
                servico.getStatus()
        );
    }
    private Servico criarServico(CriarServicoDTORequest servicoDTO) {
        Servico servico = new Servico();
        servico.setNome(servicoDTO.nome());
        servico.setPreco(servicoDTO.preco());
        servico.setStatus(StatusCadastro.CADASTRO_PENDENTE);
        return servico;
    }
}
