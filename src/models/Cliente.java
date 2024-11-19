package src.models;

import src.service.ClienteOperacoes;

/**
 * Definição da classe abstrata Cliente
 */
public abstract class Cliente implements ClienteOperacoes {
    private String nome;
    private String cpf;
    private String telefone;
    private int numeroCompras;

    /**
    * Método construtor
    */
    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numeroCompras = 0;
    }

     /**
    * Método construtor
    */
    public Cliente(String nome, String cpf, String telefone, int numeroCompras) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numeroCompras = numeroCompras;
    }


     /**
     * Método @return o nome do Cliente
     */
    public String getNome() {
        return nome;
    }

     /**
     * Método @return o cpf do Cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método @return o telefone do Cliente
     */
    public String getTelefone() {
        return telefone;
    }

     /**
     * Método @return o número de compras do Cliente
     */
    public int getNumeroCompras() {
        return this.numeroCompras;
    }

     /**
    * Método que vende um livro e aumenta o número de compras do Cliente
    */
    public void vendaLivro() {
        this.numeroCompras += 1;
    }
}
