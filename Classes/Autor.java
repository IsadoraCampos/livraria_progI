public class Autor {
    private String nome;
    private Livro[] livros;

    public Autor(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }

    public Livro[] getLivros() {
        return livros;
    }
}
