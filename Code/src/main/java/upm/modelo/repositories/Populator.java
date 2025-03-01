package upm.modelo.repositories;

import upm.controlador.MatchService;
import upm.controlador.PlayerService;
import upm.controlador.RefereeService;
import upm.modelo.items.Referee;

public class Populator {
    private RefereeService refereeService;
    private MatchService matchService;
    private PlayerService playerService;
    public Populator(RefereeService refereeService, MatchService matchService, PlayerService playerService) {
        this.refereeService = refereeService;
        this.matchService = matchService;
        this.playerService = playerService;
        Referee r = this.refereeService.createReferee("hola","123");
        this.playerService.createPlayer("h", "07/03/1990");
        this.playerService.createPlayer("j", "10/04/1009");
        this.matchService.createMatch(r, 3,0,1);
    }
    public void populate() {
    }
}
