package nufsw.pkanban.web;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.services.ProjectService;
import nufsw.pkanban.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Siqueira
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap = validationService.validate(result);
        if(errorMap != null) return errorMap;

        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable("identifier") String identifier){

        Project project = projectService.findProjectByIdentifier(identifier);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProjects(){
        List<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
}
