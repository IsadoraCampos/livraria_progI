package src.service;

import src.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteManager {

    private static int quantidadeClientes;
    private List<Cliente> listaClientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
            quantidadeClientes += 1;
        } else {
            System.out.println("O cliente já está cadastrado!");
        }
    }

    public void getClientePorCPF(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                cliente.printCliente();
            }
        }
    }

    public void excluirCliente(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                if (listaClientes.contains(cliente)) {
                    listaClientes.remove(listaClientes);
                    quantidadeClientes -= 1;
                    System.out.println("Cliente removido com sucesso!");
                } else {
                    System.out.println("Não há um cliente com este CPF cadastrado!");
                }
            }
        }
    }


}
