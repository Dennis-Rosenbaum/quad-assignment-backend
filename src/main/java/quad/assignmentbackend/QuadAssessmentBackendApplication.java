package quad.assignmentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application-ci.properties", ignoreResourceNotFound = true)
public class QuadAssessmentBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuadAssessmentBackendApplication.class, args);
    }

}
