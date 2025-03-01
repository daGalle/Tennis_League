package upm.modelo.repositories;

import upm.modelo.repositories.Interfaces.GenericInterface;

import java.util.*;

public abstract class GenericRepository<T> implements GenericInterface<T> {
    private final HashMap<Integer, T> map;
    private int id;

    protected GenericRepository() {
        map = new HashMap<>();
        id = 1;
    }

    @Override
    public T create(T entity) {
        this.setId(entity, this.id);
        this.map.put(this.id, entity);
        this.id++;
        return entity;
    }

    @Override
    public List<T> showAll() {
        return new ArrayList<>(map.values());
    }

    public T delete(int id) {
        T entity = this.map.remove(id);
        return entity;
    }

    protected abstract Integer getId(T entity);

    protected abstract void setId(T entity, Integer id);

}

