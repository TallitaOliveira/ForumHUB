package br.com.alura.challenge.forumhub.domain.topico;

import br.com.alura.challenge.forumhub.domain.curso.Curso;
import br.com.alura.challenge.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Boolean ativo;

    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESOLVIDO;
    }

    public void atualizarInformacoes(AtualizacaoDadosTopico dados) {
        if (dados.titulo() != null && !dados.titulo().isBlank()) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null && !dados.mensagem().isBlank()) {
            this.mensagem = dados.mensagem();
        }
    }
    public void Inativar(){
        this.ativo = false;
    }

}