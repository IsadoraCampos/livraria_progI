package src.models;

import src.service.ClienteOperacoes;

public abstract class Cliente implements ClienteOperacoes {
    private String nome;
    private String cpf;
    private String telefone;

    private final int numeroCompras;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numeroCompras = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getNumeroCompras() {
        return this.numeroCompras;
    }
}