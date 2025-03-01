package upm.vista;

import upm.controlador.MatchService;
import upm.controlador.PlayerService;
import upm.controlador.RefereeService;
import upm.modelo.items.Referee;

import java.util.Scanner;

public class CommandInterpretate {
    private TerminalColors terminalColors;
    private Referee logged;
    private MatchService matchService;
    private PlayerService playerService;
    private RefereeService refereeService;

    public CommandInterpretate(TerminalColors terminalColors, RefereeService refereeService, PlayerService playerService, MatchService matchService) {
        this.matchService = matchService;
        this.playerService = playerService;
        this.refereeService = refereeService;
        this.terminalColors = terminalColors;
    }

    public boolean ejecutarComandos() {
        Scanner scanner = new Scanner(System.in).useDelimiter("[ \\r\\n]");
        boolean salir = false;
        while (!salir) {
            salir = commandInterpretate(scanner);
        }
        return true;
    }

    public boolean commandInterpretate(Scanner scanner) {
        this.terminalColors.commandWaiter();
        CommandNames comando = CommandNames.value(scanner.next());
        boolean end = false;
        switch (comando) {
            case LOGIN:
                this.login(scanner.next().split(";"));
                break;
            case LOGOUT:
                this.logout();
                break;
            case CREATE_REFREE:
                this.createReferee(scanner.next().split(";"));
                break;
            case CREATE_PLAYER:
                this.createPlayer(scanner.next().split(";"));
                break;
            case READ_PLAYERS:
                this.readPlayers();
                break;
            case CREATE_MATCH:
                this.createMatch(scanner.next().split(";"));
                break;
            case LACK_SERVICE:
                this.lackService(scanner.next());
                break;
            case POINT_SERVICE:
                this.servePoint(scanner.next());
                break;
            case POINT_REST:
                this.restPoint(scanner.next());
                break;
            case READ_PLAYER:
                this.readPlayer(scanner.next().split(":"));
                break;
            case READ_MATCH:
                this.readMatch(scanner.next().split(":"));
                break;
            case HELP:
                this.help();
                break;
            case SALIR:
                end = true;
                break;
        }
        return end;
    }

    private void createReferee(String[] args) {
        if(args.length != 2) {
            throw new IllegalStateException(CommandNames.CREATE_REFREE.getHelp());
        }
        refereeService.createReferee(args[0], args[1]);
        this.terminalColors.mostrar("Se ha registrado " + args[0]);
    }

    private void login(String[] args) {
        if (logged != null) {
            throw new IllegalStateException("El usuario ya ha iniciado sesion");
        }
        if(args.length != 2) {
            throw new IllegalArgumentException(CommandNames.LOGIN.getHelp());
        }

        String name = args[0];
        String password = args[1];
        this.logged = refereeService.login(name, password);
        this.terminalColors.mostrar("Bienvenido " + name);
    }

    private void logout() {
        if (this.logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion todavia");
        }
        this.terminalColors.mostrar("Hasta pronto " +  this.logged.getName());
        this.logged = null;
    }

    private void createPlayer(String[] args) {
        if(this.logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        } else if(args.length == 1) {
            this.playerService.createPlayer(args[0]);
        } else if(args.length == 2) {
            this.playerService.createPlayer(args[0], args[1]);
        }else {
            throw new IllegalStateException(CommandNames.CREATE_PLAYER.getHelp());
        }
        this.terminalColors.mostrar("Se ha registrado " + args[0]);
    }

    private void readPlayers() {
        if(this.logged == null) {
            throw new IllegalStateException("Tiene que iniciar sesion para ejecutar este comando");
        }
        this.playerService.readPlayers();
    }

    private void createMatch(String[] args) {
        if (logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        } else if (args.length != 2) {
            throw new IllegalStateException(CommandNames.CREATE_MATCH.getHelp());
        }
        int numSets = Integer.parseInt(args[0]);
        String[] ids = args[1].split(",");
        if(ids.length != 2) {
            throw new IllegalStateException(CommandNames.CREATE_MATCH.getHelp());
        }
        matchService.createMatch(logged, numSets, Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));
        this.terminalColors.mostrar("Se ha registrado el partido");
    }


    private void lackService(String args) {
        if (logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        }
        matchService.lackService(this.logged, Integer.parseInt(args));
    }
    private void restPoint(String args) {
        if (logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        }
        matchService.restPoint(this.logged, Integer.parseInt(args));
    }

    private void servePoint(String args) {
        if (logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        }
        matchService.servePoint(this.logged, Integer.parseInt(args));
    }

    private void readMatch(String[] args) {
        if(this.logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        }
        args = args[0].split(" ");
        if(args.length == 1) {
            this.matchService.readMatch(Integer.parseInt(args[0]));
        } else {
            if(args.length != 2) {
                if(args[1].contains("-csv")) {

                } else if(args[1].contains("-json")) {
                    this.matchService.JSONreadMatch(Integer.parseInt(args[0]));
                } else {
                    throw new IllegalStateException(CommandNames.READ_MATCH.getHelp());
                }
            } else {
                throw new IllegalStateException(CommandNames.READ_MATCH.getHelp());
            }
        }
    }

    private void readPlayer(String[] args) {
        if (logged == null) {
            throw new IllegalStateException("El usuario no ha iniciado sesion");
        } else if (args.length != 1 && args.length != 2) {
            throw new IllegalStateException(CommandNames.READ_PLAYER.getCommand());
        }
        args = args[0].split(" ");
        if(args.length == 1) {
            playerService.readPlayer(Integer.parseInt(args[0]));
        } else {
            if(args[1].equals("-r") && args.length == 2) {
                playerService.readMatchesSort(Integer.parseInt(args[0]));
            } else {
                throw new IllegalStateException(CommandNames.READ_PLAYER.getCommand());
            }
        }
    }


    private void help() {
        for (CommandNames comandos : CommandNames.values()) {
            this.terminalColors.mostrar(comandos.getHelp());
        }
    }
}
