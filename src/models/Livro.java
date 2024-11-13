package src.models;

public class Livro {
    private String titulo;
    private int paginas;
    private int capitulos;
    private Autor autor;
    private Editora editora;
    private Genero genero;
    private int quantidade; //Outras classes podem mudar a situação do livro

    public Livro(String titulo, int paginas, int capitulos, Autor autor, Editora editora, Genero genero, int quantidade) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return this.genero.getPrecoBase();
    }

    public void reporLivro(int quantidade) {
        this.quantidade += quantidade;
    }

    public void venderLivro(int quantidade) {
        if (this.quantidade < quantidade) {
            System.out.println("Quantidade insuficiente em estoque!");
        } else {
            this.quantidade -= quantidade;
            System.out.println("Livro(s) vendido(s) com sucesso!");
        }
    }

    public void printLivro() {
        System.out.println("----------------------------------------------");
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor().getNome());
        System.out.println("Gênero: " + this.getGenero());
        System.out.println("Editora: " + this.getEditora().getNome());
        System.out.println("Nº de páginas: " + this.getPaginas());
        System.out.println("Nº de capítulos: " + this.getCapitulos());
        System.out.println("Preço: " + this.getPreco());
        System.out.println("Quantidade disponível: " + this.getQuantidade());
        System.out.println("----------------------------------------------");
   }
}