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

    @Override
    public String addEntity(Customer customer) {
        String msg = null;
        try {
            this.entityManager.persist(customer);
            msg = "add success";
        }catch (Exception e){
            msg = e.toString();
        }
        return msg;
    }

    @Override
    public Customer detailEntity(int id) {
        return this.entityManager.find(Customer.class, id);
    }

    @Override
    public String deleteEntity(int id) {
        String msg = null;
        try {
            this.entityManager.remove(detailEntity(id));
            msg = "delete success" ;
        }catch (Exception e){
            msg = e.toString();
        }
        return msg;
    }

    @Override
    public String editEntity(Customer customer) {
        String msg = null;
        try {
            this.entityManager.merge(customer);
            msg = "edit success";
        }catch (Exception e){
            msg = e.toString();
        }
        return msg;
    }
}
