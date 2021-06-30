package thanh.code.repository;

import java.util.List;

public interface IRepository<E> {

    List<E> listEntity();

    String addEntity(E e);

    E findEntity(int id);
}
