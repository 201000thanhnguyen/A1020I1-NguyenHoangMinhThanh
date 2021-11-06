package thanh.code.service;

import thanh.code.models.Division;

public interface IDivisionService extends ICRUDService<Division> {
    // for tag select option client
    Iterable<Division> divisionIterable();
}
