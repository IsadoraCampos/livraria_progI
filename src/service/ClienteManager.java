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

/**
 * Definição da classe ClienteManager
 */
public class ClienteManager {

    private List<Cliente> listaClientes = new ArrayList<>();

    /**
     * Método que retorna a @param lista de clientes
     */
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Método que cadastra um Cliente
     * recebe como @param um Cliente e o adiciona na @param lista de clientes
     */
    public void cadastrarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        } else {
            System.out.println("O cliente já está cadastrado!");
        }
    }

    /**
     * Método que busca um Cliente pelo cpf
     * recebe como @param o cpf e @return o Cliente
     */
    public Cliente getClientePorCPF(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (Objects.equals(cliente.getCpf(), cpf)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Método que verifica se um Cliente existe
     * recebe como @param cpf
     * e @return um valor booleano
     */
    public boolean clienteExiste(String cpf) {
        return listaClientes.contains(getClientePorCPF(cpf));
    }

    /**
     * Método que converte um ClienteNormal para ClienteVIP
     * recebe como @param Cliente 
     * e @return um ClienteVIP
     */
    public ClienteVIP converterCliente(Cliente cliente) {
        return new ClienteVIP(cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }

    /**
     * Método que exclui um Cliente
     * recebe como @param cpf
     */
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

    /**
     * Método que vende um Livro
     *  recebe como @param cliente
     * e @param livro
     */
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
