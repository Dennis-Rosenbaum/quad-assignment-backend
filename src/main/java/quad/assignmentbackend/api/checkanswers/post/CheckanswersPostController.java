package quad.assignmentbackend.api.checkanswers.post;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quad.assignmentbackend.trivia.TriviaQuestionsService;

@RestController
@RequestMapping("/api")
public class CheckanswersPostController {

    private final TriviaQuestionsService service;

    @Autowired
    public CheckanswersPostController(TriviaQuestionsService service) {
        this.service = service;
    }

    /**
     * As per specification this has been added
     * @param request question and answer to validate the answer
     * @return a model with the result if the provided answer is correct
     * @deprecated I suggest we remove this method as it is better to use the RESTfull variant api.question.answer.get.QuestionAnswerGetController.getQuestionAnswer() }
     */
    @PostMapping("/checkanswers")
    public Response postCheckAnswers(@RequestBody @Valid Request request) {

        Boolean isValid = service.validateAnswer(request.getQuestionId(), request.getAnswerId());

        return new Response(isValid);
    }
}
