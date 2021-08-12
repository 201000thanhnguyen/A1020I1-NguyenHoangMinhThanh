package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
