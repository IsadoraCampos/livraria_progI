package src.service;

import src.models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definição da classe Estoque
 */
public class Estoque {
    private List<Livro> listaLivrosDisponiveis = new ArrayList<>();
  
    /**
     * Método que 
     * @return a lista de livros disponíveis
     */
    public List<Livro> getListaLivrosDisponiveis() {
        return listaLivrosDisponiveis;
    }

    /**
     * Método que cadastra um Livro no Estoque
     * recebe como @param livro 
     */
    public void cadastrarLivro(Livro livro) {
        if (!listaLivrosDisponiveis.contains(livro)) {
           listaLivrosDisponiveis.add(livro);
        } else {
            System.out.println("O livro já está cadastrado!");
        }
    }

    /**
     * Método que procura um Livro
     * recebe como @param titulo
     * e @param autor
     * e @param editora
     * e @return o Livro
     */
    public Livro encontraLivro(String titulo, String autor, String editora) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(livro.getTitulo(), titulo) &&
                        Objects.equals(livro.getAutor().getNome(), autor) &&
                        Objects.equals(livro.getEditora().getNome(), editora)) {
                    return livro;
            }
        }
        return null;
    }

    /**
     * Método que verifica se um título de Livro existe
     * recebe como @param titulo
     * e @return um valor booleano
     */
    public boolean tituloExiste(String titulo) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(titulo, livro.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que verifica se um Autor existe
     * recebe como @param autor
     * e @return um valor booleano
     */
    public boolean autorExiste(String autor) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(autor, livro.getAutor().getNome())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que verifica se uma Editora existe
     * recebe como @param editora
     * e @return um valor booleano
     */
    public boolean editoraExiste(String editora) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(editora, livro.getEditora().getNome())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que procura todos os livros pelo título
     * recebe como @param titulo
     */
    public void getLivroPorTitulo(String titulo) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getTitulo(), titulo)){
                livro.printLivro();
            }
        }
    }

    /**
     * Método que procura todos os livros pelo autor
     * recebe como @param autor
     */
    public void getLivrosPorAutor(String autor) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getAutor().getNome(), autor)){
                livro.printLivro();
            }
        }
    }

    /**
     * Método que procura todos os livros pela editora
     * recebe como @param editora
     */
    public void getLivrosPorEditora(String editora) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getEditora().getNome(), editora)){
                livro.printLivro();
            }
        }
    }

    /**
     * Método que procura todos os livros
     */
    public void getTodosOsLivros() {
        for (Livro livro : listaLivrosDisponiveis) {
            livro.printLivro();
        }
    }

    /**
     * Método que repõem um Livro no Estoque
     * recebe como @param titulo
     *e  @param autor
     * e @param editora
     * e @param quantidade
     */
    public void reporLivro(String titulo, String autor, String editora, int quantidade) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(livro.getTitulo(), titulo) &&
                    Objects.equals(livro.getAutor().getNome(), autor) &&
                    Objects.equals(livro.getEditora().getNome(), editora)) {
                if (listaLivrosDisponiveis.contains(livro)) {
                    livro.reporLivro(quantidade);
                }
            }
        }
    }

    /**
     * Método que vende um Livro
     * recebe como @param livro
     * e @param quantidade
     */
    public void venderLivro(Livro livro) {

        if (livro != null) {
            if (listaLivrosDisponiveis.contains(livro)) {
                livro.venderLivro();
            } else {
                System.out.println("Este livro não está cadastrado");
            }
        }
    }

    /**
     * Método que exclui um Livro
     * recebe como @param titulo
     * e @param autor
     * e @param editora 
     * e remove do array de livros disponíveis
     */
    public void excluirLivro(String titulo, String autor, String editora) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(livro.getTitulo(), titulo) &&
                    Objects.equals(livro.getAutor().getNome(), autor) &&
                    Objects.equals(livro.getEditora().getNome(), editora)) {
                if (listaLivrosDisponiveis.contains(livro)) {
                    listaLivrosDisponiveis.remove(livro);
                    System.out.println("Livro removido do estoque com sucesso!");
                } else {
                    System.out.println("O livro não existe no estoque!");
                }
            }
        }

    }
}
