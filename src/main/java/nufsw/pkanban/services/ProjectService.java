package nufsw.pkanban.services;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.exceptions.ProjectIdException;
import nufsw.pkanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Siqueira
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception ex) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() +
                    "' already exists and must be unique");
        }
    }

    public Project findProjectByIdentifier(String identifier){

        Project project = projectRepository.findByProjectIdentifier(identifier.toUpperCase());
        if(project == null)
            throw new ProjectIdException("Project ID '" + identifier + "' does not exists");

        return project;
    }

}
