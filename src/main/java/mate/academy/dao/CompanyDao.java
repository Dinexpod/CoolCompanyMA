package mate.academy.dao;

import mate.academy.models.Company;

import java.util.List;

public interface CompanyDao {

    void addCompany(Company company);

    void updateCompanyById(Company company);

    void deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    List<Company> showAllCompany();
}
