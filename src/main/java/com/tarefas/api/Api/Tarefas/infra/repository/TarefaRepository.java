package com.tarefas.api.Api.Tarefas.infra.repository;

import com.tarefas.api.Api.Tarefas.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
