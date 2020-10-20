package qdo_ln.light_system_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdo_ln.light_system_testing.entities.Project;
import qdo_ln.light_system_testing.repositories.ProjectRepository;
import qdo_ln.light_system_testing.services.intefeces.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
