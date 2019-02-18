package mate.academy.services;

import mate.academy.models.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    List<Customer> showAllCustomer();
}
