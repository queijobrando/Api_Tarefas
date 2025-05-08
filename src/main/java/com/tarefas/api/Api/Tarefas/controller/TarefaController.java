package com.tarefas.api.Api.Tarefas.controller;

import com.tarefas.api.Api.Tarefas.dto.DadosAtualizarTarefa;
import com.tarefas.api.Api.Tarefas.dto.DadosDetalhamentoTarefa;
import com.tarefas.api.Api.Tarefas.dto.DadosListagemTarefa;
import com.tarefas.api.Api.Tarefas.dto.DadosCadastrarTarefa;
import com.tarefas.api.Api.Tarefas.entity.Tarefa;
import com.tarefas.api.Api.Tarefas.service.TarefaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTarefa> cadastrarTarefa(@RequestBody @Valid DadosCadastrarTarefa dados,
                                                                   UriComponentsBuilder uriComponentsBuilder){
        Tarefa tarefa = tarefaService.cadastrarTarefa(dados);

        var uri = uriComponentsBuilder.path("tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTarefa(tarefa));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTarefa>> listarTarefas(@PageableDefault(size= 10, sort = {"nome"}) Pageable paginacao){
         return ResponseEntity.ok(tarefaService.listarTarefas(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTarefa> visualizarTarefa(@PathVariable Long id){
        var tarefa = tarefaService.carregarTarefa(id);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> editarTarefa(@PathVariable Long id, @RequestBody DadosAtualizarTarefa dados){
        var tarefa = tarefaService.carregarTarefa(id);

        tarefa.atualizarTarefa(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> concluirTarefa(@PathVariable Long id){
        var tarefa = tarefaService.carregarTarefa(id);

        tarefa.excluir();

        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }
}
