package top.minhthanh.repository.impl;

import org.springframework.stereotype.Repository;
import top.minhthanh.models.Sandwich;
import top.minhthanh.models.SandwichCondiment;
import top.minhthanh.repository.ISandwichRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {
    private static List<Sandwich> sandwichList;
    static {
        sandwichList = new ArrayList<>();
        sandwichList.add(new Sandwich(Collections.singleton(SandwichCondiment.Lettuce)));
    }

    @Override
    public List<Sandwich> listSandwich() {
        return sandwichList;
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        sandwichList.add(sandwich);
    }
}
