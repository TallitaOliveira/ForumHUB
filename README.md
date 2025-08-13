# 📚 Forum Hub — Desafio Alura

![status](https://img.shields.io/badge/status-concluído-green) 
![java](https://img.shields.io/badge/Java-21-blue)
![spring](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![licença](https://img.shields.io/badge/licença-MIT-lightgrey)

## 📝 Visão Geral

O **Forum Hub** é uma API REST construída como parte do desafio proposto no programa **Alura + Oracle Next Education (ONE)**.  
O sistema simula o funcionamento de um fórum, permitindo o gerenciamento de tópicos, cursos e usuários, com autenticação segura baseada em **JWT** e acesso controlado por permissões.

A aplicação foi desenvolvida com **Java** e **Spring Boot**, aplicando conceitos de segurança, boas práticas de desenvolvimento, organização em camadas e persistência de dados com JPA.

---

## ⚡ Recursos Disponíveis

- **🔐 Autenticação JWT** — Login seguro e sem estado (stateless) utilizando JSON Web Tokens.
- **🛡 Controle de Permissões** — Endpoints restritos a usuários autenticados.
- **🗂 Operações com Tópicos**:
  - Criação de novos tópicos.
  - Listagem de todos os tópicos ou de um específico.
  - Atualização e exclusão de tópicos existentes.
- **✅ Validações de Negócio** — Prevenção de duplicidade de tópicos com mesmo título e conteúdo.
- **💾 Persistência** — Armazenamento de dados com **Spring Data JPA** e banco relacional.

---

## 🛠 Stack Tecnológica

| Ferramenta/Lib  | Função no Projeto |
|-----------------|-------------------|
| **Java 21**     | Linguagem utilizada. |
| **Spring Boot 3** | Framework principal para criação da API. |
| **Spring Security** | Implementação da autenticação/autorização. |
| **JPA / Hibernate** | Mapeamento objeto-relacional. |
| **Maven** | Gerenciamento de dependências e build. |
| **Lombok** | Geração automática de código repetitivo. |
| **MySQL / H2** | Banco de dados relacional. |
| **JWT** | Geração e validação de tokens de autenticação. |

---

## 🚀 Como Rodar o Projeto

1. **Clonar o repositório**
   ```bash
   git clone git@github.com:TallitaOliveira/ForumHUB.git
   ```

2. **Entrar na pasta**
   ```bash
   cd NOME_REPOSITORIO
   ```

3. **Instalar dependências**
   ```bash
   mvn install
   ```

4. **Executar a aplicação**
   ```bash
   mvn spring-boot:run
   ```

---

## 🔑 Autenticação e Uso

- Primeiro, faça login enviando suas credenciais:
  ```
  POST /login
  ```
- O sistema retornará um token JWT.
- Inclua o token no cabeçalho das requisições:
  ```
  Authorization: Bearer SEU_TOKEN
  ```

---

## 📌 Estrutura de Pastas

```
src/main/java/br/com/alura/challenge/forumhub
│
├── controllers      # Endpoints REST
├── domain           # Entidades e regras de negócio
├── infra            # Configurações de segurança e tratamento de erros
└── repositories     # Interfaces JPA
```

---

## 📄 Licença

Este projeto está licenciado sob os termos da licença **MIT**.
