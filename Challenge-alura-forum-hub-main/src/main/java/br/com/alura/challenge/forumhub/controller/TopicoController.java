package br.com.alura.challenge.forumhub.controller;

import br.com.alura.challenge.forumhub.domain.topico.AtualizacaoDadosTopico;
import br.com.alura.challenge.forumhub.domain.topico.CadastroDadosTopico;
import br.com.alura.challenge.forumhub.domain.topico.DetalhamentoDadosTopico;
import br.com.alura.challenge.forumhub.domain.topico.ListagemDadosTopico;
import br.com.alura.challenge.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DetalhamentoDadosTopico> cadastrar(@RequestBody @Valid CadastroDadosTopico dados, UriComponentsBuilder uriBuilder) {

        DetalhamentoDadosTopico detalhamentoDto = topicoService.cadastrar(dados);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(detalhamentoDto.id()).toUri();

        return ResponseEntity.created(uri).body(detalhamentoDto);
    }
    @GetMapping
    public ResponseEntity<Page<ListagemDadosTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = topicoService.listar(paginacao);
        return ResponseEntity.ok(page);

    }
    @PutMapping
    public ResponseEntity<DetalhamentoDadosTopico> atualizar(@RequestBody @Valid AtualizacaoDadosTopico dados) {
        var topicoAtualizado = topicoService.atualizar(dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoService.detalhar(id);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        topicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}