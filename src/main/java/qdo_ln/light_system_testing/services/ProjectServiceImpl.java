package qdo_ln.light_system_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdo_ln.light_system_testing.dto.ProjectDTO;
import qdo_ln.light_system_testing.entities.Project;
import qdo_ln.light_system_testing.repositories.ProjectRepository;
import qdo_ln.light_system_testing.services.intefeces.ProjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<ProjectDTO> findAllDTO() {
        List<Project> projects = findAll();
        List<ProjectDTO> projectsDTO = new ArrayList<>(projects.size());
        for (Project p: projects) {
            projectsDTO.add(new ProjectDTO(p));
        }
        return projectsDTO;
    }


}
