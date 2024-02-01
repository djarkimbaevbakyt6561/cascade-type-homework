package bakyt.dao.impls;

import bakyt.config.DatabaseConnection;
import bakyt.dao.AddressDao;
import bakyt.dao.GeneralDao;
import bakyt.entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Optional;

public class AddressDaoImpl implements AddressDao, GeneralDao<Address> {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();

    @Override
    public Optional<Address> getAddressById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Address address = null;
        try {
            entityManager.getTransaction().begin();
            address = entityManager.createQuery("select a from Address a where a.id = :parId", Address.class)
                    .setParameter("parId", id)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(address);
    }

    @Override
    public void save(Address address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(address);
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
    public void update(Long id, Address updatedAddress) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Address existingAddress = entityManager.find(Address.class, id);
            if (existingAddress != null) {
                existingAddress.setCountry(updatedAddress.getCountry());
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
            Address address = getAddressById(id).orElseThrow(()->new RuntimeException("Address with this id is not found!"));
            entityManager.remove(address);
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
