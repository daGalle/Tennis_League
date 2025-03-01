package upm.controlador;

import upm.modelo.items.Referee;
import upm.modelo.repositories.Interfaces.MatchInterface;
import upm.modelo.repositories.Interfaces.RefereeInterface;

public class RefereeService {
    private final RefereeInterface refereeInterface;
    private final MatchInterface matchInterface;

    public RefereeService(MatchInterface matchInterface, RefereeInterface refereeInterface) {
        this.refereeInterface = refereeInterface;
        this.matchInterface = matchInterface;
    }


    public Referee createReferee(String name, String password) {
        Referee referee = findReferee(name);
        if(referee != null) {
            throw new IllegalArgumentException("El jugador ya existe");
        }
        referee = new Referee(name, password);
        refereeInterface.create(referee);
        return referee;
    }

    public Referee login(String name, String password) {
        Referee referee = findReferee(name);
        if(referee == null) {
            throw new IllegalArgumentException("El arbitro no existe");
        } else if(!password.equals(referee.getPassword())) {
            throw new IllegalArgumentException("La contraseña es incorrecta");
        } else if(referee.isNotRegisted()){
            referee.registed();
        }
        return referee;
    }

    private Referee findReferee(String name) {
        Referee result = null;
        for(Referee referee : this.refereeInterface.showAll()) {
            if(referee.getName().equals(name)) {
                result = referee;
            }
        }
        return result;
    }

}
