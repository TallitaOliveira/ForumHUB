package br.com.alura.challenge.forumhub.services;

import br.com.alura.challenge.forumhub.domain.curso.Curso;
import br.com.alura.challenge.forumhub.domain.topico.*;
import br.com.alura.challenge.forumhub.domain.usuario.Usuario;
import br.com.alura.challenge.forumhub.repositories.CursoRepository;
import br.com.alura.challenge.forumhub.repositories.TopicosRepository;
import br.com.alura.challenge.forumhub.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    private final TopicosRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicosRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }


    @Transactional
    public DetalhamentoDadosTopico cadastrar(CadastroDadosTopico dados) {
        validarDuplicidade(dados.titulo(), dados.mensagem());

        Usuario autor = buscarUsuarioPorId(dados.idAutor());
        Curso curso = buscarCursoPorId(dados.idCurso());

        Topico topico = new Topico(dados.titulo(), dados.mensagem(), autor, curso);
        topicoRepository.save(topico);

        return new DetalhamentoDadosTopico(topico);
    }

    public Page<ListagemDadosTopico> listar(Pageable paginacao) {
        return topicoRepository.findAllByAtivoTrue(paginacao)
                .map(DetalhamentoDadosTopico::new)
                .map(ListagemDadosTopico::new);
    }

    @Transactional
    public DetalhamentoDadosTopico atualizar(AtualizacaoDadosTopico dados) {
        validarDuplicidade(dados.titulo(), dados.mensagem());

        var topico = topicoRepository.findById(dados.id())
                .orElseThrow(() -> new EntityNotFoundException("Topico com id não encontrado"));
        topico.atualizarInformacoes(dados);

        return new DetalhamentoDadosTopico(topico);
    }

    public DetalhamentoDadosTopico detalhar(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico com id " + id + " não encontrado."));

        return new DetalhamentoDadosTopico(topico);
    }

    @Transactional
    public void excluir(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.Inativar();
    }


    private void validarDuplicidade(String titulo, String mensagem) {
        if (topicoRepository.existsByTituloAndMensagem(titulo, mensagem)) {
            throw new IllegalStateException("Já existe um tópico com o mesmo título e mensagem.");
        }
    }

    private Usuario buscarUsuarioPorId(Long idAutor) {
        return usuarioRepository.findById(idAutor)
                .orElseThrow(() -> new EntityNotFoundException("Autor com id " + idAutor + " não encontrado."));
    }

    private Curso buscarCursoPorId(Long idCurso) {
        return cursoRepository.findById(idCurso)
                .orElseThrow(() -> new EntityNotFoundException("Curso com id " + idCurso + " não encontrado."));
    }


}