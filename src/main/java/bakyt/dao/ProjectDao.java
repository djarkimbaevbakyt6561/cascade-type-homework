package bakyt.dao;

import bakyt.entities.Project;

import java.util.Optional;

public interface ProjectDao {
    void assignProjectToCompany(Long companyId, Project project);
    Optional<Project> getProjectById(Long id);
}
