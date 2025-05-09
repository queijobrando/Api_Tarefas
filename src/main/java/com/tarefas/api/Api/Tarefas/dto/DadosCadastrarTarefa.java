package com.tarefas.api.Api.Tarefas.dto;

import com.tarefas.api.Api.Tarefas.enun.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTarefa(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        Prioridade prioridade) {
}
