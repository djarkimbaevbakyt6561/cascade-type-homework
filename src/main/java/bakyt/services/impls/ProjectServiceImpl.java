package bakyt.services.impls;

import bakyt.dao.ProjectDao;
import bakyt.dao.impls.ProjectDaoImpl;
import bakyt.entities.Programmer;
import bakyt.entities.Project;
import bakyt.services.GeneralService;
import bakyt.services.ProgrammerService;
import bakyt.services.ProjectService;

import java.util.Optional;

public class ProjectServiceImpl implements ProjectService, GeneralService<Project> {
    ProjectDaoImpl projectDao = new ProjectDaoImpl();

    @Override
    public void save(Project project) {
        projectDao.save(project);
    }

    @Override
    public void update(Long id, Project project) {
        projectDao.update(id, project);
    }

    @Override
    public void delete(Long id) {
        projectDao.delete(id);
    }
    @Override
    public void assignProjectToCompany(Long companyId, Project project) {
       projectDao.assignProjectToCompany(companyId, project);
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectDao.getProjectById(id);
    }
}
