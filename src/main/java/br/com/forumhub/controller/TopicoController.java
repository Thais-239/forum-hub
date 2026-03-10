package br.com.forumhub.controller;

import br.com.forumhub.dto.DadosCadastroTopico;
import br.com.forumhub.dto.DadosListagemTopico;
import br.com.forumhub.dto.DadosAtualizacaoTopico;
import br.com.forumhub.model.Topico;
import br.com.forumhub.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public Page<DadosListagemTopico> listar(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(DadosListagemTopico::new);
    }

    @PostMapping
    public ResponseEntity<Topico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {

        if(repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())){
            return ResponseEntity.badRequest().build();
        }

        Topico topico = new Topico();

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setAutor(dados.autor());
        topico.setCurso(dados.curso());

        repository.save(topico);

        return ResponseEntity.status(201).body(topico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalhar(@PathVariable Long id) {

        var topico = repository.findById(id);

        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {

        Topico topico = repository.findById(id).orElse(null);

        if (topico != null) {

            if (dados.titulo() != null) {
                topico.setTitulo(dados.titulo());
            }

            if (dados.mensagem() != null) {
                topico.setMensagem(dados.mensagem());
            }

            if (dados.autor() != null) {
                topico.setAutor(dados.autor());
            }

            if (dados.curso() != null) {
                topico.setCurso(dados.curso());
            }

            return repository.save(topico);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
