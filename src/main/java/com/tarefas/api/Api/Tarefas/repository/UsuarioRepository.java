package com.tarefas.api.Api.Tarefas.repository;

import com.tarefas.api.Api.Tarefas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login); // metodo consulta do usuario no Banco de Dados
}
