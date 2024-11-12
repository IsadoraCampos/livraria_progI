package src.models;

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

    Genero(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}
