package thanh.code.repository;

import java.util.List;

public interface IRepository<E> {

    List<E> listEntity();

    String addEntity(E e);

    E detailEntity(int id);

    String deleteEntity(int id);

    String editEntity(E e);
}
