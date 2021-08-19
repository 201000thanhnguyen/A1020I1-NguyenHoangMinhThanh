package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Promotion;

@Repository
public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
}
