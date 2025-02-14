package quad.assignmentbackend.api.question.answer.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quad.assignmentbackend.trivia.TriviaQuestionsService;

@RestController
@RequestMapping("/api")
public class QuestionAnswerGetController {

    private final TriviaQuestionsService service;

    @Autowired
    public QuestionAnswerGetController(TriviaQuestionsService service) {
        this.service = service;
    }

    @GetMapping("/questions/{questionId}/answers/{answerId}")
    public Response getQuestionAnswer(
            @PathVariable("questionId") String questionId,
            @PathVariable("answerId") String answerId) {

        Boolean isValid = service.validateAnswer(questionId, answerId);

        return new Response(isValid);
    }
}
