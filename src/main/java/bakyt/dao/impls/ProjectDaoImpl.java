package bakyt.dao.impls;

import bakyt.config.DatabaseConnection;
import bakyt.dao.GeneralDao;
import bakyt.dao.ProjectDao;
import bakyt.entities.Company;
import bakyt.entities.Project;
import bakyt.entities.Programmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Optional;

public class ProjectDaoImpl implements ProjectDao, GeneralDao<Project> {
    private final EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManagerFactory();

    @Override
    public void save(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(project);
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
    public void update(Long id, Project updatedProject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Project existingProject = entityManager.find(Project.class, id);
            if (existingProject != null) {
                existingProject.setTitle(updatedProject.getTitle());
                // Обновление других полей, если есть
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
            Project project = entityManager.find(Project.class, id);
            if (project != null) {
                entityManager.remove(project);
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
    public void assignProjectToCompany(Long companyId, Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Company company = entityManager.find(Company.class, companyId);
            if (company != null) {
                project.setCompany(company);
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
    public Optional<Project> getProjectById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Project project = null;
        try {
            entityManager.getTransaction().begin();
            project = entityManager.find(Project.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(project);
    }
}
