package top.minhthanh.service;

import top.minhthanh.models.Sandwich;

import java.util.List;

public interface ISandwichService {

    List<Sandwich> listSandwich();

    void addSandwich(Sandwich sandwich);
}
