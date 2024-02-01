package bakyt.services;

import bakyt.entities.Project;

import java.util.Optional;

public interface ProjectService {
    void assignProjectToCompany(Long companyId, Project project);
    Optional<Project> getProjectById(Long id);
}
