package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Contract;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

}
