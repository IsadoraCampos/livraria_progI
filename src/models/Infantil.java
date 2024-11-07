public class Infantil extends Genero implements CalculaPrecoLivro{
    public Infantil(String nome) {
        super(nome);
    }

    @Override
    public double calculaPreco(Livro livro) {
        return 19.99;
    }
}
