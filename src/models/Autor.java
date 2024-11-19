package src.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Definição da classe Autor
 */

public class Autor {
    private String nome;
    private Editora editora;
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, Editora editora) {
        this.nome = nome;
        this.editora = editora;
    }

    /**
     * Método que adiciona um livro relacionado com o autor
     * recebe um @param livro e guarda em um array de Livros
     */
    public void adicionarLivroPorAutor(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        } else {
            System.out.println("Livro já está associado ao autor(a).");
        }
    }
    
    /**
     * Método @return o nome do Autor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método @return o nome da Editora
     */
    public Editora getEditora() {
        return this.editora;
    }

    /**
     * Método @return os Livros do Autor
     */
    public List<Livro> getLivros() {
        return livros;
    }
}
