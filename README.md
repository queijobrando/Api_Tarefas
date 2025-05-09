# API de Tarefas ✅  
Uma API Java com Spring Boot para gerenciamento de tarefas.

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.4.5-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Connector-lightgrey)

## 📑 Índice
- [Sobre](#sobre)
- [Instalação](#instalação)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#-funcionalidades)
- [Clonando o Projeto](#-clonando-o-projeto)

## 📖 Sobre

A **API de Tarefas** é uma aplicação backend desenvolvida em Java com Spring Boot, projetada para gerenciar tarefas de forma simples e eficiente. Possui endpoints REST para cadastro, listagem paginada, detalhamento e atualização de tarefas, com documentação gerada automaticamente via Swagger/OpenAPI.

## 🤖 Funcionalidades

- ✅ Cadastro de novas tarefas  
- 📄 Listagem paginada de tarefas (10 por página)
- 🔍 Detalhamento de tarefa por ID  
- ✏️ Atualização de dados da tarefa  
- ❌ Tratamento de erros e mensagens de validação  
- 📖 Documentação automática com Swagger

## 🧩 Estrutura do Projeto

### 📦 DTOs
- **DadosCadastrarTarefa** – dados obrigatórios para cadastro
- **DadosListagemTarefa** – visualização simplificada das tarefas
- **DadosDetalhamentoTarefa** – retorno completo com todos os dados
- **DadosAtualizarTarefa** – payload para atualização de tarefa

### 🧠 Service
- **TarefaService** – regra de negócio para cadastro, listagem e detalhamento de tarefas

### 🏷️ Entity
- **Tarefa** – entidade principal com campos como `nome`, `descrição`, `prioridade` e `realizado`

### 📚 Repository
- **TarefaRepository** – interface JPA para acesso ao banco de dados

### 🛡️ Infra
- **TratadorDeErros** – trata exceções como `404 Not Found` e `400 Bad Request`

### 🎯 Controller
- **TarefaController** – expõe os endpoints REST da API
  - `@GetMapping`: Lista tarefas paginadas
  - `@PostMapping`: Cadastra nova tarefa
  - `@PutMapping`: Atualiza tarefa
  - `@GetMapping("/{id}")`: Detalha uma tarefa por ID

## ⚙️ Tecnologias

- Java 21  
- Spring Boot 3.4.5  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Lombok  
- Swagger (springdoc-openapi)  

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
