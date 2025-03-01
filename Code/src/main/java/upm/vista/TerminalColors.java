package upm.vista;

public class TerminalColors {
    public static final String COMANDO = "CLI>";
    public static final String REINICIAR = "\u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String AZUL = "\u001B[36m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String COPY_RIGHT = "\u00A9";

    public void mostrar(String mensaje) {
        System.out.println(TerminalColors.AZUL + "   - " + mensaje + TerminalColors.REINICIAR);
    }

    public void mostrarNegrita(String mensaje) {
        System.out.println(TerminalColors.ROJO + "  " + mensaje + "  " + TerminalColors.REINICIAR);
    }

    public void mostrarError(String mensaje) {
        System.out.println(TerminalColors.FONDO_ROJO + TerminalColors.NEGRO + "  " + mensaje + "  " + TerminalColors.REINICIAR);
    }

    public void commandWaiter() {
        System.out.print(COMANDO);
    }
}
