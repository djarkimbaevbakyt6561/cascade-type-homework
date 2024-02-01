package bakyt.services.impls;

import bakyt.dao.impls.ProgrammerDaoImpl;
import bakyt.entities.Programmer;
import bakyt.services.GeneralService;
import bakyt.services.ProgrammerService;

import java.util.Optional;

public class ProgrammerServiceImpl implements ProgrammerService, GeneralService<Programmer> {
    ProgrammerDaoImpl programmerDao = new ProgrammerDaoImpl();
    @Override
    public void save(Programmer programmer) {
        programmerDao.save(programmer);
    }

    @Override
    public void update(Long id, Programmer programmer) {
        programmerDao.update(id, programmer);
    }

    @Override
    public void delete(Long id) {
        programmerDao.delete(id);
    }

    @Override
    public void assignProgrammersToProject(Long programmerId, Long projectId) {
        programmerDao.assignProgrammersToProject(programmerId, projectId);
    }

    @Override
    public Optional<Programmer> getProgrammerById(Long id) {
        return programmerDao.getProgrammerById(id);
    }
}
