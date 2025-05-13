package com.tarefas.api.Api.Tarefas.api.dto;

import com.tarefas.api.Api.Tarefas.domain.model.enun.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTarefa(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        Prioridade prioridade) {
}
