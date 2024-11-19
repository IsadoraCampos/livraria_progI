package src.models;

import src.service.ClienteOperacoes;

/**
 * Definição da classe ClienteNormal que estende a classe Cliente
 */
public class ClienteNormal extends Cliente {


    public ClienteNormal(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    /**
     * Método que mostras as informações do Cliente
     */
    @Override
    public void printCliente() {
        System.out.println("----------------------------------------------");
        System.out.println("CLIENTE NORMAL");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Número de compras: " + this.getNumeroCompras());
        System.out.println("----------------------------------------------");
    }


    /**
     * Método que calculo o preço do Livro para o ClienteNormal
     * recebe como @param Livro e @return o preço total
     */
    @Override
    public double calculaPreco(Livro livro) {
        return livro.getPreco();
    }
}
