package upm.modelo.repositories.Interfaces;

import upm.modelo.items.Player;

import java.util.Optional;

public interface PlayerInterface extends GenericInterface<Player>{
    public Optional<Player> findByName(String name);
    public Player findById(int id);
}
