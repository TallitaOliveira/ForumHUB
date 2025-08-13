package br.com.alura.challenge.forumhub.repositories;

import br.com.alura.challenge.forumhub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicosRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
