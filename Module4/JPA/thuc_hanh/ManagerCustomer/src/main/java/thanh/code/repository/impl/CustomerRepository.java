package thanh.code.repository.impl;

import org.springframework.stereotype.Repository;
import thanh.code.models.Customer;
import thanh.code.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> listEntity() {
        TypedQuery<Customer> typedQuery = this.entityManager.createQuery("select s from Customer as s", Customer.class);
        return typedQuery.getResultList();
    }
}
