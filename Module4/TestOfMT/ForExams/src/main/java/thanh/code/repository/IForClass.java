package thanh.code.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import thanh.code.models.ForClass;

import javax.transaction.Transactional;
import java.util.List;

public interface IForClass extends JpaRepository<ForClass, Integer> {

    //DEMO

    //syntax select query
    @Query("select x from ForClass as x order by x.forName desc ")
    Page<ForClass> listLimitForClass(Pageable pageable);

    //syntax select query have parameter
    @Query("select x from ForClass as x WHERE x.forName = ?1")
    List<ForClass> listLimitForClass(String forName);

    //multi parameter
    //syntax make change data in sql
    //same with method other like create, update
    @Transactional
    @Modifying
    @Query("delete from ForClass as x where x.forId = ?1 and x.forName = ?2")
    void deleteByMultiParameter(int forId, String forName);

    //
}
