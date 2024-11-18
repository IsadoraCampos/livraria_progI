package src;

import src.exceptions.DomainException;
import src.models.*;
import src.service.ClienteManager;
import src.service.Estoque;

import java.util.Locale;
import java.util.Scanner;

import static src.utilities.NumCheck.isInt;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();
        ClienteManager clientes = new ClienteManager();

    boolean menu = true;
    while (menu) {
        try {
            System.out.println();
            System.out.println("MENU DE OPÇÕES: ");
            System.out.println("1.  Cadastrar um livro no estoque");
            System.out.println("2.  Buscar no estoque");
            System.out.println("3.  Adicionar quantidade de um livro no estoque");
            System.out.println("4.  Vender um livro");
            System.out.println("5.  Remover livro do estoque");
            System.out.println("6.  Cadastrar Cliente");
            System.out.println("7.  Buscar Cliente pelo CPF");
            System.out.println("8.  Deletar Cliente cadastrado");
            System.out.println("9. Encerrar programa");
            String n = sc.nextLine().trim();
            if (!isInt(n)) {
                throw new DomainException("A entrada deve ser um número inteiro.");
            }
            int opcao =Integer.parseInt(n);

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine().trim();;
                    if (titulo.isEmpty()) {
                        throw new DomainException("O título não pode estar vazio.");
                    }
                    System.out.print("Autor: ");
                    String nomeAutor = sc.nextLine().trim();;
                    if (nomeAutor.isEmpty()) {
                        throw new DomainException("O nome do autor não pode estar vazio.");
                    }
                    System.out.print("Editora: ");
                    String nomeEditora = sc.nextLine().trim();;
                    if (nomeEditora.isEmpty()) {
                        throw new DomainException("O nome da editora não pode estar vazio.");
                    }
                    if (estoque.encontraLivro(titulo, nomeAutor, nomeEditora) != null) {
                        throw new DomainException("Já há um livro com estas características cadastrado!");
                    }
                    System.out.println("Digite o gênero conforme as opções abaixo: ");
                    for (Genero genero : Genero.values()) {
                        System.out.printf(" - %s%n", genero);
                    }
                    String nomeGenero = sc.nextLine().trim().toUpperCase();
                    if (nomeGenero.isEmpty()) {
                        throw new DomainException("O gênero não pode estar vazio.");
                    }
                    System.out.println();
                    System.out.print("Número de páginas: ");
                    String n1 = sc.nextLine().trim();;
                    if (!isInt(n1)) {
                        throw new DomainException("O número de páginas deve ser um número inteiro.");
                    }
                    int paginas =Integer.parseInt(n1);
                    System.out.print("Número de capítulos: ");
                    String n2 = sc.nextLine().trim();;
                    if (!isInt(n2)) {
                        throw new DomainException("O número de capítulos deve ser um número inteiro.");
                    }
                    int capitulos =Integer.parseInt(n2);
                    System.out.print("Quantidade disponível em estoque: ");
                    String n3 = sc.nextLine().trim();;
                    if (!isInt(n3)) {
                        throw new DomainException("A quantidade disponível deve ser um número inteiro.");
                    }
                    int quantidade =Integer.parseInt(n3);
                    System.out.println();

                    Editora editora = new Editora(nomeEditora);
                    Autor autor = new Autor(nomeAutor, editora);
                    editora.adicionaAutor(autor);
                    Genero genero = Genero.valueOf(nomeGenero);
                    Livro livro = new Livro(titulo, paginas, capitulos, autor, editora, genero, quantidade);
                    autor.adicionarLivroPorAutor(livro);
                    editora.adicionaLivro(livro);
                    estoque.cadastrarLivro(livro);

                    break;
                case 2:
                    //swicth case para os tipos de busca
                    System.out.println();
                    System.out.println("OPÇÕES DE BUSCA");
                    System.out.println("1. Busca por título");
                    System.out.println("2. Busca por autor");
                    System.out.println("3. Busca por editora");
                    System.out.println("4. Mostrar todos os livros");
                    String m = sc.nextLine().trim();;
                    if (!isInt(m)) {
                        throw new DomainException("A entrada deve ser um número inteiro.");
                    }
                    int busca = Integer.parseInt(m);

                    switch (busca) {
                        case 1:
                            System.out.print("Digite o título do livro: ");
                            String buscaTitulo = sc.nextLine().trim();
                            if (buscaTitulo.isEmpty()) {
                                throw new DomainException("O titulo não pode estar vazio.");
                            }
                            if (!estoque.tituloExiste(buscaTitulo)) {
                                throw new DomainException("Não há nenhum livro com este título cadastrado!");
                            }
                            estoque.getLivroPorTitulo(buscaTitulo);
                            break;
                        case 2:
                            System.out.print("Digite o nome do autor: ");
                            String buscaAutor = sc.nextLine().trim();
                            if (buscaAutor.isEmpty()) {
                                throw new DomainException("O nome do autor não pode estar vazio.");
                            }
                            if (!estoque.autorExiste(buscaAutor)) {
                                throw new DomainException("Não há nenhum livro deste autor cadastrado!");
                            }
                            estoque.getLivrosPorAutor(buscaAutor);
                            break;
                        case 3:
                            System.out.print("Digite o nome da editora: ");
                            String buscaEditora = sc.nextLine().trim();
                            if (buscaEditora.isEmpty()) {
                                throw new DomainException("O nome da editora não pode estar vazio.");
                            }
                            if (!estoque.editoraExiste(buscaEditora)) {
                                throw new DomainException("Não há nenhum livro desta editora cadastrado!");
                            }
                            estoque.getLivrosPorEditora(buscaEditora);
                            break;
                        case 4:
                            estoque.getTodosOsLivros();
                            break;
                        }
                    break;
                case 3:
                    //adicionar quantidade de um livro no estoque (reposição de livro)
                    System.out.print("Digite o titulo do livro que deseja repor no estoque: ");
                    String reporTitulo = sc.nextLine().trim();
                    if (reporTitulo.isEmpty()) {
                        throw new DomainException("O titulo não pode estar vazio.");
                    }
                    System.out.print("Digite o autor do livro que deseja repor no estoque: ");
                    String reporAutor = sc.nextLine().trim();
                    if (reporAutor.isEmpty()) {
                        throw new DomainException("O nome do autor não pode estar vazio.");
                    }
                    System.out.print("Digite a editora do livro que deseja repor no estoque: ");
                    String reporEditora = sc.nextLine().trim();
                    if (reporEditora.isEmpty()) {
                        throw new DomainException("O nome da editora não pode estar vazio.");
                    }
                    if (estoque.encontraLivro(reporTitulo, reporAutor, reporEditora) == null) {
                        throw new DomainException("Este livro não está cadastrado no estoque!");
                    }
                    System.out.print("Quantidade de exemplares que deseja repor no estoque: ");
                    String n4 = sc.nextLine().trim();
                    if (!isInt(n4)) {
                        throw new DomainException("A quantidade deve ser um número inteiro.");
                    }
                    int quanti =Integer.parseInt(n4);
                    estoque.reporLivro(reporTitulo, reporAutor, reporEditora, quanti);
                    break;
                case 4:
                    //venda diminui a quantidade em estoque
                    System.out.print("Digite o CPF do cliente que deseja fazer a compra: ");
                    String vendaCpf = sc.nextLine().trim();
                    if (vendaCpf.isEmpty()) {
                        throw new DomainException("O CPF do cliente não pode estar vazio.");
                    }
                    if (!clientes.clienteExiste(vendaCpf)) {
                        throw new DomainException("Não há um cliente cadastrado com este CPF!");
                    }
                    System.out.print("Digite o titulo do livro que deseja vender: ");
                    String vendaTitulo = sc.nextLine().trim();
                    if (vendaTitulo.isEmpty()) {
                        throw new DomainException("O titulo não pode estar vazio.");
                    }
                    System.out.print("Digite o autor do livro que deseja vender: ");
                    String vendaAutor = sc.nextLine().trim();
                    if (vendaAutor.isEmpty()) {
                        throw new DomainException("O nome do autor não pode estar vazio.");
                    }
                    System.out.print("Digite a editora do livro que deseja vender: ");
                    String vendaEditora = sc.nextLine().trim();
                    if (vendaEditora.isEmpty()) {
                        throw new DomainException("O nome da editora não pode estar vazio.");
                    }
                    System.out.print("Quantidade de exemplares que deseja vender: ");
                    String n5 = sc.nextLine().trim();
                    if (!isInt(n5)) {
                        throw new DomainException("A quantidade deve ser um número inteiro.");
                    }
                    int quant =Integer.parseInt(n5);
                    Cliente vendaCliente = clientes.getClientePorCPF(vendaCpf);
                    if (vendaCliente.getNumeroCompras() > 5) {
                        Cliente clienteVIP = clientes.converterCliente(vendaCliente);
                    }
                    Livro vendaLivro = estoque.encontraLivro(vendaTitulo, vendaAutor, vendaEditora);
                    if (vendaLivro == null) {
                        throw new DomainException("Livro não encontrado!");
                    }
                    estoque.venderLivro(vendaLivro, quant);
                    if (vendaCliente.getNumeroCompras() > 5) {
                        Cliente clienteVIP = clientes.converterCliente(vendaCliente);
                        clientes.venderLivro(clienteVIP, vendaLivro);
                    } else {
                        clientes.venderLivro(vendaCliente, vendaLivro);
                    }
                    break;
                case 5:
                    //excluir totalmente um livro do estoque, independentemente da quantidade disponível
                    System.out.print("Digite o titulo do livro que deseja excluir: ");
                    String excluiTitulo = sc.nextLine().trim();
                    if (excluiTitulo.isEmpty()) {
                        throw new DomainException("O titulo não pode estar vazio.");
                    }
                    System.out.print("Digite o autor do livro que deseja excluir: ");
                    String excluiAutor = sc.nextLine().trim();
                    if (excluiAutor.isEmpty()) {
                        throw new DomainException("O nome do autor não pode estar vazio.");
                    }
                    System.out.print("Digite a editora do livro que deseja excluir: ");
                    String excluiEditora = sc.nextLine().trim();
                    if (excluiEditora.isEmpty()) {
                        throw new DomainException("O nome da editora não pode estar vazio.");
                    }
                    if (estoque.encontraLivro(excluiTitulo, excluiAutor, excluiEditora) == null) {
                        throw new DomainException("Este livro não está cadastrado!");
                    }
                    estoque.excluirLivro(excluiTitulo, excluiAutor, excluiEditora);
                    break;
                case 6:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine().trim();
                    if (nome.isEmpty()) {
                        throw new DomainException("O nome do cliente não pode estar vazio.");
                    }
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = sc.nextLine().trim();
                    if (cpf.isEmpty()) {
                        throw new DomainException("O CPF do cliente não pode estar vazio.");
                    }
                    if (clientes.clienteExiste(cpf)) {
                        throw new DomainException("Já há um cliente cadastrado com este CPF!");
                    }
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = sc.nextLine().trim();
                    if (telefone.isEmpty()) {
                        throw new DomainException("O telefone do cliente não pode estar vazio.");
                    }
                    Cliente cliente = new ClienteNormal(nome, cpf, telefone);
                    clientes.cadastrarCliente(cliente);
                    break;
                case 7:
                    System.out.print("Digite o CPF do cliente: ");
                    String buscaCpf = sc.nextLine().trim();
                    if (buscaCpf.isEmpty()) {
                        throw new DomainException("O CPF do cliente não pode estar vazio.");
                    }
                    if (!clientes.clienteExiste(buscaCpf)) {
                        throw new DomainException("Não há um cliente cadastrado com este CPF!");
                    }
                    Cliente cliente1 = clientes.getClientePorCPF(buscaCpf);
                    cliente1.printCliente();
                    break;
                case 8:
                    System.out.print("Digite o CPF do cliente: ");
                    String excluiCpf = sc.nextLine().trim();
                    if (excluiCpf.isEmpty()) {
                        throw new DomainException("O CPF do cliente não pode estar vazio.");
                    }
                    if (!clientes.clienteExiste(excluiCpf)) {
                        throw new DomainException("Não há um cliente cadastrado com este CPF!");
                    }
                    clientes.excluirCliente(excluiCpf);
                case 9:
                    menu = false;
                    break;
                default:
                    System.out.println("Índice não existe no menu");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Opção inválida!");
        } catch (DomainException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    sc.close();
    }
}
