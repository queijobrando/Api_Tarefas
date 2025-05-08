package com.tarefas.api.Api.Tarefas.dto;

import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import com.tarefas.api.Api.Tarefas.enun.Prioridade;

public record DadosDetalhamentoTarefa(Long id,
                                      String nome,
                                      String descricao,
                                      Prioridade prioridade,
                                      String realizado) {

    public DadosDetalhamentoTarefa(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getPrioridade(),
                tarefa.isRealizado() ? "Sim" : "Não"); // condição ? valor_se_verdadeiro : valor_se_falso;

    }
}
