package mate.academy.services;

import mate.academy.dao.CompanyDao;
import mate.academy.models.Company;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void addCompany(Company company) {
        this.companyDao.addCompany(company);
    }

    @Override
    public void updateCompanyById(Company company) {
        this.companyDao.updateCompanyById(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        this.companyDao.deleteCompanyById(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.companyDao.getCompanyById(id);
    }

    @Override
    public List<Company> showAllCompany() {
        return this.companyDao.showAllCompany();
    }
}
