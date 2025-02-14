package quad.assignmentbackend.api.question.answer.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quad.assignmentbackend.trivia.TriviaQuestionsService;

@RestController
@RequestMapping("/api")
public class QuestionAnswerGetController {

    private final TriviaQuestionsService service;
    private final String apiKey;

    @Autowired
    public QuestionAnswerGetController(TriviaQuestionsService service, @Value("${api_key}") String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    @GetMapping("/questions/{questionId}/answers/{answerId}")
    public Response getQuestionAnswer(
            @PathVariable("questionId") String questionId,
            @PathVariable("answerId") String answerId,
            @RequestParam("apiKey") String key) throws IllegalAccessException {

        if (!key.equals(apiKey))
            throw new IllegalAccessException("Invalid API key");

        Boolean isValid = service.validateAnswer(questionId, answerId);

        return new Response(isValid);
    }
}
