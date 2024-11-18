package src.service;

import src.exceptions.DomainException;
import src.models.Cliente;
import src.models.ClienteNormal;
import src.models.ClienteVIP;
import src.models.Livro;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteManager {

    private List<Cliente> listaClientes = new ArrayList<>();


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        } else {
            System.out.println("O cliente já está cadastrado!");
        }
    }

    public Cliente getClientePorCPF(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean clienteExiste(String cpf) {
        return listaClientes.contains(getClientePorCPF(cpf));
    }

    public ClienteVIP converterCliente(Cliente cliente) {
        return new ClienteVIP(cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }

    public void excluirCliente(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                if (listaClientes.contains(cliente)) {
                    listaClientes.remove(cliente);
                    System.out.println("Cliente removido com sucesso!");
                } else {
                    System.out.println("Não há um cliente com este CPF cadastrado!");
                }
            }
        }
    }

    public void venderLivro(Cliente cliente, Livro livro) {
        if (cliente instanceof ClienteNormal) {
            System.out.println("CLIENTE NORMAL");
            System.out.println("Livro: " + livro.getTitulo() + " - " + livro.getAutor().getNome());
            System.out.println("Preço: " + cliente.calculaPreco(livro));
        } else if (cliente instanceof ClienteVIP) {
            System.out.println("CLIENTE VIP");
            System.out.println("Livro: " + livro.getTitulo() + " - " + livro.getAutor().getNome());
            System.out.println("Preço: " + cliente.calculaPreco(livro));
        }
    }

}
