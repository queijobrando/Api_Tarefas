package com.tarefas.api.Api.Tarefas.config.security.filter;

import com.tarefas.api.Api.Tarefas.infra.repository.UsuarioRepository;
import com.tarefas.api.Api.Tarefas.config.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public SecurityFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);//Recupera o token do cabeçalho

        // Se tem cabeçalho
        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT); //verifica o Token
            var usuario = usuarioRepository.findByLogin(subject);//Valida se ta correto e pega usuario

            var authetication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authetication); //autentica
        }

        // Segue o fluxo de filtros
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization"); //Recupera o header da requisição

        if (authorizationHeader != null){
            return authorizationHeader.replace("Bearer", "").trim();
        }

        return null ;
    }
}
