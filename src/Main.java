package src;

import src.models.*;
import src.service.ClienteManager;
import src.service.Estoque;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();
        ClienteManager clientes = new ClienteManager();

    try {
        boolean menu = true;
        while (menu) {
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
            String n = sc.nextLine(); //verficar ainda se é inteiro e lançar exceção
            int opcao =Integer.parseInt(n);

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String nomeAutor = sc.nextLine();
                    System.out.print("Editora: ");
                    String nomeEditora = sc.nextLine();
                    System.out.println("Digite o gênero conforme as opções abaixo: "); //organizar isso aqui pros enums
                    for (Genero genero : Genero.values()) {
                        System.out.printf(" - %s%n", genero);
                    }
                    String nomeGenero = sc.nextLine().toUpperCase();
                    System.out.print("Número de páginas: ");
                    int paginas = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Número de capítulos: ");
                    int capitulos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Quantidade disponível em estoque: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
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
                    String m = sc.nextLine();
                    int busca = Integer.parseInt(m);

                    switch (busca) {
                        case 1:
                            System.out.print("Digite o título do livro: ");
                            String buscaTitulo = sc.nextLine();
                            estoque.getLivroPorTitulo(buscaTitulo);
                            break;
                        case 2:
                            System.out.print("Digite o nome do autor: ");
                            String buscaAutor = sc.nextLine();
                            estoque.getLivrosPorAutor(buscaAutor);
                            break;
                        case 3:
                            System.out.print("Digite o nome da editora: ");
                            String buscaEditora = sc.nextLine();
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
                    String reporTitulo = sc.nextLine();
                    System.out.print("Digite o autor do livro que deseja repor no estoque: ");
                    String reporAutor = sc.nextLine();
                    System.out.print("Digite a editora do livro que deseja repor no estoque: ");
                    String reporEditora = sc.nextLine();
                    System.out.print("Quantidade de exemplares que deseja repor no estoque: ");
                    int quanti = sc.nextInt();
                    sc.nextLine();
                    estoque.reporLivro(reporTitulo, reporAutor, reporEditora, quanti);
                    break;
                case 4:
                    //venda diminui a quantidade em estoque
                    System.out.print("Digite o CPF do cliente que deseja fazer a compra: ");
                    String vendaCpf = sc.nextLine();
                    System.out.print("Digite o titulo do livro que deseja vender: ");
                    String vendaTitulo = sc.nextLine();
                    System.out.print("Digite o autor do livro que deseja vender: ");
                    String vendaAutor = sc.nextLine();
                    System.out.print("Digite a editora do livro que deseja vender: ");
                    String vendaEditora = sc.nextLine();
                    System.out.print("Quantidade de exemplares que deseja vender: ");
                    int quant = sc.nextInt();
                    sc.nextLine();
                    Cliente vendaCliente = clientes.getClientePorCPF(vendaCpf);
                    Livro vendaLivro = estoque.findLivro(vendaTitulo, vendaAutor, vendaEditora, quant);
                    estoque.venderLivro(vendaLivro, quant);
                    clientes.venderLivro(vendaCliente, vendaLivro);
                    break;
                case 5:
                    //excluir totalmente um livro do estoque, independentemente da quantidade disponível
                    System.out.print("Digite o titulo do livro que deseja excluir: ");
                    String excluiTitulo = sc.nextLine();
                    System.out.print("Digite o autor do livro que deseja excluir: ");
                    String excluiAutor = sc.nextLine();
                    System.out.print("Digite a editora do livro que deseja excluir: ");
                    String excluiEditora = sc.nextLine();
                    estoque.excluirLivro(excluiTitulo, excluiAutor, excluiEditora);
                    break;
                case 6:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = sc.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = sc.nextLine();
                    Cliente cliente = new ClienteNormal(nome, cpf, telefone);
                    clientes.cadastrarCliente(cliente);
                    break;
                case 7:
                    System.out.print("Digite o CPF do cliente: ");
                    String buscaCpf = sc.nextLine();
                    Cliente cliente1 = clientes.getClientePorCPF(buscaCpf);
                    cliente1.printCliente();
                    break;
                case 8:
                    System.out.print("Digite o CPF do cliente: ");
                    String excluiCpf = sc.nextLine();
                    clientes.excluirCliente(excluiCpf);
                case 9:
                    menu = false;
                    break;
                default:
                    System.out.println("Índice não existe no menu"); //lançar exceção aqui
                    break;
            }
        }
    } catch (RuntimeException e) {
        System.out.println("Erro inesperado.");
    }

    sc.close();
    }
}
