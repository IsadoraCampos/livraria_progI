public class teste {
    public static void main(String args[]) {
        Autor vitorHugo = new Autor("Vitor Hugo");
        Livro bateAsas = new Livro("Bate Asaas", 267, 19, vitorHugo , "Editora");

        Estoque estoque = new Estoque();

        vitorHugo.adicionarLivroPorAutor(bateAsas);
        estoque.cadastrarLivro(bateAsas);
        estoque.excluirLivro(bateAsas);
        System.out.println(estoque.getQuantidadeLivros());

        if (estoque.pesquisarLivro(bateAsas)) {
            System.out.println("O livro está no estoque.");
        } else {
            System.out.println("Livro não disponível no estoque.");
        }
    }
}
