package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
}
