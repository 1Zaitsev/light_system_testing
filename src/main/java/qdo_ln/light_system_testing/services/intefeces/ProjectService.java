package qdo_ln.light_system_testing.services.intefeces;

import qdo_ln.light_system_testing.dto.ProjectDTO;
import qdo_ln.light_system_testing.entities.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();

    List<ProjectDTO> findAllDTO();
}
