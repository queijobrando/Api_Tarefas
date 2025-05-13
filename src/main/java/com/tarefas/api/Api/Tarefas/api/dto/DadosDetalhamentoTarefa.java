package com.tarefas.api.Api.Tarefas.api.dto;

import com.tarefas.api.Api.Tarefas.domain.model.Tarefa;
import com.tarefas.api.Api.Tarefas.domain.model.enun.Prioridade;

public record DadosDetalhamentoTarefa(Long id,
                                      String nome,
                                      String descricao,
                                      Prioridade prioridade,
                                      boolean realizado) {
}
