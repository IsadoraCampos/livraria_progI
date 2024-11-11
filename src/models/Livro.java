package src.models;

import src.service.CalculaPrecoLivro;

public class Livro {
    private String titulo;
    private int paginas;
    private int capitulos;
    private Autor autor;
    private String editora;
    private Genero genero;
    private double preco;
    private boolean disponivel; //Outras classes podem mudar a situação do livro

    public Livro(String titulo, int paginas, int capitulos, Autor autor, String editora, Genero genero) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.capitulos = capitulos;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        atualizarPreco();
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

    public Genero getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    } 

    public double getPreco() {
        return preco;
    }
    private void atualizarPreco() {
        if (genero instanceof CalculaPrecoLivro) { // Verifica se o gênero implementa a interface
            preco = ((CalculaPrecoLivro) genero).calculaPreco(this); //Realiza um cast para que gênero seja tratado como um CalculaPrecoLivro
        } else {
            preco = 0.0;
        }
    }

    public void printLivro() {
        System.out.println("----------------------------------------------");
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.autor.getNome());
        System.out.println("Gênero: " + this.genero.getGenero());
        System.out.println("Editora: " + this.getEditora());
        System.out.println("Nº de páginas: " + this.getPaginas());
        System.out.println("Nº de capítulos: " + this.getCapitulos());
        System.out.println("Preço: " + this.getPreco());
        System.out.println("Disponível: " + this.isDisponivel());
        System.out.println("----------------------------------------------");
   }
}