package com.tarefas.api.Api.Tarefas.entity;

import com.tarefas.api.Api.Tarefas.dto.TarefaDto;
import com.tarefas.api.Api.Tarefas.enun.Prioridade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarefas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Setter
    private boolean realizado;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public Tarefa(TarefaDto dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.prioridade = dados.prioridade();
        this.setRealizado(false);
    }

    public void excluir(){
        this.realizado = true;
    }
}
