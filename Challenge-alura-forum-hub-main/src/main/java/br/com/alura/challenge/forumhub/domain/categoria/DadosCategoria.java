package br.com.alura.challenge.forumhub.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCategoria(
                         @NotBlank
                         String nome,
                         String categoria) {
    public DadosCategoria(Categorias categorias) {
        this(categorias.getNome(), categorias.getCategoria());
    }
}
