public class Aventura extends Genero implements CalculaPrecoLivro{
    public Aventura(String nome) {
        super(nome);
    }

    @Override
    public double calculaPreco(Livro livro) {
        return 40.00;
    }
}
