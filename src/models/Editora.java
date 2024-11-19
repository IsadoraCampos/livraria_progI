package src.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Definição da classe Editora
 */
public class Editora {

    private String nome;
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    /**
     * Método construtor
     */
    public Editora(String nome) {
        this.nome = nome;
    }

    /**
     * Método @return o nome da Editora
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que adiciona um livro pela Editora
     * recebe como @param Livro e adiciona no array de livros
     */
    public void adicionaLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        }
    }

     /**
     * Método que adiciona o autor pela Editora
     * recebe como @param  Autor e adiciona no array de autores
     */
    public void adicionaAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
        }
    }
}
