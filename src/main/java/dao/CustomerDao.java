package dao;

import models.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    void updateCustomerById(Customer customer);

    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    List<Customer> showAllCustomer();
}
