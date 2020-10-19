package qdo_ln.light_system_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qdo_ln.light_system_testing.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
