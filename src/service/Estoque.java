package src.service;

import src.models.Autor;
import src.models.ClienteNormal;
import src.models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estoque {
    private static int quantidadeLivros;
    private List<Livro> listaLivrosDisponiveis = new ArrayList<>();
   // private boolean disponivel; quando um livro é cadastrado, ele recebe o código de disponível (melhorar esta parte)

    public void cadastrarLivro(Livro livro) {
        if (!listaLivrosDisponiveis.contains(livro)) {
           listaLivrosDisponiveis.add(livro);
           quantidadeLivros += 1;
        } else {
            System.out.println("O livro já está cadastrado!");
        }
    }


    //REVER MÉTODOOO
    public Livro findLivro(String titulo, String autor, String editora, int quantidade) {
        try {
            for (Livro livro : listaLivrosDisponiveis) {
                if (Objects.equals(livro.getTitulo(), titulo) &&
                        Objects.equals(livro.getAutor().getNome(), autor) &&
                        Objects.equals(livro.getEditora().getNome(), editora)) {
                    return livro;
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Livro não encontrado");
        }
        return null;
    }

    public void getLivroPorTitulo(String titulo) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getTitulo(), titulo)){
                livro.printLivro();
            }
        }
    }

    public void getLivrosPorAutor(String autor) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getAutor().getNome(), autor)){
                livro.printLivro();
            }
        }
    }

    public void getLivrosPorEditora(String editora) {
        for (Livro livro : listaLivrosDisponiveis){
            if (Objects.equals(livro.getEditora().getNome(), editora)){
                livro.printLivro();
            }
        }
    }

    public void getTodosOsLivros() {
        for (Livro livro : listaLivrosDisponiveis) {
            livro.printLivro();
        }
    }

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

    public Livro encontraLivro(String titulo, String autor, String editora, int quantidade) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(livro.getTitulo(), titulo) &&
                    Objects.equals(livro.getAutor().getNome(), autor) &&
                    Objects.equals(livro.getEditora().getNome(), editora)) {
                return livro;
            }
        }
        return null;
    }

    public void venderLivro(Livro livro, int quantidade) {

        if (livro != null) {
            if (listaLivrosDisponiveis.contains(livro)) {
                livro.venderLivro(quantidade);
            } else {
                System.out.println("Este livro não está cadastrado");
            }
        }
    }
    public void excluirLivro(String titulo, String autor, String editora) {
        for (Livro livro : listaLivrosDisponiveis) {
            if (Objects.equals(livro.getTitulo(), titulo) &&
                    Objects.equals(livro.getAutor().getNome(), autor) &&
                    Objects.equals(livro.getEditora().getNome(), editora)) {
                if (listaLivrosDisponiveis.contains(livro)) {
                    listaLivrosDisponiveis.remove(livro);
                    quantidadeLivros -= 1;
                    System.out.println("Livro removido do estoque com sucesso!");
                } else {
                    System.out.println("O livro não existe no estoque!");
                }
            }
        }

    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public boolean pesquisarLivro(Livro livro) {
        return listaLivrosDisponiveis.contains(livro); //Retorna true se o livro existe, false o contrário
    }
}
