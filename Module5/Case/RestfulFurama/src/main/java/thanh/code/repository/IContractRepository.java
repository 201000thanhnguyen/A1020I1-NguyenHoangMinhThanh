package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

}
