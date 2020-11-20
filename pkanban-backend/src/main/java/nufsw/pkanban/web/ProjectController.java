package nufsw.pkanban.web;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.services.ProjectService;
import nufsw.pkanban.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

        Project savedProject = projectService.saveProject(project);
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

    @DeleteMapping("/{identifier}")
    public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable("identifier") String identifier){
        projectService.deleteProjectByIdentifier(identifier.toUpperCase());
        return new ResponseEntity<String>("Project with ID '"+identifier+"' was deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = validationService.validate(result);
        if(errorMap != null) return errorMap;

        Project updatedProject = projectService.updateProject(project);
        return new ResponseEntity<Project>(updatedProject, HttpStatus.OK);
    }
}
