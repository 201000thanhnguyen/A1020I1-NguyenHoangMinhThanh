package Models.Repository.impl;

import Models.Bean.Customer;
import Models.Repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepository implements ICustomerRepository {

    static List<Customer> allCustomer = new ArrayList<>();

    static {
        allCustomer.add(new Customer(UUID.randomUUID().toString(), "khách hàng 1", 21, 0, "none"));
        allCustomer.add(new Customer(UUID.randomUUID().toString(), "khách hàng 2", 25, 1, "none"));
        allCustomer.add(new Customer(UUID.randomUUID().toString(), "khách hàng 3", 30, 1, "none"));
    }

    @Override
    public List<Customer> listCustomer() {
        return allCustomer;
    }

    @Override
    public String addCustomer(Customer customer) {
        try {
            allCustomer.add(customer);
            return "add success";
        }catch (Exception e){
            return "add fail";
        }
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
