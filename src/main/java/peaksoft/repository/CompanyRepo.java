package peaksoft.repository;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyRepo {
    void saveCompany(Company company);
    Company getById(Long id);
    List<Company> getAllCompany();
    void  updateById(Long id,Company newCompany);
    void deleteCompanyById(Long id);
}
