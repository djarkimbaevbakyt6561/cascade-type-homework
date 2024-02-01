package bakyt.dao;

import bakyt.entities.Company;

import java.util.Optional;

public interface CompanyDao {
   void assignCompanyToAddress(Long companyId, Long addressId);
   Optional<Company> getCompanyById(Long id);
}
