package dao;

import models.Customer;

import java.sql.Connection;
import java.util.Set;

public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomerById(Customer customer) {

    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public Set<Customer> showAllCustomer() {
        return null;
    }
}
