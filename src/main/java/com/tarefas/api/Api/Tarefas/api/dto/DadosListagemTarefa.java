package com.tarefas.api.Api.Tarefas.api.dto;

import com.tarefas.api.Api.Tarefas.domain.model.Tarefa;
import com.tarefas.api.Api.Tarefas.domain.model.enun.Prioridade;

public record DadosListagemTarefa(String nome,
                                  String descricao,
                                  Prioridade prioridade,
                                  boolean realizado) {

    public DadosListagemTarefa(Tarefa tarefa) {
        this(tarefa.getNome(), tarefa.getDescricao(), tarefa.getPrioridade(),
                tarefa.isRealizado()); // condição ? valor_se_verdadeiro : valor_se_falso;

    }
}