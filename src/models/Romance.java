public class Romance extends Genero implements CalculaPrecoLivro{
    public Romance(String nome) {
        super(nome);
    }

    @Override
    public double calculaPreco(Livro livro) {
        return 45.00;
    }
}
