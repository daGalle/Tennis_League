package upm.controlador;

import upm.modelo.items.*;
import upm.modelo.repositories.Interfaces.MatchInterface;
import upm.modelo.repositories.Interfaces.PlayerInterface;
import upm.modelo.repositories.Interfaces.RefereeInterface;

public class MatchService {
    private final MatchInterface matchInterface;
    private final RefereeInterface refereeInterface;
    private final PlayerInterface playerInterface;

    public MatchService(MatchInterface matchInterface, RefereeInterface refereeInterface, PlayerInterface playerInterface) {
        this.matchInterface = matchInterface;
        this.refereeInterface = refereeInterface;
        this.playerInterface = playerInterface;
    }

    public CurrentMatch createMatch(Referee referee, int numOfSets, int playerName1, int playerName2) {
        if(numOfSets != 3 && numOfSets != 5) {
            throw new IllegalArgumentException("Numero de sets invalido(3 o 5)");
        }
        Player player1 = this.playerInterface.findById(playerName1);
        Player player2 = this.playerInterface.findById(playerName2);
        CurrentMatch currentMatch = new CurrentMatch(player1, player2, referee, numOfSets);
        matchInterface.create(currentMatch);
        return currentMatch;
    }

    public void endMatch() {
        throw new IllegalArgumentException("El partido ha terminado, no se puede actualizar");
    }

    public void endingMatch(CurrentMatch m) {
        EndMatch endMatch = new EndMatch(m.getPlayers()[0],m.getPlayers()[1],m.getReferee(), m.getScoreboard().getPuntuacion());
        for(Match ma : this.matchInterface.showAll()) {
            if(m.equals(ma)) {
                ma = endMatch;
            }
        }
    }

    public void readMatch(int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if (currentMatch == null) {
            throw new IllegalArgumentException("No se  ha podido encontrar el partido");
        }
        currentMatch.show();
    }

    public void lackService(Referee logged, int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if(currentMatch == null) {
            throw new IllegalArgumentException("No se ha encontrado ese partido");
        } else if(!logged.equals(currentMatch.getReferee())) {
            throw new IllegalArgumentException("Otro arbitro registro este partido");
        }
        currentMatch.faultService(this);
        currentMatch.show();
    }

    public void servePoint(Referee logged, int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if(currentMatch == null) {
            throw new IllegalArgumentException("No se ha encontrado ese partido");
        } else if(!logged.equals(currentMatch.getReferee())) {
            throw new IllegalArgumentException("Otro arbitro registro este partido");
        }
        currentMatch.pointService(this);
        currentMatch.show();
    }

    public void restPoint(Referee logged, int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if(currentMatch == null) {
            throw new IllegalArgumentException("No se ha encontrado ese partido");
        } else if(!logged.equals(currentMatch.getReferee())) {
            throw new IllegalArgumentException("Otro arbitro registro este partido");
        }
        currentMatch.pointRest(this);
        currentMatch.show();
    }

    public void CSVreadMatch(int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if (currentMatch == null) {
            throw new IllegalArgumentException("No se  ha podido encontrar el partido");
        }
        currentMatch.show();
    }

    public void JSONreadMatch(int idMatch) {
        Match currentMatch = this.matchInterface.findById(idMatch);
        if (currentMatch == null) {
            throw new IllegalArgumentException("No se  ha podido encontrar el partido");
        }
        try {
        currentMatch.JSONreadMatch();
        }catch (Exception e) {
            throw new IllegalArgumentException("No se ha podido crear el fichero JSON");
        }
    }
}
