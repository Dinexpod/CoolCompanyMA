package services;

import models.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    List<Customer> showAllCustomer();
}
