package com.tarefas.api.Api.Tarefas.service;

import com.tarefas.api.Api.Tarefas.dto.DadosListagemTarefa;
import com.tarefas.api.Api.Tarefas.dto.DadosCadastrarTarefa;
import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import com.tarefas.api.Api.Tarefas.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public Tarefa cadastrarTarefa(DadosCadastrarTarefa dados){
        Tarefa tarefa = new Tarefa(dados);

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
}
