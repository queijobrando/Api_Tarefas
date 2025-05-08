package com.tarefas.api.Api.Tarefas.controller;

import com.tarefas.api.Api.Tarefas.dto.DadosDetalhamentoTarefa;
import com.tarefas.api.Api.Tarefas.dto.TarefaDto;
import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import com.tarefas.api.Api.Tarefas.service.TarefaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTarefa> cadastrarTarefa(@RequestBody @Valid TarefaDto dados,
                                                                   UriComponentsBuilder uriComponentsBuilder){
        Tarefa tarefa = tarefaService.cadastrarTarefa(dados);

        var uri = uriComponentsBuilder.path("tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTarefa(tarefa));

    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTarefa>> listarTarefas(){
         List<DadosDetalhamentoTarefa> tarefas =  tarefaService.listarTarefas();
         return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> concluirTarefa(@PathVariable Long id){
        var tarefa = tarefaService.carregarTarefa(id);

        tarefa.excluir();

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }
}
