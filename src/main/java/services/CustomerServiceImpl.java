package services;

import dao.CustomerDao;
import models.Customer;

import java.util.Set;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customerDao.addCustomer(customer);
    }

    @Override
    public void updateCustomerById(Long id) {
        this.customerDao.updateCustomerById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerDao.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return this.customerDao.getCustomerById(id);
    }

    @Override
    public Set<Customer> showAllCustomer() {
        return this.customerDao.showAllCustomer();
    }
}
