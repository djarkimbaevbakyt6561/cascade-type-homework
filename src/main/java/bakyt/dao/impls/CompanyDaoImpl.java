package bakyt.dao.impls;

import bakyt.config.DatabaseConnection;
import bakyt.dao.CompanyDao;
import bakyt.dao.GeneralDao;
import bakyt.entities.Address;
import bakyt.entities.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao, GeneralDao<Company> {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();

    @Override
    public void assignCompanyToAddress(Long companyId, Long addressId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Company company = entityManager.find(Company.class, companyId);
            Address address = entityManager.find(Address.class, addressId);

            if (company != null && address != null) {
                company.setAddress(address);
                entityManager.merge(address);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Company company = null;
        try {
            entityManager.getTransaction().begin();
            company = entityManager.find(Company.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(company);
    }

    @Override
    public void save(Company company) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Long id, Company updatedCompany) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Company existingCompany = entityManager.find(Company.class, id);
            if (existingCompany != null) {
                existingCompany.setName(updatedCompany.getName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Company company = entityManager.find(Company.class, id);
            if (company != null) {
                entityManager.remove(company);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
