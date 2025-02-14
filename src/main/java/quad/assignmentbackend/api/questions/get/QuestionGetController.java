package quad.assignmentbackend.api.questions.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quad.assignmentbackend.trivia.models.TriviaQuestion;
import quad.assignmentbackend.trivia.TriviaQuestionsService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuestionGetController {

    private final TriviaQuestionsService service;

    @Autowired
    public QuestionGetController(TriviaQuestionsService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public List<Response> getQuestions(@RequestParam(required = false) Optional<Integer> count) {

        List<TriviaQuestion> questions = service.getQuestions(count.orElse(1));

        List<Response> response = questions.stream()
                .map(question -> new Response(
                        question.questionId(),
                        question.questionType(),
                        question.question(),
                        Arrays.stream(question.answers())
                                .map(answer -> new ResponseAnswer(answer.answerId(), answer.answer()))
                                .toArray(ResponseAnswer[]::new)
                ))
                .toList();

        return response;
    }
}
