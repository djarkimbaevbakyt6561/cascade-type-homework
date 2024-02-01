package bakyt.services;

import bakyt.entities.Programmer;

import java.util.Optional;

public interface ProgrammerService {
    void assignProgrammersToProject(Long programmerId, Long projectId);
    Optional<Programmer> getProgrammerById(Long id);
}
