package upm.modelo.repositories;

import upm.modelo.items.CurrentMatch;
import upm.modelo.items.Match;
import upm.modelo.repositories.Interfaces.MatchInterface;

import java.util.List;

public class MatchRepository extends GenericRepository<Match> implements MatchInterface {
    @Override
    public Integer getId(Match entity) {
        return entity.getId();
    }
    @Override
    public void setId(Match entity, Integer id) {
        entity.setId(id);
    }
    @Override
    public Match findById(Integer id) {
        List<Match> currentMatches = showAll();
        if(id < 0 || id > currentMatches.size()) {
            throw new IllegalArgumentException("No se encontro el partido con id:" + id);
        }
        return currentMatches.get(id);
    }

}
