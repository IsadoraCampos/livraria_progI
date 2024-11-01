public class Livro {
    private String titulo;
    private int paginas;
    private int capitulos;
    private Autor autor;
    private String editora;
    private boolean disponivel; //Outras classes podem mudar a situação do livro

    public Livro(String titulo, int paginas, int capitulos, Autor autor, String editora) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.autor = autor;
        this.editora = editora;
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

    public String getEditora() {
        return editora;
    }

   public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    } 

    
}