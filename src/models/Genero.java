package src.models;

/**
 * Definição do enum Genero
 */
public enum Genero {
    AVENTURA(40.00),
    AUTOAJUDA(19.90),
    BIOGRAFIA(44.90),
    FANTASIA(45.90),
    FICCAO(34.99),
    INFANTIL(19.99),
    ROMANCE(45.00),
    TERROR_SUSPENSE(49.99);

    private final double precoBase;

    /**
     * Método construtor
     */
    Genero(double precoBase) {
        this.precoBase = precoBase;
    }

    /**
     * Método @return o preço do Livro de acordo com o Genero
     */
    public double getPrecoBase() {
        return precoBase;
    }

     /**
    * Método que verifica se um Genero é válido
    * recebe como @param nomeGenero
    * e @return um valor booleano
    */
    public static boolean generoValido(String nomeGenero) {
        for (Genero genero : Genero.values()) {
            if (genero.name().equals(nomeGenero)) {
                return true;
            }
        }
        return false;
    }
}
