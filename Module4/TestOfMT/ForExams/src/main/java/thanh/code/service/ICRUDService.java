package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICRUDService<E> {
    List<E> listEntity();

    Page<E> listLimitEntity(Pageable pageable);

    void addOrUpdateEntity(E e);

    void removeEntity(E e);

    Iterable<E> IterableEntity(E e);
}
