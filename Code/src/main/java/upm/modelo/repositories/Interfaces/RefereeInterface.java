package upm.modelo.repositories.Interfaces;

import upm.modelo.items.Referee;

public interface RefereeInterface extends GenericInterface<Referee> {
    public Referee findNById(int id);
}
