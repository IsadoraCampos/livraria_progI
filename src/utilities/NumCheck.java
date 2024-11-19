package src.utilities;

/**
 * Definição da classe NumCheck
 */
public class NumCheck {

    /**
     * Método que verifica se um número é inteiro
     * recebe como @param input
     * e @return um valor booleano
     */
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
