package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
