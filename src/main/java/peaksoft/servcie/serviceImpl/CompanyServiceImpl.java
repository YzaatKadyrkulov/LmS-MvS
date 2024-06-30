package peaksoft.servcie.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepo;
import peaksoft.servcie.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;

    @Override
    public void saveCompany(Company company) {
        companyRepo.saveCompany(company);
    }

    @Override
    public Company getById(Long id) {
        return companyRepo.getById(id);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepo.getAllCompany();
    }

    @Override
    public void updateById(Long id, Company newCompany) {
        companyRepo.updateById(id, newCompany);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepo.deleteCompanyById(id);
    }
}
