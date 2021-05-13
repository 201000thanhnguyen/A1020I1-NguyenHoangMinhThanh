package Models.Repository;

import Models.Bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> listCustomer();

    String addCustomer(Customer customer);

    String deleteCustomer(String idCustomer);

    String editCustomer(String idCustomer, String nameCustomer, int ageCustomer, int genderCustomer, String avatarCustomer);

    String detailCustomer(String idCustomer);

}
