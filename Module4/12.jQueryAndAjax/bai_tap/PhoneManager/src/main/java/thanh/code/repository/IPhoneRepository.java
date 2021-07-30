package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Phone;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}
