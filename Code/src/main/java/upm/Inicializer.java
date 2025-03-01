package upm;

import upm.controlador.MatchService;
import upm.controlador.PlayerService;
import upm.controlador.RefereeService;
import upm.modelo.repositories.MatchRepository;
import upm.modelo.repositories.PlayerRepository;
import upm.modelo.repositories.Populator;
import upm.modelo.repositories.RefereeRepository;
import upm.vista.CommandInterpretate;
import upm.vista.TerminalColors;
import upm.vista.ErrorsChecker;

public class Inicializer {
    private static final Inicializer INSTANCE = new Inicializer();
    private final ErrorsChecker errorsChecker;
    private final TerminalColors terminalColors;
    private final CommandInterpretate commandInterpretate;
    private final MatchRepository matchRepository;
    private final RefereeRepository refereeRepository;
    private final PlayerRepository playerRepository;
    private final RefereeService refereeService;
    private final PlayerService playerService;
    private final MatchService matchService;
    private final Populator populator;

    public Inicializer() {
        this.terminalColors = new TerminalColors();
        this.matchRepository = new MatchRepository();
        this.refereeRepository = new RefereeRepository();
        this.playerRepository = new PlayerRepository();
        this.refereeService = new RefereeService(this.matchRepository, this.refereeRepository);
        this.playerService = new PlayerService(this.matchRepository, this.playerRepository);
        this.matchService = new MatchService(this.matchRepository, this.refereeRepository, this.playerRepository);
        this.commandInterpretate = new CommandInterpretate(this.terminalColors, this.refereeService, this.playerService, this.matchService);
        this.errorsChecker = new ErrorsChecker(this.commandInterpretate, this.terminalColors);
        this.populator = new Populator(this.refereeService, this.matchService, this.playerService);
    }
    public static void main(String[] args) {
        Inicializer.getInstance().ejecutar();
    }
    public void ejecutar() {
        this.errorsChecker.controladorErrores();
    }
    public static Inicializer getInstance() {
        return INSTANCE;
    }

    public ErrorsChecker getShowErrors() {
        return errorsChecker;
    }

    public TerminalColors getShowColors() {
        return terminalColors;
    }

    public CommandInterpretate getCommandInterpretate() {
        return commandInterpretate;
    }

    public MatchRepository getMatchRepository() {
        return matchRepository;
    }

    public RefereeRepository getRefereeRepository() {
        return refereeRepository;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public RefereeService getRefereeService() {
        return refereeService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public MatchService getMatchService() {
        return matchService;
    }
}