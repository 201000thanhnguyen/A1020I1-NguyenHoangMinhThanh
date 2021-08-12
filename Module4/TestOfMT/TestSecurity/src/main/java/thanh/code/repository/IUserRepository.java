package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.User;

public interface IUserRepository extends JpaRepository<User, String> {
}
