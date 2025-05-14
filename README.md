# API de Tarefas ✅  
Uma API Java com Spring Boot para gerenciamento de tarefas.

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.4.5-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Connector-lightgrey)

## 📖 Sobre

A **API de Tarefas** é uma aplicação backend desenvolvida em Java com Spring Boot, projetada para gerenciar tarefas de forma simples e eficiente. Possui endpoints REST para cadastro, listagem paginada, detalhamento e atualização de tarefas, com documentação gerada automaticamente via Swagger/OpenAPI.

## 🤖 Funcionalidades

- ✅ Cadastro de novas tarefas  
- 📄 Listagem paginada de tarefas (10 por página)
- 🔍 Detalhamento de tarefa por ID  
- ✏️ Atualização de dados da tarefa 
- 👤 Cadastro e login de usuários
- 🔐 Autenticação JWT
- ❌ Tratamento de erros e mensagens de validação  
- 📖 Documentação automática com Swagger

## 🧩 Estrutura do Projeto

### 📦 DTOs
- **Tarefa**
  - `DadosCadastrarTarefa` – dados obrigatórios para cadastro
  - `DadosListagemTarefa` – visualização simplificada
  - `DadosDetalhamentoTarefa` – retorno completo
  - `DadosAtualizarTarefa` – payload para atualização

- **Usuário**
  - `DadosCadastroUsuario` – para cadastro de novos usuários
  - `DadosAutenticacao` – para login
  - `DadosTokenJWT` – resposta ao login

### 🧠 Service
- **TarefaService** – regra de negócio para tarefas, experiência e nível
- **UsuarioService** – autenticação, cadastro e perfil do usuário

### 🏷️ Entity
- **Tarefa** – entidade principal com campos como `nome`, `descrição`, `prioridade` e `realizado`
- **Usuario** – usuario, senha

### 📚 Repository
- **TarefaRepository** – interface JPA para acesso ao banco de dados
- **UsuarioRepository** – interface JPA para usuários

### 🛡️ Infra
- **TratadorDeErros** – tratamento de exceções (404, 400 etc)
- **TokenService** – geração e validação de JWT
- **SecurityFilter** – autenticação via token nos endpoints

### 🎯 Controller
- **TarefaController** – expõe os endpoints REST da API
  - `@GetMapping`: Lista tarefas paginadas
  - `@PostMapping`: Cadastra nova tarefa
  - `@PutMapping`: Atualiza tarefa
  - `@GetMapping("/{id}")`: Detalha uma tarefa por ID

- **UsuarioController**
  - `@PostMapping("/login")` – Login do usuário

## ⚙️ Tecnologias

- Java 21
- Spring Boot 3.4.5
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Swagger (springdoc-openapi)
- JWT (Autenticação) 

## 💻 Instalação

### 🔹 Pré-requisitos
- Java 21 instalado  
- MySQL  
- Maven

### 🔹 Configuração do Banco
Configure o `application.properties` ou `application.yml` com as credenciais do seu banco:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 📖 Documentação Swagger
`http://localhost:8080/swagger-ui.html`

## 🔐 Segurança
A autenticação é baseada em JWT. Após o login, o token deve ser enviado no cabeçalho das requisições:

`Authorization: Bearer SEU_TOKEN_AQUI`
