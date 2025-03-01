package upm.controlador;

import upm.modelo.items.CurrentMatch;
import upm.modelo.items.Match;
import upm.modelo.items.Player;
import upm.modelo.repositories.Interfaces.MatchInterface;
import upm.modelo.repositories.Interfaces.PlayerInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerService{
    private final MatchInterface matchInterface;
    private final PlayerInterface playerInterface;


    public PlayerService(MatchInterface matchInterface, PlayerInterface playerInterface) {
        this.matchInterface = matchInterface;
        this.playerInterface = playerInterface;
    }

    public Player createPlayer(String name, String birthday) {
        if(playerInterface.findByName(name).isPresent()) {
            throw new IllegalArgumentException("El jugador ya existe");
        }
        Player player = new Player(name, birthday);
        playerInterface.create(player);
        return player;
    }

    public Player createPlayer(String name) {
        if(playerInterface.findByName(name).isPresent()) {
            throw new IllegalArgumentException("El jugador ya existe");
        }
        Player player = new Player(name);
        playerInterface.create(player);
        return player;
    }

    public void readPlayer(int id) {
        Player player = playerInterface.findById(id);
        if(player == null) {
            throw new IllegalArgumentException("El jugador no existe");
        }
        player.show();
        List<Match> currentMatches = matchInterface.showAll();
        for(Match currentMatch : currentMatches) {
            if(currentMatch.getPlayers()[0].equals(player) || currentMatch.getPlayers()[1].equals(player)) {
                currentMatch.show();
            }
        }
    }

    public void readMatchesSort(int id) {
        Player player = playerInterface.findById(id);
        if(player == null) {
            throw new IllegalArgumentException("El jugador no existe");
        }
        player.show();
        List<Match> currentMatches = matchInterface.showAll();
        List<Match> matchesParticipies = new ArrayList<>();
        for(Match currentMatch : currentMatches) {
            if(currentMatch.getPlayers()[0].equals(player) || currentMatch.getPlayers()[1].equals(player)) {
                matchesParticipies.add(currentMatch);
            }
        }
        matchesParticipies.sort(Comparator.comparing(Match::getDayMatch));
        for(Match currentMatch : matchesParticipies) {
            currentMatch.show();
        }
    }

    public void readPlayers() {
        List<Player> players = this.playerInterface.showAll();
        if(players.isEmpty()) {
            throw new IllegalArgumentException("No existe todavia ningun jugador");
        }
        for(Player player : players) {
            player.show();
        }

    }

}
