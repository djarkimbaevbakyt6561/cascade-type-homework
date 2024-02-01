package bakyt.services;

import bakyt.entities.Company;

import java.util.Optional;

public interface CompanyService {
    void assignCompanyToAddress(Long companyId, Long addressId);
    Optional<Company> getCompanyById(Long id);
}
