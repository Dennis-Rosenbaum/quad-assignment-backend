package quad.assignmentbackend.api.checkanswers.post;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckanswersPostController {

    private final CheckanswersPostService service;

    @Autowired
    public CheckanswersPostController(CheckanswersPostService service) {
        this.service = service;
    }

    @PostMapping("/checkanswers")
    public Model postCheckAnswers(@RequestBody @Valid Request request) {

        Boolean isValid = service.validateAnswer(request);

        return new Model(isValid);
    }
}
