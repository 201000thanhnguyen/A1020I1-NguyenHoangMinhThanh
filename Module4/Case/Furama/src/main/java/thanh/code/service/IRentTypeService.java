package thanh.code.service;

import thanh.code.models.RentType;

public interface IRentTypeService extends ICRUDService<RentType> {

    Iterable<RentType> rentTypeIterable();
}
