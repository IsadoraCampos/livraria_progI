package src;

import src.models.Autor;
import src.models.Ficcao;
import src.models.Genero;
import src.models.Livro;
import src.service.Estoque;

public class teste {
    public static void main(String args[]) {
        Autor vitorHugo = new Autor("Vitor Hugo");
        Genero ficcao = new Ficcao("Ficção");
        Livro bateAsas = new Livro("Bate Asaas", 267, 19, vitorHugo , "Editora", ficcao);

        Estoque estoque = new Estoque();

        vitorHugo.adicionarLivroPorAutor(bateAsas);
        estoque.cadastrarLivro(bateAsas);
        System.out.println(bateAsas.getPreco());
        System.out.println(estoque.pesquisarLivro(bateAsas));
        estoque.excluirLivro(bateAsas);
        System.out.println(estoque.pesquisarLivro(bateAsas));
        System.out.println(estoque.getQuantidadeLivros());

        if (estoque.pesquisarLivro(bateAsas)) {
            System.out.println("O livro está no estoque.");
        } else {
            System.out.println("Livro não disponível no estoque.");
        }
    }
}
