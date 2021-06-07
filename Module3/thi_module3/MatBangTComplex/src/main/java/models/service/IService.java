package models.service;

import java.util.List;

public interface IService<T> {

    List<T> listInService();

    String addInService(T t);

    String deleteInService(String id);

    String editInService(T t);

    T detailInService (int id);

    List<T> findInService(String byName);

    int countInService();

    List<T> listLimitInService(int index, int getNumber);
}
