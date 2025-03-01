package upm.vista;

public enum CommandNames {
    CREATE_REFREE("createRefree",":<nombre>;<contraseña> Registra un arbitro"),
    LOGIN("login", ":<nombre>,<contraseña> Inicia sesion como arbitro"),
    LOGOUT("logout", " Cierra sesion"),
    CREATE_PLAYER("createPlayer",":<nombre>;<birthday(dd/mm/aa)> Se da de alta un jugador"),
    READ_PLAYERS("readPlayers", " Muestra los jugadores registrados"),
    CREATE_MATCH("createMatch",":<numero de sets>;<id_jugador1>,<id_jugador2>"),
    LACK_SERVICE("lackService",":<id_partido> penaliza al jugador que esta sacando con una falta de saque"),
    POINT_SERVICE("pointService", ":<id_partido> Asigna un punto al jugador que esta sacando"),
    POINT_REST("pointRest",":<id_partido> Asigna un punto al jugador que esta sacando"),
    READ_PLAYER("readPlayer", ":<id_jugador>;<-r> Se muestra informacion detallada del jugador"),
    READ_MATCH("readMatch",":<id_partido>;<-csv/-json> Muestra los partidos incluyendo los resultados"),
    HELP("help"," Muestra los comandos del sistema"),
    SALIR("salir", " Sale de la aplicacion");
    private final String command;
    private final String help;

    CommandNames(String command, String help) {
        this.command = command;
        this.help = help;
    }



    public static CommandNames value(String value) {
        for (CommandNames comandos : CommandNames.values()) {
            if (comandos.getCommand().equals(value)) {
                return comandos;
            }
        }
        throw new UnsupportedOperationException("Comando '" + value + "' no existe.");
    }

    public String getCommand() {
        return this.command;
    }

    public String getHelp() {
        return this.getCommand() + this.help;
    }
}
