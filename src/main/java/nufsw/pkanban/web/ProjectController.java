package nufsw.pkanban.web;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Siqueira
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){
        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
    }
}
