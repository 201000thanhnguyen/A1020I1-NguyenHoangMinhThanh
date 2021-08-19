package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {

    List<Service> findServiceByServiceTypeServiceTypeName(@NotBlank String serviceType_serviceTypeName);
}
