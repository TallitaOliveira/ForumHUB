package br.com.alura.challenge.forumhub.domain.topico;

public record AtualizacaoDadosTopico(Long id,
                                     String titulo,
                                     String mensagem,
                                     String idAutor,
                                     String idCurso) {
}
