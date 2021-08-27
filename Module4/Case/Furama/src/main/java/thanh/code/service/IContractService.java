package thanh.code.service;

import thanh.code.models.Contract;

public interface IContractService extends ICRUDService<Contract> {

    Iterable<Contract> contractIterable();
}
