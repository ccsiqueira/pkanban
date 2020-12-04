package nufsw.pkanban.repository;

import nufsw.pkanban.domain.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Siqueira
 */

@RestResource(path = "backlogs", rel = "backlogs")
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String identifier);

}