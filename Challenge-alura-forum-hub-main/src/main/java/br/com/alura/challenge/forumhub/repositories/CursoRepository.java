package br.com.alura.challenge.forumhub.repositories;

import br.com.alura.challenge.forumhub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
