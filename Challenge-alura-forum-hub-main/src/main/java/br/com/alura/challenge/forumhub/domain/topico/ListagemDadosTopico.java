package br.com.alura.challenge.forumhub.domain.topico;
import java.time.LocalDateTime;

public record ListagemDadosTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String nome,
        String curso
) {

    public ListagemDadosTopico(DetalhamentoDadosTopico topico) {
        this(
                topico.id(),
                topico.titulo(),
                topico.mensagem(),
                topico.dataCriacao(),
                topico.status(),
                topico.autor().nome(),
                topico.curso().nome()
        );
    }
}