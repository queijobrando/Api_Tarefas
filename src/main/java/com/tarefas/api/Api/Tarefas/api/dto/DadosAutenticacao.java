package com.tarefas.api.Api.Tarefas.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String login,

        @NotBlank
        String senha) {
}
