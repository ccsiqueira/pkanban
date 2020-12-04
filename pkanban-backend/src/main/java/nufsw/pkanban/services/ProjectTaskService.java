package nufsw.pkanban.services;

import nufsw.pkanban.domain.ProjectTask;
import nufsw.pkanban.repository.BacklogRepository;
import nufsw.pkanban.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Siqueira
 */
@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(){
        // TODO

        return null;
    }
}
