import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome) {
        this.nome = nome;
    }

    public void adicionarLivroPorAutor(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        } else {
            System.out.println("Livro já está associado ao autor(a).");
        }
    }
    
    public String getNome() {
        return this.nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
