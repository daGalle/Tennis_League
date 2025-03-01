package upm.modelo.repositories;

import upm.modelo.items.Player;
import upm.modelo.repositories.Interfaces.PlayerInterface;

import java.util.List;
import java.util.Optional;

public class PlayerRepository extends GenericRepository<Player> implements PlayerInterface {
    @Override
    protected Integer getId(Player entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Player entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public Optional<Player> findByName(String name) {
        List<Player> playerList = showAll();
        Player found = null;
        for (Player player : playerList) {
            if(player.getName().equals(name)) {
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }

    @Override
    public Player findById(int id) {
        List<Player> players = showAll();
        if(id < 0 || id > players.size()) {
            throw new IllegalArgumentException("No se encontro el jugador con id:" + id);
        }
        return players.get(id);
    }
}
