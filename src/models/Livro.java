package src.models;

/**
 * Definição da classe Livro
 */
public class Livro {
    private String titulo;
    private int paginas;
    private int capitulos;
    private Autor autor;
    private Editora editora;
    private Genero genero;
    private int quantidade;

    /**
     * Método construtor
     */
    public Livro(String titulo, int paginas, int capitulos, Autor autor, Editora editora, Genero genero, int quantidade) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    /**
     * Método @return o título do Livro
     */
    public String getTitulo() {
        return titulo;
    }

    
    /**
     * Método @return o número de páginas do Livro
     */
    public int getPaginas() {
        return paginas;
    }

    
    /**
     * Método @return o número de capítulos do Livro
     */
    public int getCapitulos() {
        return capitulos;
    }

    
    /**
     * Método @return o Autor do Livro
     */
    public Autor getAutor() {
        return autor;
    }

    
    /**
     * Método @return a Editora do Livro
     */
    public Editora getEditora() {
        return editora;
    }

    
    /**
     * Método @return o Genero do Livro
     */
    public Genero getGenero() {
        return genero;
    }

    
    /**
     * Método @return a quantidade do Livro cadastrada no Estoque
     */
    public int getQuantidade() {
        return quantidade;
    }

    
    /**
     * Método @return o preço do Livro
     */
    public double getPreco() {
        return this.genero.getPrecoBase();
    }

    
    /**
     * Método que repõem um Livro
     * recebe como @param a quantidade que deseja repor e aumenta a @param quantidade do Livro
     */
    public void reporLivro(int quantidade) {
        this.quantidade += quantidade;
    }

    /**
     * Método que vende um Livro
     * recebe como @param a quantidade que deseja comprar e diminui a @param qauntidade do Livro
     */
    public void venderLivro(int quantidade) {
        if (this.quantidade < quantidade) {
            System.out.println("Quantidade insuficiente em estoque!");
        } else {
            this.quantidade -= quantidade;
            System.out.println("Livro(s) vendido(s) com sucesso!");
        }
    }

    /**
     * Método que mostra as informações do Livro
     */
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
