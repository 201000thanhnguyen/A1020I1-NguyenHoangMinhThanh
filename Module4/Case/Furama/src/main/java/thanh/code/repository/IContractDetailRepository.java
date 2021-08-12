package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import thanh.code.models.ContractDetail;

import javax.transaction.Transactional;
import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query("select x from ContractDetail as x WHERE x.contract.contractId = ?1")
    List<ContractDetail> listContractDetailOfOnePeople(int contractId);

    @Transactional
    @Modifying
    @Query("delete from ContractDetail as x where x.contractDetailId = ?1 and x.contract.contractId = ?2")
    void deleteDetailOneRecord(int contractDetailId, int contractId);

}
