package com.tarefas.api.Api.Tarefas.infra.repository;

import com.tarefas.api.Api.Tarefas.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login); // metodo consulta do usuario no Banco de Dados
}
