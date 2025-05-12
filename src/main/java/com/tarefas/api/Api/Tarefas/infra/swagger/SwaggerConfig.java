package com.tarefas.api.Api.Tarefas.infra.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("API Gerenciamento de Tarefas").version("1.0.0")
                .description("Uma API para gerenciamento de tarefas"));

    }

}
