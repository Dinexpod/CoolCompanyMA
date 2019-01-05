package dao;

import models.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl extends AbstractDao implements CompanyDao {
    public CompanyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCompany(Company company) {
        final  String INSERT = "INSERT INTO companies(name, type) VALUES(?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, company.getName());
            statement.setString(2, company.getType().name());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompanyById(Company company) {
        final String UPDATE =
                "UPDATE companies SET name=?, type=? WHERE company_id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, company.getName());
            statement.setString(2, company.getType().name());
            statement.setLong(3, company.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompanyById(Long id) {
        final String DEL = "DELETE FROM companies WHERE company_id=?";
        final String DEL_FROM_PROJECT = "DELETE FROM companies_projects WHERE company=?";

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
    public Company getCompanyById(Long id) {
        final String SELECT = "SELECT * FROM companies WHERE company_id = " + id + "";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT);
            return rs.next() ? getCompany(rs) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
//??????????????????????????????????????????????
        return null;
    }

    private Company getCompany(ResultSet rs) throws SQLException {
        Company company = new Company();
        company.setId(rs.getLong("company_id"));
        company.setName(rs.getString("name"));
        //        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Company.Type.valueOf(rs.getString("type"));

        return company;
    }

    @Override
    public List<Company> showAllCompany() {
        final String FIND_ALL = "SELECT * FROM companies";

        List<Company> companies = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Company company = getCompany(rs);
                companies.add(company);
            }

            return companies;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;
    }
}
