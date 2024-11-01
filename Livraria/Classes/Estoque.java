import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static int quantidadeLivros;
    private List<Livro> listaLivrosDisponiveis = new ArrayList<>();
   // private boolean disponivel; quando um livro é cadastrado, ele recebe o código de disponível (melhorar esta parte)

    public void cadastrarLivro(Livro livro) {
          listaLivrosDisponiveis.add(livro);
          livro.setDisponivel(true);
          quantidadeLivros += 1;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
}
