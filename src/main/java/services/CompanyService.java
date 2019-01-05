package services;

import models.Company;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    void addCompany(Company company);

    void updateCompanyById(Company company);

    void deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    List<Company> showAllCompany();
}
