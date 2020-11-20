package nufsw.pkanban.repository;

import nufsw.pkanban.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
*
* @author Siqueira
*/

@RestResource(path = "projects", rel = "projects")
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectIdentifier(String identifier);

}