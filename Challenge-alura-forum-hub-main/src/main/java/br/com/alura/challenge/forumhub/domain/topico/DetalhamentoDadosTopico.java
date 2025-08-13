package br.com.alura.challenge.forumhub.domain.topico;
import br.com.alura.challenge.forumhub.domain.curso.DadosCurso;
import br.com.alura.challenge.forumhub.domain.usuario.DadosUsuario;
import java.time.LocalDateTime;

public record DetalhamentoDadosTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        DadosUsuario autor,
        DadosCurso curso
) {
    public DetalhamentoDadosTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new DadosUsuario(topico.getAutor()),
                new DadosCurso(topico.getCurso())
        );
    }
}
