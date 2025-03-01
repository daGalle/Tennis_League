package upm.vista;

public class ErrorsChecker {
    private final CommandInterpretate commandInterpretate;
    private final TerminalColors terminalColors;

    public ErrorsChecker(CommandInterpretate commandInterpretate, TerminalColors terminalColors) {
        this.commandInterpretate = commandInterpretate;
        this.terminalColors = terminalColors;
        this.terminalColors.mostrarNegrita("Sistema de Gestión Deportiva. " + TerminalColors.COPY_RIGHT + "UPM.ETSISI.POO");
    }

    public void controladorErrores() {
        boolean salir = false;
        while (!salir) {
            try {
                salir = this.commandInterpretate.ejecutarComandos();
            } catch (Exception e) {
                this.terminalColors.mostrarError(">>> ERROR (" + e.getClass().getSimpleName() + ") >>> " + e.getMessage());
            }
        }
        this.terminalColors.mostrarNegrita("Hasta pronto!");
    }
}
