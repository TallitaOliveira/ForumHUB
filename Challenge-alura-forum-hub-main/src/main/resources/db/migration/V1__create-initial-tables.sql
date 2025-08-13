-- Tabela de Usuários: Entidade principal para autenticação e autoria.
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabela de Perfis: Define os papéis/permissões dos usuários (Ex: ADMIN, ALUNO).
CREATE TABLE perfis (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

-- Tabela de Junção para o relacionamento N:N entre Usuários e Perfis.
CREATE TABLE usuario_perfis (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);

-- Tabela de Cursos: Organiza os tópicos por área de estudo.
CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabela de Tópicos: A entidade central do fórum.
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Tabela de Respostas: Respostas associadas a um tópico.
CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    solucao BOOLEAN DEFAULT FALSE,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
);