package upm.modelo.repositories.Interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericInterface<T>{
    public T create(T entidad);

    public List<T> showAll();


}
