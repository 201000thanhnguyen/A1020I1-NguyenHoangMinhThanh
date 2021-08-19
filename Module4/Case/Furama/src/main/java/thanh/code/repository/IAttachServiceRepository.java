package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.AttachService;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {

}
