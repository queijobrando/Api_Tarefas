package com.tarefas.api.Api.Tarefas.domain.model;

import com.tarefas.api.Api.Tarefas.api.dto.DadosCadastrarTarefa;
import com.tarefas.api.Api.Tarefas.domain.model.enun.Prioridade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // Não permite o Setter
    private Long id;

    private String nome;
    private String descricao;

    private boolean realizado;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    public void excluir(){
        this.realizado = true;
    }
}
