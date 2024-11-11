package src.models;

import src.service.CalculaPrecoLivro;

public class TerrorSuspense extends Genero implements CalculaPrecoLivro {
    public TerrorSuspense(String nome) {
        super(nome);
    }

    @Override
    public double calculaPreco(Livro livro) {
        return 49.99;
    }
}
