package nufsw.pkanban.repository;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.domain.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Siqueira
 */

@RestResource(path = "projectTasks", rel = "projectTasks")
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    ProjectTask findByProjectIdentifier(String identifier);

}