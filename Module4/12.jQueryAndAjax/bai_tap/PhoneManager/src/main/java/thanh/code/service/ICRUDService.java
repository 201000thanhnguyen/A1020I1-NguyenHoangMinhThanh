package thanh.code.service;

import java.util.List;

public interface ICRUDService<E> {
    List<E> listEntity();

    void addOrUpdateEntity(E e);

    void removeEntity(E e);

    //
    E findByIdInt(int id);
}
