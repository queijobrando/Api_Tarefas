package com.tarefas.api.Api.Tarefas.domain.service;

import com.tarefas.api.Api.Tarefas.api.dto.DadosAtualizarTarefa;
import com.tarefas.api.Api.Tarefas.api.dto.DadosDetalhamentoTarefa;
import com.tarefas.api.Api.Tarefas.api.dto.DadosListagemTarefa;
import com.tarefas.api.Api.Tarefas.api.dto.DadosCadastrarTarefa;
import com.tarefas.api.Api.Tarefas.api.mapper.TarefaMapper;
import com.tarefas.api.Api.Tarefas.domain.model.Tarefa;
import com.tarefas.api.Api.Tarefas.infra.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    @Transactional
    public Tarefa cadastrarTarefa(DadosCadastrarTarefa dados){
        Tarefa tarefa = tarefaMapper.cadastroToTarefa(dados);


        return tarefaRepository.save(tarefa);
    }

    public Tarefa carregarTarefa(Long id){
        return tarefaRepository.getReferenceById(id);
    }

    /*
    public List<DadosDetalhamentoTarefa> listarTarefas(){
        return  tarefaRepository.findAll().stream().map(DadosDetalhamentoTarefa::new).toList();
    }

     .stream() Transforma a lista em uma sequencia de elementos(quero trabalhar item por item, em cadeia)
     .map() Transforma cada elemento do stream, ou seja, para cada Tarefa na lista, crie um novo DadosDetalhamentoTarefa(tarefa)
     .toList() coleta os resultados e transforma em uma nova lista
     */

    public Page<DadosListagemTarefa> listarTarefas(Pageable paginacao){
        return tarefaRepository.findAll(paginacao).map(DadosListagemTarefa::new);
    }

    public Tarefa atualizarTarefa(Long id, DadosAtualizarTarefa dados){
        Tarefa tarefa = tarefaRepository.getReferenceById(id);

        tarefaMapper.atualizarTarefa(dados, tarefa);

        return tarefa;
    }
}
