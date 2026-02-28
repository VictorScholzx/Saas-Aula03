package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.BibliotecaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return bibliotecaService.listarTodos();
    }

    @GetMapping("/disponiveis")
    public List<Livro> listarDisponiveis(){
        return bibliotecaService.listarDisponiveis();
    }

    @GetMapping("/indisponiveis")
    public List<Livro> listarIndisponiveis(){
        return bibliotecaService.listarIndisponiveis();
    }

    @GetMapping("/{id}/emprestar")
    public String emprestar(@PathVariable Long id){
        return bibliotecaService.emprestarLivro(id);
    }

    @GetMapping("/{id}/devolver")
    public String devolver(@PathVariable Long id){
        return bibliotecaService.devolverLivro(id);
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return bibliotecaService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return bibliotecaService.buscarPorTitulo(titulo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        return bibliotecaService.cadastrarLivro(livro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        bibliotecaService.removerLivro(id);
    }
}
