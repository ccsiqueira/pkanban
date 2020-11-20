package nufsw.pkanban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"nufsw.pkanban.repository"})
@SpringBootApplication
public class PkanbanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkanbanApplication.class, args);
    }

}
