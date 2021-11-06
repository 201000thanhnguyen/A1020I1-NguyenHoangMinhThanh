package thanh.code.service;


import thanh.code.models.Position;

public interface IPositionService extends ICRUDService<Position> {
    // for tag select option client
    Iterable<Position> positionIterable();
}
