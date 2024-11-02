import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static int quantidadeLivros;
    private List<Livro> listaLivrosDisponiveis = new ArrayList<>();
   // private boolean disponivel; quando um livro é cadastrado, ele recebe o código de disponível (melhorar esta parte)

    public void cadastrarLivro(Livro livro) {
        if (!listaLivrosDisponiveis.contains(livro)) {
           listaLivrosDisponiveis.add(livro);
           livro.setDisponivel(true);
           quantidadeLivros += 1;
        } else {
            System.out.println("O livro já está cadastrado!");
        }
    }

    public void excluirLivro(Livro livro) {
        if (listaLivrosDisponiveis.contains(livro)) {
            listaLivrosDisponiveis.remove(livro);
            livro.setDisponivel(false);
            quantidadeLivros -= 1;
        } else {
            System.out.println("O livro não existe no estoque!");
        }
    }

    public boolean pesquisarLivro(Livro livro) {
        return listaLivrosDisponiveis.contains(livro); //Retorna true se o livro existe, false o contrário
    }
    
    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
}
