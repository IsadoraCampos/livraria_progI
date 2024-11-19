package src.models;

import src.service.ClienteOperacoes;

/**
 * Definição da classe ClienteVIP que estende a classe Cliente
 */
public class ClienteVIP extends Cliente {

    private double desconto;
    public ClienteVIP(String nome, String cpf, String telefone,int numeroCompras) {
        super(nome, cpf, telefone, numeroCompras);
        this.desconto = 5;
    }

    /**
     *  Método que mostras as informações do Cliente
     */
    @Override
    public void printCliente() {
        System.out.println("----------------------------------------------");
        System.out.println("CLIENTE VIP");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Número de compras: " + this.getNumeroCompras());
        System.out.println("----------------------------------------------");
    }

    /**
     * Método que calculo o preço do Livro para o ClienteVIP
     * recebe como @param Livro e @return o desconto 
     */
    @Override
    public double calculaPreco(Livro livro) {
        return livro.getPreco() * ((100 - desconto) /100);
    }
}
