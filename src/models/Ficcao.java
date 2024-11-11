package src.models;

import src.service.CalculaPrecoLivro;

public class Ficcao extends Genero implements CalculaPrecoLivro {

    public Ficcao(String nome) {
        super(nome);
    }

    @Override
    public double calculaPreco(Livro livro) {
        return 34.99;
    }
}
