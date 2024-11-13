package src.models;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private Editora editora;
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, Editora editora) {
        this.nome = nome;
        this.editora = editora;
    }

    public void adicionarLivroPorAutor(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        } else {
            System.out.println("Livro já está associado ao autor(a).");
        }
    }
    
    public String getNome() {
        return this.nome;
    }

    public Editora getEditora() {
        return this.editora;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
