package src.models;

import src.service.ClienteOperacoes;

public class ClienteNormal extends Cliente {


    public ClienteNormal(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

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

    @Override
    public double calculaPreco(Livro livro) {
        return livro.getPreco();
    }
}
