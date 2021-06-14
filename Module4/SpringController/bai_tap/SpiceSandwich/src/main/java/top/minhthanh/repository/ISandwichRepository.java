package top.minhthanh.repository;

import top.minhthanh.models.Sandwich;

import java.util.List;

public interface ISandwichRepository {

    List<Sandwich> listSandwich();

    void addSandwich(Sandwich sandwich);
}
