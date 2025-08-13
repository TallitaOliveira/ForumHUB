package br.com.alura.challenge.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CadastroDadosTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long idAutor,

        @NotNull
        Long idCurso
) {}