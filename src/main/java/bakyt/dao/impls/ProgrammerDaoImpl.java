package bakyt.dao.impls;

import bakyt.config.DatabaseConnection;
import bakyt.dao.GeneralDao;
import bakyt.dao.ProgrammerDao;
import bakyt.entities.Programmer;
import bakyt.entities.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Optional;

public class ProgrammerDaoImpl implements ProgrammerDao, GeneralDao<Programmer> {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();

    @Override
    public void save(Programmer programmer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(programmer);
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
    public void update(Long id, Programmer updatedProgrammer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Programmer existingProgrammer = entityManager.find(Programmer.class, id);
            if (existingProgrammer != null) {
                existingProgrammer.setFullName(updatedProgrammer.getFullName());
                existingProgrammer.setEmail(updatedProgrammer.getEmail());
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
            Programmer programmer = entityManager.find(Programmer.class, id);
            if (programmer != null) {
                entityManager.remove(programmer);
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
    public void assignProgrammersToProject(Long programmerId, Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Programmer programmer = entityManager.find(Programmer.class, programmerId);
            Project project = entityManager.find(Project.class, projectId);

            if (programmer != null && project != null) {
                project.getProgrammers().add(programmer);
                entityManager.merge(project);
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
    public Optional<Programmer> getProgrammerById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Programmer programmer = null;
        try {
            entityManager.getTransaction().begin();
            programmer = entityManager.find(Programmer.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(programmer);
    }
}
