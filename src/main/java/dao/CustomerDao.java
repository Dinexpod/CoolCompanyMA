package dao;

import models.Customer;

import java.util.Set;

public interface CustomerDao {
    void addCustomer(Customer customer);

    void updateCustomerById(Long id);

    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    Set<Customer> showAllCustomer();
}
