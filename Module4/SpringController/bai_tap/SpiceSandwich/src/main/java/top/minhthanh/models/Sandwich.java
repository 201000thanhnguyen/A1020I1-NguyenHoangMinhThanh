package top.minhthanh.models;

import java.util.*;

public class Sandwich {
    private Set<SandwichCondiment> condimentSet;

    public Sandwich() {
    }

    public Sandwich(Set<SandwichCondiment> condimentSet) {
        this.condimentSet = condimentSet;
    }

    public Set<SandwichCondiment> getCondimentSet() {
        return condimentSet;
    }

    public void setCondimentSet(Set<SandwichCondiment> condimentSet) {
        this.condimentSet = condimentSet;
    }
}
