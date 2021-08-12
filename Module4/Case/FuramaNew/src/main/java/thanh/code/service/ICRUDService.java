package thanh.code.service;

import java.util.List;

public interface ICRUDService<E> {
    // default
    List<E> listEntity();

    void addOrUpdateEntity(E e);

    void removeEntity(E e);
    // default

    // custom
    E findByIdInt(int id);
    //
}
