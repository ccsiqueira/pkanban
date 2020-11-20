package nufsw.pkanban.services;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.repository.ProjectRepository;
import org.hibernate.criterion.ProjectionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Siqueira
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        return projectRepository.save(project);
    }

}
