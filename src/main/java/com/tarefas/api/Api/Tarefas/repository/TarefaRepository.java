package com.tarefas.api.Api.Tarefas.repository;

import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
