package Models.Service;

import Models.Bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomer();

    String addCustomer(Customer customer);

    String deleteCustomer(String idCustomer);

    String editCustomer(String idCustomer, String nameCustomer, int ageCustomer, int genderCustomer, String avatarCustomer);

    String detailCustomer(String idCustomer);
}
