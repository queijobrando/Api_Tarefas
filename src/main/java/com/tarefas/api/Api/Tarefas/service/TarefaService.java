package com.tarefas.api.Api.Tarefas.service;

import com.tarefas.api.Api.Tarefas.dto.TarefaDto;
import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import com.tarefas.api.Api.Tarefas.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public Tarefa cadastrarTarefa(TarefaDto dados){
        Tarefa tarefa = new Tarefa(dados);

        return tarefaRepository.save(tarefa);
    }
}
