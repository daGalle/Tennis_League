package upm.modelo.repositories.Interfaces;

import upm.modelo.items.CurrentMatch;
import upm.modelo.items.Match;

public interface MatchInterface extends GenericInterface<Match> {
    public Match findById(Integer id);
}
