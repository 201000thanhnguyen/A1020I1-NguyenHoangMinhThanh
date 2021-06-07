package models.repository;

import java.util.List;

public interface IRepository<T> {

    List<T> listInRepository();

    String addInRepository(T t);

    String deleteInRepository(String id);

    String editInRepository(T t);

    T detailInRepository (int id);

    List<T> findInRepository(String byName);

    int countInRepository();

    List<T> listLimitInRepository(int index, int getNumber);
}
