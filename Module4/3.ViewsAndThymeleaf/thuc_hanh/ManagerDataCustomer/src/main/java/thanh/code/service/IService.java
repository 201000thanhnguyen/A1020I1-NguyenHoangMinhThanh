package thanh.code.service;

import java.util.List;

public interface IService<E> {

    List<E> listEntity();

    String addEntity(E e);

    E findEntity(int id);

}
