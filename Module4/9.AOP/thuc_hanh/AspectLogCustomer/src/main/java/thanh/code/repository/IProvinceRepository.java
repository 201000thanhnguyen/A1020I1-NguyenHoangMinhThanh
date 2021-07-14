package thanh.code.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import thanh.code.models.Province;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
