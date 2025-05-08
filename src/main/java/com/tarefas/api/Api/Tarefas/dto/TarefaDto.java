package com.tarefas.api.Api.Tarefas.dto;

import com.tarefas.api.Api.Tarefas.enun.Prioridade;

public record TarefaDto(String nome,
                        String descricao,
                        Prioridade prioridade) {
}
