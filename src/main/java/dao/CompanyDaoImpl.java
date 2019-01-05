package dao;

import models.Company;

import java.sql.Connection;
import java.util.Set;

public class CompanyDaoImpl extends AbstractDao implements CompanyDao {
    public CompanyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompanyById(Company company) {

    }

    @Override
    public void deleteCompanyById(Long id) {

    }

    @Override
    public Company getCompanyById(Long id) {
        return null;
    }

    @Override
    public Set<Company> showAllCompany() {
        return null;
    }
}
