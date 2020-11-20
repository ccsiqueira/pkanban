package nufsw.pkanban.web;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Siqueira
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        if (result.hasErrors())
            return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);

        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
    }
}
