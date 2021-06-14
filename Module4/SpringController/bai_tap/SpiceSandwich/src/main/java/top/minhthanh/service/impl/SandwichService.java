package top.minhthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.minhthanh.models.Sandwich;
import top.minhthanh.repository.ISandwichRepository;
import top.minhthanh.service.ISandwichService;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    ISandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> listSandwich() {
        return this.sandwichRepository.listSandwich();
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        this.sandwichRepository.addSandwich(sandwich);
    }
}
