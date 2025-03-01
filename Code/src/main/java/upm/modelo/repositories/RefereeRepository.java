package upm.modelo.repositories;

import upm.modelo.items.Referee;
import upm.modelo.repositories.Interfaces.RefereeInterface;

import java.util.List;

public class RefereeRepository extends GenericRepository<Referee> implements RefereeInterface {
    @Override
    protected Integer getId(Referee entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Referee entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public Referee findNById(int id) {
        List<Referee> referee = showAll();
        if(id < 0 || id > referee.size()) {
            throw new IllegalArgumentException("No se encontro al arbitro con id:" + id);
        }
        return referee.get(id);
    }
}
