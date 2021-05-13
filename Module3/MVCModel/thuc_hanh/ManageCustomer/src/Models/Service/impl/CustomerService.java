package Models.Service.impl;

import Models.Bean.Customer;
import Models.Repository.ICustomerRepository;
import Models.Repository.impl.CustomerRepository;
import Models.Service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    ICustomerRepository repository = new CustomerRepository();

    @Override
    public List<Customer> listCustomer() {
        return repository.listCustomer();
    }

    @Override
    public String addCustomer(Customer customer) {
        String msg = repository.addCustomer(customer);
        return msg;
    }

    @Override
    public String deleteCustomer(String idCustomer) {
        return null;
    }

    @Override
    public String editCustomer(String idCustomer, String nameCustomer, int ageCustomer, int genderCustomer, String avatarCustomer) {
        return null;
    }

    @Override
    public String detailCustomer(String idCustomer) {
        return null;
    }
}
