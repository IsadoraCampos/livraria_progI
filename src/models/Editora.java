package src.models;

import java.util.ArrayList;
import java.util.List;

public class Editora {

    private String nome;
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    public Editora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionaLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        }
    }

    public void adicionaAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
        }
    }
}
