package mate.academy.dao;

import mate.academy.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCustomer(Customer customer) {
        final String INSERT = "INSERT INTO customers(name, age) VALUES(?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomerById(Customer customer) {
        final String UPDATE =
                "UPDATE customers SET name=?, age=? WHERE customer_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setLong(3, customer.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomerById(Long id) {
        final String DEL = "DELETE FROM customers WHERE customer_id=?";
        final String DEL_FROM_PROJECT = "DELETE FROM customers_projects WHERE customer=?";

        try {
            PreparedStatement statement = connection.prepareStatement(DEL);
            statement.setLong(1, id);

            statement.execute();

            statement = connection.prepareStatement(DEL_FROM_PROJECT);
            statement.setLong(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        final String SELECT = "SELECT * FROM customers WHERE customer_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);

            return rs.next() ? getCustomer(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Customer getCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("customer_id"));
        customer.setName(rs.getString("name"));
        customer.setAge(rs.getInt("age"));

        return customer;
    }

    @Override
    public List<Customer> showAllCustomer() {
        final String FIND_ALL = "SELECT * FROM customers";

        List<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Customer customer = getCustomer(rs);
                customers.add(customer);
            }

            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
