package src.service;

import src.models.Livro;

/**
 * Definição da interface ClienteOperacoes
 */
public interface ClienteOperacoes {

    /**
     * Método que mostra as informações do Cliente
     */
    public void printCliente();

    /**
     * Método que calcula o preço do Livro
     * recebe como @param livro
     * e @return o preço do Livro
     */
    public double calculaPreco(Livro livro);
}
