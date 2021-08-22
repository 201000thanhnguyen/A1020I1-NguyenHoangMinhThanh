package thanh.code.service;

import thanh.code.models.ContractDetail;

import java.util.List;

public interface IContractDetailService extends ICRUDService<ContractDetail>{

    List<ContractDetail> listContractDetailOfOnePeople(int contractId);

    void deleteDetailOneRecord(int contractDetailId, int contractId);
}
