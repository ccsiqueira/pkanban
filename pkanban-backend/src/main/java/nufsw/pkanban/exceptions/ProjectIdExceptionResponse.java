package nufsw.pkanban.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Siqueira
 */
@Setter @Getter
public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public ProjectIdExceptionResponse(String pId){
        this.projectIdentifier = pId;
    }


}
