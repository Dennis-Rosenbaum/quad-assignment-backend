package quad.assignmentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quad Assignment API", version = "1.0", description = "API Documentation for trivia questions"))
@PropertySource(value = "classpath:application-ci.properties", ignoreResourceNotFound = true)
public class QuadAssessmentBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuadAssessmentBackendApplication.class, args);
    }

}
