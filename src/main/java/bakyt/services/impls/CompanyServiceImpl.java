package bakyt.services.impls;

import bakyt.dao.impls.AddressDaoImpl;
import bakyt.dao.impls.CompanyDaoImpl;
import bakyt.entities.Company;
import bakyt.services.CompanyService;
import bakyt.services.GeneralService;

import java.util.Optional;

public class CompanyServiceImpl implements CompanyService, GeneralService<Company> {
    CompanyDaoImpl companyDao = new CompanyDaoImpl();
    AddressDaoImpl addressDao = new AddressDaoImpl();

    @Override
    public void assignCompanyToAddress(Long companyId, Long addressId) {
        companyDao.assignCompanyToAddress(companyId, addressId);
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void save(Company company) {
        companyDao.save(company);
    }

    @Override
    public void update(Long id, Company company) {
        companyDao.update(id, company);
    }

    @Override
    public void delete(Long id) {
        companyDao.delete(id);
    }
}
