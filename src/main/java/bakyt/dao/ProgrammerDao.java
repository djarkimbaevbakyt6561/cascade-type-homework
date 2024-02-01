package bakyt.dao;

import bakyt.entities.Programmer;

import java.util.Optional;

public interface ProgrammerDao {
    void assignProgrammersToProject(Long programmerId, Long projectId);
    Optional<Programmer> getProgrammerById(Long id);
}
