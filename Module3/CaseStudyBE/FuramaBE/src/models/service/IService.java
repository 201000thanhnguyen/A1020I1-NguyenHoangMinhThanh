package models.service;

import java.util.List;

public interface IService<T> {
    List<T> listInService();

    String addInService(T t);

    String deleteInService(int id);

    String editInService(T t);

    T detailInService (int id);

    List<T> findInService(String byName);
}
