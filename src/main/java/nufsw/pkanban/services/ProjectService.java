package nufsw.pkanban.services;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.exceptions.ProjectIdException;
import nufsw.pkanban.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Siqueira
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
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

    public List<Project> findAllProjects(){
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    public void deleteProjectByIdentifier(String identifier){
        Project project = findProjectByIdentifier(identifier);
        projectRepository.delete(project);
    }

}
