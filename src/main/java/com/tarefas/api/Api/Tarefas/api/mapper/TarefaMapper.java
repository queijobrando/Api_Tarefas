package com.tarefas.api.Api.Tarefas.api.mapper;


import com.tarefas.api.Api.Tarefas.api.dto.DadosAtualizarTarefa;
import com.tarefas.api.Api.Tarefas.api.dto.DadosCadastrarTarefa;
import com.tarefas.api.Api.Tarefas.api.dto.DadosDetalhamentoTarefa;
import com.tarefas.api.Api.Tarefas.domain.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    DadosDetalhamentoTarefa tarefaToDetalhamento(Tarefa tarefa);

    Tarefa cadastroToTarefa(DadosCadastrarTarefa dadosCadastrarTarefa);

    //metodo para Atualizar Tarefa
    void atualizarTarefa(DadosAtualizarTarefa dados, @MappingTarget Tarefa tarefa);

}
