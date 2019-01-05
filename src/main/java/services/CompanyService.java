package services;

import models.Company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);

    void updateCompanyById(Company company);

    void deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    List<Company> showAllCompany();
}
