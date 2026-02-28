package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BibliotecaRepository {

    private final List<Livro> livros = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public BibliotecaRepository() {
        save(new Livro(null, "Dom Casmurro", "Machado de Assis", 1899, "9788535910663", true));
        save(new Livro(null, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "9788533613379", true));
        save(new Livro(null, "1984", "George Orwell", 1949, "9788535914845", false));
    }

    public Livro save(Livro livro) {
        if (livro.getId() == null) {
            livro.setId(sequence.incrementAndGet());
            livros.add(livro);
            return livro;
        }

        deleteById(livro.getId());
        livros.add(livro);
        return livro;
    }

    public List<Livro> findAll() {
        return new ArrayList<>(livros);
    }

    public Optional<Livro> findById(Long id) {
        return livros.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst();
    }

    public List<Livro> findByTitulo(String titulo) {
        String termo = titulo.toLowerCase();
        return livros.stream()
                .filter(livro -> livro.getTitulo() != null && livro.getTitulo().toLowerCase().contains(termo))
                .toList();
    }

    public List<Livro> findByDisponivel(boolean disponivel) {
        return livros.stream()
                .filter(livro -> livro.getDisponivel() != null  && livro.getDisponivel() == disponivel)
                .toList();
    }

    public void deleteById(Long id) {
        livros.removeIf(livro -> livro.getId().equals(id));
    }
}
