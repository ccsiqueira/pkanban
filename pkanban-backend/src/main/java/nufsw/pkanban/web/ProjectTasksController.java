package nufsw.pkanban.web;

import nufsw.pkanban.domain.Project;
import nufsw.pkanban.domain.ProjectTask;
import nufsw.pkanban.services.ProjectService;
import nufsw.pkanban.services.ProjectTaskService;
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
@RequestMapping("/api/projectTasks")
@CrossOrigin
public class ProjectTasksController {

    @Autowired
    private ProjectTaskService projectService;

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> createProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        //TODO
        return null;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<?> getProjectTaskByIdentifier(@PathVariable("identifier") String identifier) {
        //TODO
        return null;
    }

    @GetMapping
    public ResponseEntity<?> getAllProjects() {
        // TODO
        return null;
    }

    @DeleteMapping("/{identifier}")
    public ResponseEntity<?> deleteProjectTaskByIdentifier(@PathVariable("identifier") String identifier) {
        //TODO
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        ResponseEntity<?> errorMap = validationService.validate(result);
        if (errorMap != null)
            return errorMap;

        //TODO
        return null;
    }
}
