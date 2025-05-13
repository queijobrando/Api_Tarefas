package com.tarefas.api.Api.Tarefas.controller;


import com.tarefas.api.Api.Tarefas.dto.DadosAutenticacao;
import com.tarefas.api.Api.Tarefas.entity.Usuario;
import com.tarefas.api.Api.Tarefas.infra.security.DadosRetornoToken;
import com.tarefas.api.Api.Tarefas.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosRetornoToken> fazerLogin(@RequestBody @Valid DadosAutenticacao dados){

        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha()); // converte do Dto para esse UsernamePassword....
        var autenticacao = authenticationManager.authenticate(autenticacaoToken); // Objeto que tem o usuario autenticado

        var token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosRetornoToken(token));
    }

}
