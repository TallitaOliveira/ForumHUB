package br.com.alura.challenge.forumhub.repository;

import br.com.alura.challenge.forumhub.domain.categoria.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
