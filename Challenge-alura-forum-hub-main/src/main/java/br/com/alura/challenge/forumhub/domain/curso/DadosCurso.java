package br.com.alura.challenge.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
                         @NotBlank
                         String nome,
                         String categoria) {
    public DadosCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
