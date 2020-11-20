package nufsw.pkanban.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Siqueira
 */

@Entity @Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Project Name must not be null")
    @NotBlank(message = "Project Name is required")
    private String projectName;

    @NotNull(message = "Project Identifier must not be null")
    @NotBlank(message = "Project Identifier is required")
    @Size(min = 4, max = 5, message = "Please, use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotNull(message = "Description must not be null")
    @NotBlank(message = "Description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate endDate;

    @JsonFormat(pattern = "yyyy-mm-dd hh:MM:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-mm-dd hh:MM:ss")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
